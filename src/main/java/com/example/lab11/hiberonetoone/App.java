package com.example.lab11.hiberonetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.lab11.model.Passport;
import com.example.lab11.model.Person;

public class App 
{
    public static void main( String[] args )
    {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            try
            {
            	Person user=new Person();
            	user.setPerson_name("Bujji");
            	
            	Passport details = new Passport();
            	details.setDetails("yes");
            	
            	user.setDetails(details);
            	details.setUser(user);
            	
            	session.save(user);
            	session.getTransaction().commit();
            	
            	Person retrievedUser=session.get(Person.class, user.getId());
       		    Passport retrievedPassport=retrievedUser.getDetails();
       		    
       		    System.out.println("User: "+retrievedUser.getPerson_name());
       		    System.out.println("Passport: "+retrievedPassport.getDetails());

            	
            }
            finally 
    		{
    			session.close();
                sessionFactory.close();
    		}
    }
}