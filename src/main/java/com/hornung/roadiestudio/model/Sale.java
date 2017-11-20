package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;


/**
 * The persistent class for the en_sales database table.
 * 
 */
@Entity
@Table(name="en_sales")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_SALES")
	private int codSales;

	@NotBlank(message = "Nome é obrigatório.")
	@Column(name="NAME")
	private String name;

	@Column(name="OBSERVATION")
	private String observation;

	@NotBlank(message = "Valor é obrigatório.")
	@Column(name="VALUE")
	private BigDecimal value;

	//bi-directional many-to-one association to Band
	@ManyToOne
	@JoinColumn(name="COD_BAND")
	private Band Band;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="COD_ROOM")
	private Room Room;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="COD_STOCK")
	private Stock Stock;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="COD_USER")
	private User User;

	public Sale() {
	}

	public int getCodSales() {
		return this.codSales;
	}

	public void setCodSales(int codSales) {
		this.codSales = codSales;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Band getBand() {
		return this.Band;
	}

	public void setBand(Band Band) {
		this.Band = Band;
	}

	public Room getRoom() {
		return this.Room;
	}

	public void setRoom(Room Room) {
		this.Room = Room;
	}

	public Stock getStock() {
		return this.Stock;
	}

	public void setStock(Stock Stock) {
		this.Stock = Stock;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

}