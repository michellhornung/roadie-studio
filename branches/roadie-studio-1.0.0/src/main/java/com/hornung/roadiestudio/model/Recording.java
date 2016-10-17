package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EN_RECORDINGS database table.
 * 
 */
@Entity
@Table(name="EN_RECORDINGS")
@NamedQuery(name="Recording.findAll", query="SELECT r FROM Recording r")
public class Recording implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecordingPK id;

	@Column(name="DESCRIPTION")
	private String description;

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
	@JoinColumn(name="COD_RECORDING")
	private Band enBand;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="COD_RECORDING")
	private Room enRoom;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="COD_RECORDING")
	private Stock enStock;

	public Recording() {
	}

	public RecordingPK getId() {
		return this.id;
	}

	public void setId(RecordingPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}