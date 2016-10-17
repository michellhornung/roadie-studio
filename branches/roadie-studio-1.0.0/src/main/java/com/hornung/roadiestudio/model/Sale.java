package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EN_SALES database table.
 * 
 */
@Entity
@Table(name="EN_SALES")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_SALES_CODSALES_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_SALES_CODSALES_GENERATOR")
	@Column(name="COD_SALES")
	private int codSales;

	@Column(name="NAME")
	private String name;

	@Column(name="OBSERVATION")
	private String observation;

	@Column(name="VALUE")
	private BigDecimal value;

	//bi-directional one-to-one association to Band
	@OneToOne
	@JoinColumn(name="COD_SALES")
	private Band enBand;

	//bi-directional one-to-one association to Room
	@OneToOne
	@JoinColumn(name="COD_SALES")
	private Room enRoom;

	//bi-directional one-to-one association to Stock
	@OneToOne
	@JoinColumn(name="COD_SALES")
	private Stock enStock;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="COD_SALES")
	private User enUser;

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

	public Band getEnBand() {
		return this.enBand;
	}

	public void setEnBand(Band enBand) {
		this.enBand = enBand;
	}

	public Room getEnRoom() {
		return this.enRoom;
	}

	public void setEnRoom(Room enRoom) {
		this.enRoom = enRoom;
	}

	public Stock getEnStock() {
		return this.enStock;
	}

	public void setEnStock(Stock enStock) {
		this.enStock = enStock;
	}

	public User getEnUser() {
		return this.enUser;
	}

	public void setEnUser(User enUser) {
		this.enUser = enUser;
	}

}