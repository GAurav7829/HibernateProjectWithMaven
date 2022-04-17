package com.map.entities.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Integer answerId;
	private String answer;
	@OneToOne(mappedBy = "answer")
	@JoinColumn(name = "question_id")
	private Question question;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(String answer) {
		super();
		this.answer = answer;
	}
	
	public Answer(Integer answerId, String answer) {
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
