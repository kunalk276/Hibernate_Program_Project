package com.hibernate.practice;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.practice.entity.Child;
import com.hibernate.practice.entity.Parent;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory=cfg.buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        
        Transaction tr=session.beginTransaction();
        
        Parent parent=new Parent();
        parent.setpId(1);
        parent.setpName("Dhanaji");
        
        Child child1=new Child();
        
        child1.setcId(1);
        child1.setcName("Pooja");
        child1.setParent(parent);
        
        
        Child child2=new Child();
        child2.setcId(2);
        child2.setcName("Kunal");
        child2.setParent(parent);
        
        session.save(child1);
        session.save(child2);
        
        ArrayList list=new ArrayList();
        
        list.add(child1);
        list.add(child2);
        
        parent.setChild(list);
        
        session.save(parent);
        
        tr.commit();
        
        session.close();
        
        System.out.println("Information added....");
    }
}
