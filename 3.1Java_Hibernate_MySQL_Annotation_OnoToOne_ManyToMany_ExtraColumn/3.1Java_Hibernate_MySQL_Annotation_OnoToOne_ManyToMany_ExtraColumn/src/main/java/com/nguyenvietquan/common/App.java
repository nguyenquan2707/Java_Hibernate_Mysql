package com.nguyenvietquan.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
	        stock.setStockCode("4722");
	        stock.setStockName("GENM7");
	        

	        
	        
	        Category category1 = new Category("AA3","BB3");
	        Category categor2 = new Category("AA2","BB2");
	        
	        session.save(category1);
	        
	        StockCategory stockCategory = new StockCategory();
	        stockCategory.setStock(stock);
	        stockCategory.setCategory(category1);
	        stockCategory.setCreatedDate(new Date());// extra column
	        stockCategory.setCreateBy("system"); // extra colum
	        
	        stock.getStockCategories().add(stockCategory);
	        session.save(stock);
	        
	        session.getTransaction().commit();
	        System.out.println("Dene!!");
	        session.close();
	    }

}
