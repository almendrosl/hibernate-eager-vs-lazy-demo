package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
//
//            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//            InstructorDetail instructorDetail =
//                    new InstructorDetail("http://luv2code.com/youtube", "Luv 2 Code!!!");
//
            Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("http://youtube.com", "Guitar");


            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }

    }
}
