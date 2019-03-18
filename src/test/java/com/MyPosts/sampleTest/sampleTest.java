package com.MyPosts.sampleTest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.MyPosts.data.PostsRepo;
import com.MyPosts.data.UserRepo;
import com.MyPosts.entity.User;
import com.MyPosts.services.PostService;
import com.MyPosts.services.UserService;


@DataJpaTest
public class sampleTest {

	 @Autowired
	private UserService userService;

	@Autowired
    TestEntityManager entityManager;

	@Autowired
	private UserRepo userRepo;
//	@MockBean
//	private PostService postService;
//
//	@MockBean
//	private PostsRepo postRepo;
//
//	@MockBean
//	private HttpServletRequest request;

//	@Before
//	public void before() {
//		System.out.println("Before");
//	}
//
//	@After
//	public void after() {
//		System.out.println("After");
//	}
//
//	@Test (expected = NullPointerException.class)
//	public void samlpeSmokeServiceTest() {
//		userService.createNewUser("password", "username", "email");
//
//	}

//	@Test
//    public void it_should_save_user() {
//        User user = new User();
//        user.setName("test user");
//        user = entityManager.persistAndFlush(user);
//        assertThat(userRepo.findById(user.getId()).get()).isEqualTo(user);
//    }

//	@Test
//	public void testUserNumbers() {
//		assertThat(userService.getAllUsers(request).size()).isEqualTo(1);
//	}
//
//	@Test
//  	public void userFoundwhileLogin() {
//      	assertThat(userService.userlogin("Password", "userName", request))
//      			.isEqualTo("User Found");
//      	
//  	}
//	
//	@Test
//  	public void wrongLogin() {
//      	assertThat(userService.userlogin("xx", "userName", request))
//      			.isEqualTo("No user found");
//  	}
	
//	@Test
//  	public void postcreation() {
//      	try {
//			assertThat(postService.createNewPost("words in post", "Public", request))
//					.isEqualTo("No user found");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//  	}
}
