package com.nguyenvietquan.common;

import org.hibernate.Session;

import com.nguyenvietquan.persistence.HibernateUtil;

public class App {
	
	 public static void main( String[] args )
	    {
	        System.out.println("Maven + Hibernate + MySQL");
	        // open connection to MySQL Server
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();
	        Stock stock = new Stock();
	        
	        stock.setStockCode("4718");
	        stock.setStockName("GENM3");
	        
	        session.save(stock);
	        session.getTransaction().commit();
	        session.close();
	    }

}
