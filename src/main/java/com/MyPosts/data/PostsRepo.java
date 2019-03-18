package com.MyPosts.data;


import org.springframework.data.jpa.repository.JpaRepository;

import com.MyPosts.entity.Post;

import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo extends JpaRepository<Post, Long> {

}

