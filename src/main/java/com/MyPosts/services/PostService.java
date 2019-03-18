package com.MyPosts.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyPosts.MyPostsApplication;
import com.MyPosts.data.PostsRepo;
import com.MyPosts.entity.Post;
import com.MyPosts.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PostService {
	@Autowired
	private PostsRepo postData;

	private static final Logger logger = LoggerFactory
			.getLogger(MyPostsApplication.class);

	public String createNewPost(String post, String status,
			HttpServletRequest request)throws Exception{
		try{
		Post newPost = new Post(((User) request.getSession().getAttribute(
				"user")).getId(), post, status);
		postData.save(newPost);
		return "Post created";
		}
		catch (Exception e){
			logger.error("Post can't be created");
			throw e;
			
		}
	}

	public List<Post> getUserPosts(HttpServletRequest request){
		try {
			return findPosts(
					((User) request.getSession().getAttribute("user")).getId(),
					postData.findAll());
		} catch (Exception e) {
			logger.error("Posts can't be fetched!");
			throw e;
		}
		

	}



	public List<Post> searchPost(HttpServletRequest request, String str){
		try {
			//if (request != null && request.getSession() != null
			//		&& request.getSession().getAttribute("user") != null) {
				return searchPost(str);

			//}
		
		} catch (Exception e) {
			logger.error("this is a error message");
			throw e;
		}

	}

	
	
	
	
	
	
	
	//----------------------Helpers----------------------
	
	
	//Helper for search
	private List<Post> searchPost(String str) {
		List<Post> posts = postData.findAll();
		List<Post> resultSet = new ArrayList<>();

		String[] strArray = str.split("\\s+");
		if (strArray.length == 0)
			return null;
		for (Post post : posts) {
			boolean equality = true;
			if (post.getStatus().equals("PUBLIC")) {
				for (String testStr : strArray) {
					if (!post.getPost().toLowerCase()
							.contains(testStr.toLowerCase())) {
						equality = false;
						break;
					}
				}
			}
			if (post.getStatus().equals("PUBLIC") && equality)
				resultSet.add(post);
		}
		return resultSet;
	}
	
	
	//Helper to find User's posts
	private List<Post> findPosts(long id, List<Post> posts) {
		List<Post> lst = new ArrayList<>();
		System.out.println("id: " + id);
		for (Post post : posts) {
			System.out.println(post.getUserID());
			if (post.getUserID() == id)
				lst.add(post);
		}
		return lst;
	}
}
