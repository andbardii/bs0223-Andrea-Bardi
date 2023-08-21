package com.epicode.forum.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.forum.security.entity.Answer;
import com.epicode.forum.security.entity.User;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
