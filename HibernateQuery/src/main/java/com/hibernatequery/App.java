package com.hibernatequery;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	  Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx = session.beginTransaction();
          
//          Employee emp= new Employee();
//          emp.setId(2);
//          emp.setName("sagar");
//          emp.setSalary(77000);
//          emp.setjob("Devloper");
//          session.save(emp);
          System.out.println("added data");

          TypedQuery query=session.getNamedQuery("findEmployeeByName"); //TypedQuery query-session.getNamedQuery("findEmployees"); query.setParameter("name", "Kunal)");

          query.setParameter("name", "Kunal");

          List<Employee> employees= query.getResultList(); 
          Iterator<Employee> itr=employees.iterator(); 
          
          while(itr.hasNext())
          {  
        	  Employee e=itr.next();
        	  System.out.println(e);
          }  
          
         
          
          
          
//          session.save(emp); // Save the employee
          
          
         tx.commit(); // Commit the transaction
          session.close(); // Close the session
    }

	private static void iterator() {
		// TODO Auto-generated method stub
		
	}
}
