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
	        
	        stock.setStockCode("4721");
	        stock.setStockName("GENM6");
	        
//	        StockDetail stockDetail = new StockDetail();
//	        stockDetail.setCompName("Mulodo1");
//	        stockDetail.setCompDesc("one stop1");
//	        stockDetail.setRemark("vinci1");
//	        stockDetail.setListedDate(new Date());
//	        stockDetail.setStock(stock);
	        
	        Category category1 = new Category("AA","BB");
	        Category categor2 = new Category("AA1","BB2");
	        
	        List<Category> listCategory = new ArrayList<Category>();
	        listCategory.add(category1);
	        listCategory.add(categor2);	        
	        stock.setCategories(listCategory);
	        
	        session.save(stock);
	        
	        session.getTransaction().commit();
	        System.out.println("Dene!!");
	        session.close();
	    }

}
