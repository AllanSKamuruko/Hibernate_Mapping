package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();

		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// create the objects
			/*Instructor tempInstructor = new Instructor(
					"Allan", "Kays","kays@gmail.com");
			
			InstructorDetails tempInstructorDetails = new InstructorDetails(
					"www.kays.com", "LUV 2 code");
			*/
			Instructor tempInstructor = new Instructor(
					"Simba", "Kams","kams@gmail.com");
			
			InstructorDetails tempInstructorDetails = new InstructorDetails(
					"www.kams.com", "playing chess");
			
			
			// associate the objects
			tempInstructor.setInstructorDetails(tempInstructorDetails);
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			
			// note this will also save the details object
			//because of CascadeType.All
			
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close(); 
		}
	}

}
