package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EN_STOCK_TYPE database table.
 * 
 */
@Entity
@Table(name="EN_STOCK_TYPE")
@NamedQuery(name="StockType.findAll", query="SELECT s FROM StockType s")
public class StockType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_STOCK_TYPE_CODSTOCKTYPE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_STOCK_TYPE_CODSTOCKTYPE_GENERATOR")
	@Column(name="COD_STOCK_TYPE")
	private int codStockType;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NAME")
	private String name;

	//bi-directional one-to-one association to Stock
	@OneToOne(mappedBy="enStockType")
	private Stock enStock;

	public StockType() {
	}

	public int getCodStockType() {
		return this.codStockType;
	}

	public void setCodStockType(int codStockType) {
		this.codStockType = codStockType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stock getEnStock() {
		return this.enStock;
	}

	public void setEnStock(Stock enStock) {
		this.enStock = enStock;
	}

}