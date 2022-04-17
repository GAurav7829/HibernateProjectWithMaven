package com.map;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.entities.manyToOne.Answer2;
import com.map.entities.manyToOne.Question2;

public class MapDemo_ManyToOne {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating question
		Answer2 answer1 = new Answer2("Java is a programming language");
		Answer2 answer2 = new Answer2("With the help of java we can create softwares");
		
		List<Answer2> answerList = List.of(answer1, answer2);
		
		Question2 question1 = new Question2("What is Java?", answerList);
		
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(answer1);
		session.save(answer2);
		session.save(question1);
		
		transaction.commit();
		
		//fetch data
		Question2 question = session.get(Question2.class, 1);
		System.out.println(question.getQuestion());
		for(Answer2 answer: question.getAnswers()) {
			System.out.println(answer.getAnswer());
		}
		
		session.close();
		factory.close();
	}

}
