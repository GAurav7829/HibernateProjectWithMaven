package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.entities.Address;
import com.tut.entities.Student;

public class FetchDemo {
	public static void main(String[] args) {
		//get , load example
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		//get
		/*
		 * returns null, if object not found in cache memory as well as in db
		 * use if not sure that object exist in db or not
		 * db hits if object doesn't exist in session cache and
		 * 		returns fully initialized object which may involve several db call
		 */
		Student student = session.get(Student.class, 1);	//object saved in cache memory
		System.out.println(student);
		
		Student student1 = session.get(Student.class, 1);	//select query runs only once as object will saved in cache memory
		System.out.println(student1);
		
		//load
		/*
		 * throws ObjectNotFoundException, if object not found in cache memory as well as in db, 
		 * 		never return null
		 * use if you are sure that object exist in db
		 * return proxy object in place
		 * 		only initialize the object or hit db if any method other than getId() is called
		 * 			on persistent or entity object
		 * 		This is called Lazy initialization.
		 * 		increase the performance
		 * use select query only if we use the object
		 */
		session.load(Address.class, 1);
		System.out.println("session.load is called.");
		Address address1 = session.load(Address.class, 1);
		System.out.println("getting data from session cache memory.");
		System.out.println(address1.getCity());	//select query runs when we use the object other that getId
		
		session.close();
		factory.close();
	}
}
