package com.niaa.expenses.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.dbcp2.BasicDataSource;


public class Service {
	
	public List<Expenses> getExpense(String expenseId){
		
		EntityManagerFactory emf = getEntityManagerFactory();
	    
        EntityManager em = emf.createEntityManager();
        
        String queryString = "SELECT ex from Expenses ex where ex.id = :id";
        
        TypedQuery<Expenses> query = em.createQuery(queryString, Expenses.class);
        query.setParameter("id", Integer.parseInt(expenseId));
        
        //Query createQuery = em.createQuery(queryString);
        
        List<Expenses> resultList = (List<Expenses>)query.getResultList();
		
        return resultList;
	}
	
	public boolean deleteExpense(String id) {
		
		boolean isDeleted = false;
		
		EntityManagerFactory emf = getEntityManagerFactory();
	    
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Expenses expenses = em.find(Expenses.class, Long.parseLong(id));
        
        if(expenses != null) {
        	em.remove(expenses);
        	isDeleted = true;
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return isDeleted;
        
	}
	
	public List<Expenses> getExpenses(){
		
		EntityManagerFactory emf = getEntityManagerFactory();
	    
        EntityManager em = emf.createEntityManager();
        
        String queryString = "SELECT ex from Expenses ex";
        
        Query createQuery = em.createQuery(queryString);
        
        List<Expenses> resultList = (List<Expenses>)createQuery.getResultList();
		
        return resultList;
	}

    public void store(Expenses ex) {
    	
    	EntityManagerFactory emf = getEntityManagerFactory();
    
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        
        em.persist(ex);

        em.getTransaction().commit();
        em.close();
        

    }
    
    private EntityManagerFactory getEntityManagerFactory() {
    	Map<String, Object> props = new HashMap<String, Object>();
        String sessionName = "SomeImpSession";

        props.put("eclipselink.session-name", sessionName);
        
        //DataSource ds = CloudServices.getDataSource();
               
        BasicDataSource ds = new BasicDataSource();

		
		try {
			
			Properties p = new Properties();
			p.load(Service.class.getResourceAsStream("/db.properties"));

			ds.setUsername(p.getProperty("username"));
			ds.setPassword(p.getProperty("password"));
			ds.setDriverClassName("org.postgresql.Driver");
			ds.setUrl(p.getProperty("url"));
			ds.setInitialSize(1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        props.put("javax.persistence.nonJtaDataSource", ds);
    	
    	
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXPENSES_JPA", props);
        
        return emf;

    }

}
