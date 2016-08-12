package com.nguyenvietquan.common;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "demo", uniqueConstraints={
		@UniqueConstraint(columnNames = { "STOCK_NAME" }),
		@UniqueConstraint(columnNames = { "STOCK_CODE" })})
public class Stock implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String ID = "STOCK_ID";
	public static final String CODE = "STOCK_CODE";
	public static final String NAME = "STOCK_NAME";

	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}
	
	public Stock(String stockCode, String stockName,StockDetail stockDetail) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
	}

	@Id
	@GeneratedValue()
	@Column(name = ID, unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = CODE, unique = true, nullable = false, length =10)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = NAME, unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

}
