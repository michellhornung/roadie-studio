package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EN_STOCK database table.
 * 
 */
@Entity
@Table(name="EN_STOCK")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_STOCK_CODSTOCK_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="EN_STOCK_CODSTOCK_GENERATOR")
	@Column(name="COD_STOCK")
	private int codStock;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="QUANTITY")
	private int quantity;

	//bi-directional many-to-one association to Recording
	@OneToMany(mappedBy="enStock")
	private List<Recording> enRecordings;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="enStock")
	private List<Rental> enRentals;

	//bi-directional one-to-one association to Sale
	@OneToOne(mappedBy="enStock")
	private Sale enSale;

	//bi-directional one-to-one association to StockType
	@OneToOne
	@JoinColumn(name="COD_STOCK")
	private StockType enStockType;

	public Stock() {
	}

	public int getCodStock() {
		return this.codStock;
	}

	public void setCodStock(int codStock) {
		this.codStock = codStock;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Recording> getEnRecordings() {
		return this.enRecordings;
	}

	public void setEnRecordings(List<Recording> enRecordings) {
		this.enRecordings = enRecordings;
	}

	public Recording addEnRecording(Recording enRecording) {
		getEnRecordings().add(enRecording);
		enRecording.setEnStock(this);

		return enRecording;
	}

	public Recording removeEnRecording(Recording enRecording) {
		getEnRecordings().remove(enRecording);
		enRecording.setEnStock(null);

		return enRecording;
	}

	public List<Rental> getEnRentals() {
		return this.enRentals;
	}

	public void setEnRentals(List<Rental> enRentals) {
		this.enRentals = enRentals;
	}

	public Rental addEnRental(Rental enRental) {
		getEnRentals().add(enRental);
		enRental.setEnStock(this);

		return enRental;
	}

	public Rental removeEnRental(Rental enRental) {
		getEnRentals().remove(enRental);
		enRental.setEnStock(null);

		return enRental;
	}

	public Sale getEnSale() {
		return this.enSale;
	}

	public void setEnSale(Sale enSale) {
		this.enSale = enSale;
	}

	public StockType getEnStockType() {
		return this.enStockType;
	}

	public void setEnStockType(StockType enStockType) {
		this.enStockType = enStockType;
	}

}