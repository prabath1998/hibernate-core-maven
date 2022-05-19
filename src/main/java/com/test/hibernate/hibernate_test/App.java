package com.test.hibernate.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(102);
		laptop.setLname("Mac");
		
		
		Student s = new Student();
		s.setRollno(3);
		s.setName("Tom");
		s.setMarks(85);
		s.getLaptop().add(laptop);
		
		laptop.getStudent().add(s);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(laptop);
        session.save(s);
//		prabath = session.get(Alien.class, 105);
		tx.commit();

	
	}
}
