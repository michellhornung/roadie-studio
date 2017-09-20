package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the en_stock database table.
 * 
 */
@Entity
@Table(name="en_stock")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_STOCK")
	private int codStock;

	@Column(name="DESCRIPTION")
	private String description;

	@NotNull(message="Nome é obrigatório.")
	@Column(name="NAME")
	private String name;

	@NotNull(message="Quantidade é obrigatório.")
	@Column(name="QUANTITY")
	private int quantity;

	//bi-directional many-to-one association to Recording
	@OneToMany(mappedBy="Stock")
	private List<Recording> Recordings;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="Stock")
	private List<Rental> Rentals;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="Stock")
	private List<Sale> Sales;

	//bi-directional many-to-one association to StockType
	@NotNull(message = "Marca é obrigatório.")
	@ManyToOne
	@JoinColumn(name="COD_STOCK_TYPE")
	private StockType StockType;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Recording> getRecordings() {
		return this.Recordings;
	}

	public void setRecordings(List<Recording> Recordings) {
		this.Recordings = Recordings;
	}

	public Recording addRecording(Recording Recording) {
		getRecordings().add(Recording);
		Recording.setStock(this);

		return Recording;
	}

	public Recording removeRecording(Recording Recording) {
		getRecordings().remove(Recording);
		Recording.setStock(null);

		return Recording;
	}

	public List<Rental> getRentals() {
		return this.Rentals;
	}

	public void setRentals(List<Rental> Rentals) {
		this.Rentals = Rentals;
	}

	public Rental addRental(Rental Rental) {
		getRentals().add(Rental);
		Rental.setStock(this);

		return Rental;
	}

	public Rental removeRental(Rental Rental) {
		getRentals().remove(Rental);
		Rental.setStock(null);

		return Rental;
	}

	public List<Sale> getSales() {
		return this.Sales;
	}

	public void setSales(List<Sale> Sales) {
		this.Sales = Sales;
	}

	public Sale addSale(Sale Sale) {
		getSales().add(Sale);
		Sale.setStock(this);

		return Sale;
	}

	public Sale removeSale(Sale Sale) {
		getSales().remove(Sale);
		Sale.setStock(null);

		return Sale;
	}

	public StockType getStockType() {
		return this.StockType;
	}

	public void setStockType(StockType StockType) {
		this.StockType = StockType;
	}

}