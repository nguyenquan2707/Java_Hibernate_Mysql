package com.nguyenvietquan.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "stock_detail", catalog = "demo")
public class StockDetail implements Serializable{
	
	private static final String ID ="STOCK_ID";
	private static final String NAME ="COMP_NAME";
	private static final String DESC ="COMP_DESC";
	private static final String REMARK ="REMARK";
	private static final String DATE ="LISTED_DATE";
	
	

	private Integer stockId;
	private Stock stock;
	private String compName;
	private String compDesc;
	private String remark;
	private Date listedDate;
	
	public StockDetail(){
		
	}
	
	public StockDetail(Stock stock,String compName, String compDesc,
			String remark, Date listedDate){
		this.stock  = stock;
		this.compName = compName;
		this.compDesc =compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}

	// cột này là khóa ngoại của lớp Stock
	@GenericGenerator(name = "generator", strategy = "foreign", 
			parameters = @Parameter(name = "property", value = "stock"))
			@Id
			@GeneratedValue(generator = "generator")
			@Column(name = ID, unique = true, nullable = false)
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	// cột ngoại của lớp Stock
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Column(name = NAME, nullable = false, length =100)
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Column(name = DESC, nullable = false)
	public String getCompDesc() {
		return compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	@Column(name = REMARK, nullable = false)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = DATE, nullable = false, length =10)
	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}
}
