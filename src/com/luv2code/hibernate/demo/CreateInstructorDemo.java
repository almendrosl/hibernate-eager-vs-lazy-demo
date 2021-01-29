package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
//            InstructorDetail instructorDetail =
//                    new InstructorDetail("http://luv2code.com/youtube", "Luv 2 Code!!!");

//            Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("http://youtube.com", "Video Games");


            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
