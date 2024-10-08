package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		//create session
		Session session = factory.getCurrentSession();

		try {

			//start a transaction
			session.beginTransaction();

			//get instructor from db
			int id=1;
			Instructor tempInstructor=session.get(Instructor.class,id);

			System.out.println("luv2code: Instructor: "+ tempInstructor);

			//option 1: call getter before closing session
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			session.close();

			System.out.println("\nluv2code:Session is now closed!!!\n");
			
			//get courses for the instructor
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!!!");
		}
		finally {

			//add clean up code
			session.close();
			factory.close();

		}
	}

}
