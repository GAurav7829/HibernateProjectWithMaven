package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.entities.Certificate;
import com.tut.entities.Student;

public class EmbedDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student student1 = new Student("Rahul", "Ranchi");
		student1.setCertificate(new Certificate("Java", "10"));
		
		Student student2 = new Student("Ravi", "Delhi");
		student2.setCertificate(new Certificate("Python", "7"));
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//save objects
		session.save(student1);
		session.save(student2);
		
		transaction.commit();
		session.close();
		factory.close();
	}

}
