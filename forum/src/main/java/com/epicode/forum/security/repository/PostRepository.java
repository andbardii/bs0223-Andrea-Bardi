package com.epicode.forum.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.forum.security.entity.Post;
import com.epicode.forum.security.entity.User;

public interface PostRepository extends JpaRepository<Post, Long>{

}
