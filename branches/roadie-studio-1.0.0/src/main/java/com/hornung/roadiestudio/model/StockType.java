package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


/**
 * The persistent class for the en_stock_type database table.
 * 
 */
@Entity
@Table(name="en_stock_type")
@NamedQuery(name="StockType.findAll", query="SELECT s FROM StockType s")
public class StockType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_STOCK_TYPE")
	private int codStockType;

	@Column(name="BRAND")
	@NotBlank(message = "Marca é obrigatório.")
	private String brand;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="StockType")
	private List<Stock> Stocks;

	public StockType() {
	}

	public int getCodStockType() {
		return this.codStockType;
	}

	public void setCodStockType(int codStockType) {
		this.codStockType = codStockType;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public List<Stock> getStocks() {
		return this.Stocks;
	}

	public void setStocks(List<Stock> Stocks) {
		this.Stocks = Stocks;
	}

	public Stock addStock(Stock Stock) {
		getStocks().add(Stock);
		Stock.setStockType(this);

		return Stock;
	}

	public Stock removeStock(Stock Stock) {
		getStocks().remove(Stock);
		Stock.setStockType(null);

		return Stock;
	}

}