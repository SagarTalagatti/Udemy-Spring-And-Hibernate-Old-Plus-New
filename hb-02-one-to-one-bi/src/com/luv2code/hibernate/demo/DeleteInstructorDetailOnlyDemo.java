package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailOnlyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
						
			//get the instructor detail object
			int id=3;
			InstructorDetail tempInstructorDetail=
					session.get(InstructorDetail.class, id);
			
			//print the instructor detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);

			//print the associated instructor
			System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
			
			//delete the instructordetail only
			System.out.println("Deleting the instructor detail only...");
			
			//de-link the Instructor object and the InstructorDetail object
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();			
		}
	}

}
