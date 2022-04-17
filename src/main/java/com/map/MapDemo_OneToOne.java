package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.entities.oneToOne.Answer;
import com.map.entities.oneToOne.Question;

public class MapDemo_OneToOne {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating question
		Answer answer1 = new Answer("Java is a programming language");
		Question question1 = new Question("What is Java?", answer1);
		Answer answer2 = new Answer("Javascript is a scripting language");
		Question question2 = new Question("What is Javascript?", answer2);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(answer1);
		session.save(answer2);
		session.save(question1);
		session.save(question2);
		
		transaction.commit();
		
		//fetch data
		Question question = session.get(Question.class, 1);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswer().getAnswer());
		
		
		session.close();
		factory.close();
	}

}
