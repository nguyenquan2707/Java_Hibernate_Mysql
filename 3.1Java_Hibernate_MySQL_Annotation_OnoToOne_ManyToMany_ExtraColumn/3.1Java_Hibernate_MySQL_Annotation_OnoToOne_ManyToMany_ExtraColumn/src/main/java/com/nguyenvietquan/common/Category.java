package com.nguyenvietquan.common;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog ="demo")
public class Category implements Serializable {
	
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<StockCategory> stocksCategories = new HashSet<StockCategory>(0);
	
	public Category(){
		
	}
	
	public Category(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public Category(String name, Set<StockCategory> stocksCategories){
		this.name = name;
		this.desc = desc;
		this.stocksCategories = stocksCategories;
		
	}
	
	//---------------------------------------------//

	@Id
	@GeneratedValue
	@Column(name ="CATEGORY_ID", unique = true, nullable = false) 
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name ="CATEGORY_NAME", unique = false, nullable = false) 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name ="CATEGORY_DESC", unique = false, nullable = false) 
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category")
	public Set<StockCategory> getStocksCategories() {
		return stocksCategories;
	}

	public void setStocksCategories(Set<StockCategory> stocksCategories) {
		this.stocksCategories = stocksCategories;
	}


}
