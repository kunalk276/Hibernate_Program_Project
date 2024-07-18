package com.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    //configure the hibernate.cfg.xml file	
    Configuration cfg=new Configuration();
    cfg.configure("hibernate.cfg.xml");
  //build the session factory 
    SessionFactory sessionFactory=cfg.buildSessionFactory();
    //open the ssion for transaction
    
    Session session=sessionFactory.openSession();
    
    //begin transaction
    Transaction tr=session.beginTransaction();
    
    Husband hs=new Husband();
    Wife wi=new Wife();
    
    
    hs.setHid(2);
    hs.sethName("Ram");
    hs.setWife(wi);
    
    wi.setwId(2);
    wi.setwName("Sita");
    wi.setHusband(hs);
    
    session.save(wi);
    session.save(hs);
    
    tr.commit();
    session.close();
    
    System.out.println("husband wife add Successful... ");
    
    }
}
