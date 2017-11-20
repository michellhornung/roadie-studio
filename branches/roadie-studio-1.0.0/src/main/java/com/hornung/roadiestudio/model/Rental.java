package com.hornung.roadiestudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


/**
 * The persistent class for the en_rental database table.
 * 
 */
@Entity
@Table(name="en_rental")
@NamedQuery(name="Rental.findAll", query="SELECT r FROM Rental r")
public class Rental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_RENTAL")
	private int codRental;
	
	@NotNull(message = "Sala é obrigatório.")
	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="COD_ROOM")
	private Room Room;
	
	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="COD_STOCK")
	private Stock Stock;
	
	@NotNull(message = "Banda é obrigatório.")
	//bi-directional many-to-one association to Band
	@ManyToOne
	@JoinColumn(name="COD_BAND")
	private Band Band;

	@NotBlank(message = "Descrição é obrigatório.")
	@Column(name="DESCRIPTION")
	private String description;


	public Rental() {
	}

	public int getCodRental() {
		return this.codRental;
	}

	public void setCodRental(int codRental) {
		this.codRental = codRental;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}