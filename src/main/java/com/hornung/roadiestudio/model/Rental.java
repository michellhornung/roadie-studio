package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;


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

	@NotBlank(message = "Descrição é obrigatório.")
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="HOUR_QUANTITY")
	private BigDecimal hourQuantity;

	@Column(name="HOUR_VALUE")
	private BigDecimal hourValue;

	@Column(name="IS_FOR_SHOW")
	private byte isForShow;

	@Column(name="IS_INSTRUMENT")
	private byte isInstrument;

	@Column(name="IS_TO_FIX")
	private byte isToFix;

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

	public BigDecimal getHourQuantity() {
		return this.hourQuantity;
	}

	public void setHourQuantity(BigDecimal hourQuantity) {
		this.hourQuantity = hourQuantity;
	}

	public BigDecimal getHourValue() {
		return this.hourValue;
	}

	public void setHourValue(BigDecimal hourValue) {
		this.hourValue = hourValue;
	}

	public byte getIsForShow() {
		return this.isForShow;
	}

	public void setIsForShow(byte isForShow) {
		this.isForShow = isForShow;
	}

	public byte getIsInstrument() {
		return this.isInstrument;
	}

	public void setIsInstrument(byte isInstrument) {
		this.isInstrument = isInstrument;
	}

	public byte getIsToFix() {
		return this.isToFix;
	}

	public void setIsToFix(byte isToFix) {
		this.isToFix = isToFix;
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