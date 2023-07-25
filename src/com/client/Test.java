package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Student1;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Student1 s=new Student1();
		s.setRollno(1);
		s.setName("xyz");
		s.setAddress("pune");
	session.save(s);
	session.beginTransaction().commit();
	}
}
