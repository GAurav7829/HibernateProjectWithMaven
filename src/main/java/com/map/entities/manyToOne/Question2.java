package com.map.entities.manyToOne;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Integer questionId;
	private String question;
	@OneToMany(mappedBy = "question")
	private List<Answer2> answers;
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Answer2> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer2> answers) {
		this.answers = answers;
		this.answers.iterator().forEachRemaining(answer->answer.setQuestion(this));
	}
	
	public Question2(String question, List<Answer2> answers) {
		super();
		this.question = question;
		this.answers = answers;
		this.answers.iterator().forEachRemaining(answer->answer.setQuestion(this));
	}
	public Question2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
