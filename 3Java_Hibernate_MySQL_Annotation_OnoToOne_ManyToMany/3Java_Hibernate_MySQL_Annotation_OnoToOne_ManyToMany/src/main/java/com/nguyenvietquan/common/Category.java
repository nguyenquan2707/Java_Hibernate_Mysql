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
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog ="demo")
public class Category implements Serializable {
	
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<Stock> stocks = new HashSet<Stock>(0);
	
	public Category(){
		
	}
	
	public Category(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public Category(String name, String desc, Set<Stock> stocks){
		this.name = name;
		this.desc = desc;
		this.stocks = stocks;
		
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

	//nhận dữ liệu từ bên lớp Stock, nhờ field categories
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

}
