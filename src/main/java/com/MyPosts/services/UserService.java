package com.MyPosts.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.MyPosts.MyPostsApplication;
import com.MyPosts.data.UserRepo;
import com.MyPosts.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepo userData;

	private static final Logger logger = LoggerFactory
			.getLogger(MyPostsApplication.class);

	// Create New User
	public String createNewUser(String password, String userName, String email) {
		try {
			password = BCrypt.hashpw(password,BCrypt.gensalt(4));
			User user = new User(userName, password, email);
			userData.save(user);
			return "User created successfully";
		} catch (Exception e) {

			logger.error("User can't be created!");
			return "User can't be created!";
		}

	}

	// User login with previously created credentials
	public String userlogin(String password, String userName,
			HttpServletRequest request) {
		try {
			List<User> users = new ArrayList<User>();
			users = userData.findAll();
			User tempUser = findUser(password, userName, users);
			if (tempUser != null) {
				request.getSession().setAttribute("user", tempUser);
				System.out.println(tempUser.getId());
				return ("User Found");
			}
			return ("No user found");
		} catch (Exception e) {

			logger.error("User can't Login!");
			return "User can't Login!";
		}
	}

	// Get all created Users
	// TODO Only for admin
	public List<User> getAllUsers(HttpServletRequest request) {
		try {
			List<User> users = new ArrayList<User>();
			users = userData.findAll();
			if (request.getSession() != null)
				System.out.println(((User) request.getSession().getAttribute(
						"user")).getId());

			return users;
		} catch (Exception e) {
			logger.error("User can't Login!");
			throw e;
		}
	}

	// ----------------------Helpers----------------------

	


	// helper function for finding users saved in H2 db
	private User findUser(String password, String userName, List<User> users) {
		for (User user : users) {
			
			if (BCrypt.checkpw(password.toString(), user.getPassword())
					&& user.getName().equals(userName))
				return user;
		}
		return null;
	}

}
