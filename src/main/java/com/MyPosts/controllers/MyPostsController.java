package com.MyPosts.controllers;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import com.MyPosts.entity.User;
import com.MyPosts.entity.Post;
import com.MyPosts.services.PostService;
import com.MyPosts.services.UserService;


@RestController
public class MyPostsController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postsService;


	@RequestMapping(method = RequestMethod.GET, value = "/api/posts/helloPage")
	public String sayHello() {
		return "Say Hello";
	}

	@RequestMapping(value = "/api/posts/createNewUser", method = RequestMethod.POST)
	public void createnewUser(@RequestParam String password,
			@RequestParam String userName, @RequestParam String email) {
		userService.createNewUser(password, userName, email);

	}

	@RequestMapping(value = "/api/posts/userlogin", method = RequestMethod.POST)
	public ModelAndView  userlogin(@RequestParam () String password,
			@RequestParam String userName, HttpServletRequest request) {
		userService.userlogin(password, userName, request);
		return new ModelAndView("redirect:" + "/api/posts/getUserPosts");
	}

	@RequestMapping(value = "/api/posts/getAllUsers.html", method = RequestMethod.GET)
	public List<User> getAllUsers(HttpServletRequest request) {
		return userService.getAllUsers(request);
	}

	//TODO make status one of PUBLIC or PRIVATE
	@RequestMapping(value = "/api/posts/createNewPost", method = RequestMethod.POST)
	public String createNewPost(@RequestParam String post,
			@RequestParam String status, HttpServletRequest request) throws Exception{
		return postsService.createNewPost(post, status, request);
	}

	@RequestMapping(value = "/api/posts/getUserPosts", method = RequestMethod.GET)
	public List<Post> getUserPosts(HttpServletRequest request)  {
		return postsService.getUserPosts(request);

	}

	@RequestMapping(value = "/api/posts/search", method = RequestMethod.POST)
	public List<Post> searchPost(HttpServletRequest request,
			@RequestParam String str) {
		return postsService.searchPost(request, str);

	}

}