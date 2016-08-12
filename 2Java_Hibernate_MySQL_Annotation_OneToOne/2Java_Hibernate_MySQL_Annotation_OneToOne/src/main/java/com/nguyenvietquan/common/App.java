package com.nguyenvietquan.common;

import java.util.Date;

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
	        
	        stock.setStockCode("4720");
	        stock.setStockName("GENM5");
	        
	        StockDetail stockDetail = new StockDetail();
	        stockDetail.setCompName("Mulodo1");
	        stockDetail.setCompDesc("one stop1");
	        stockDetail.setRemark("vinci1");
	        stockDetail.setListedDate(new Date());
	        
	        stock.setStockDetail(stockDetail);
	        stockDetail.setStock(stock);
	        
	        //session.save(stock);
	        session.save(stockDetail);
	        session.getTransaction().commit();
	        System.out.println("Dene!!");
	        session.close();
	    }

}
