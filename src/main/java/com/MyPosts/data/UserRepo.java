package com.MyPosts.data;


import org.springframework.data.jpa.repository.JpaRepository;


import com.MyPosts.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {



}

