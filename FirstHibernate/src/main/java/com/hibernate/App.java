package com.hibernate;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        
        //configure with hibernate xmlfile.
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        //session factory created 
        SessionFactory sessionFactory= cfg.buildSessionFactory();
        
        //open the session
        Session session = sessionFactory.openSession();
        
        //being transaction
         Transaction  tr = session.beginTransaction();
         Department dp=new Department();
         dp.setDid(11);
         dp.setDname("MBA");
         dp.setAddress("ASM College");
         //map object to database
         Employee emp1= new Employee();
         emp1.setId(1);
         emp1.setName("Rohit");
         emp1.setDept("Developer");
         emp1.setSalary(14000);
         
         session.save(dp);

         session.save(emp1);
         
         tr.commit();
         session.close();
         System.out.println("added");
    }
}