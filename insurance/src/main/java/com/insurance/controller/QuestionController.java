package com.insurance.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dao.QuestionDao;
import com.insurance.entity.Question;

@RestController
public class QuestionController {
	@Autowired
	QuestionDao questiondao;
	
	// user can ask query
	@PostMapping("user/question/{id}")
	public Question askQuestion(@RequestBody Question question ,@PathVariable int id) {
		return questiondao.save(question);
		
	}
	
	// Admin can list all queries
	@GetMapping("/admin/question")
	public List<Question> listQuestions(){
		return questiondao.findAll();
		
	}
	
	// Admin Answer 
	public ResponseEntity<Question> answerQuestion(@PathVariable int qid, @RequestBody Question question) {
		Optional<Question> optq = questiondao.findById(qid);
		Question q = new Question();
		q = optq.get();

		q.setAnswer(question.getAnswer());
		final Question updatedQuestion = questiondao.save(q);
		return ResponseEntity.ok(updatedQuestion);
		
	}
	
	

}
