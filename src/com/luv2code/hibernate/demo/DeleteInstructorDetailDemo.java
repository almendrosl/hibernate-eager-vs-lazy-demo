package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 3;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("TempInstructorDetails:  " + instructorDetail);

            System.out.println("Instrutor: " + instructorDetail.getInstructor());

            instructorDetail.getInstructor().setInstructorDetail(null);


            System.out.println("Deleting TempInstructorDetails:  " + instructorDetail);
            session.delete(instructorDetail);
            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
