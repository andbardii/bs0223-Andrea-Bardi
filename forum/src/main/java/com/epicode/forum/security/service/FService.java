package com.epicode.forum.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.forum.security.entity.Answer;
import com.epicode.forum.security.entity.Post;
import com.epicode.forum.security.repository.AnswerRepository;
import com.epicode.forum.security.repository.PostRepository;

@Service
public class FService {

Logger log = LoggerFactory.getLogger(FService.class);
	
	@Autowired PostRepository pDAO;
	@Autowired AnswerRepository aDAO;
	
	@Autowired @Qualifier("post") private ObjectProvider<Post> pProvider;
	@Autowired @Qualifier("answer") private ObjectProvider<Answer> aProvider;
	

	// POST METHODS
	public Post addPost(String question) {
		
			Post p = pProvider.getObject();
			p.setQuestion(question);
			pDAO.save(p);
			log.info("Question saved!");
			return p;
	}
	
	public Post findPById(long id) {
		Post p = pDAO.findById(id).get();
		log.info(p.toString());
		return p;
	}
	
	public List<Post> findAllP(){
		List<Post> l = (List<Post>)pDAO.findAll();
		l.forEach(p -> log.info(p.toString()));
		return l;
	}
	
	// ANSWER METHODS
		public Answer addAnswer(long id, String text) {
			Post p =  pDAO.findById(id).get();
			Answer a = aProvider.getObject();
				a.setText(text);
				aDAO.save(a);
//				List<Answer> l = p.getAnswerList();
//				l.add(a);
//				p.setAnswerList(l);
				log.info("Answer saved!" + a.toString());
//				log.info("POST: " + p.toString());
				return a;
		}
		
		public Answer findAById(long id) {
			Answer a = aDAO.findById(id).get();
			log.info(a.toString());
			return a;
		}
		
		public List<Answer> findAllA(){
			List<Answer> l = (List<Answer>)aDAO.findAll();
			l.forEach(a -> log.info(a.toString()));
			return l;
		}
}
