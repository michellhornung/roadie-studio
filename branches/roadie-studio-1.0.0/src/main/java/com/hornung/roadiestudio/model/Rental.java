package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


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
	
	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="COD_ROOM")
	private Room Room;
	
	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="COD_STOCK")
	private Stock Stock;
	
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