package com.map.entities.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Integer answerId;
	private String answer;
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question2 question;
	
	public Answer2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer2(String answer) {
		super();
		this.answer = answer;
	}
	
	public Answer2(Integer answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question2 getQuestion() {
		return question;
	}
	public void setQuestion(Question2 question) {
		this.question = question;
	}
	
}
