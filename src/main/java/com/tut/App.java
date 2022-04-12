package com.tut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.entities.Address;
import com.tut.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..." );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        	//configure(hibernate.cfg.xml) give path if it is in other location
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        //Creating Student
        Student st = new Student("Sam", "Delhi");
        System.out.println(st);
        
        //Creating Address
        Address ad = new Address("street1", "Delhi", true, 10, new Date(), null);
        	//reading image
        	FileInputStream fis = new FileInputStream(new File("src/main/java/inbox.png"));
        	byte[] data = new byte[fis.available()];
        	fis.read(data);
        ad.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        session.save(ad);
        
//      session.getTransaction().commit();	//OR
        tx.commit();
        
        session.close();
        System.out.println("Done...");
    }
}
