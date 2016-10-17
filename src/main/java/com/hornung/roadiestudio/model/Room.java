package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EN_ROOM database table.
 * 
 */
@Entity
@Table(name="EN_ROOM")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_ROOM_CODROOM_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_ROOM_CODROOM_GENERATOR")
	@Column(name="COD_ROOM")
	private int codRoom;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-one association to Recording
	@OneToMany(mappedBy="enRoom")
	private List<Recording> enRecordings;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="enRoom")
	private List<Rental> enRentals;

	//bi-directional one-to-one association to Sale
	@OneToOne(mappedBy="enRoom")
	private Sale enSale;

	public Room() {
	}

	public int getCodRoom() {
		return this.codRoom;
	}

	public void setCodRoom(int codRoom) {
		this.codRoom = codRoom;
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

	public List<Recording> getEnRecordings() {
		return this.enRecordings;
	}

	public void setEnRecordings(List<Recording> enRecordings) {
		this.enRecordings = enRecordings;
	}

	public Recording addEnRecording(Recording enRecording) {
		getEnRecordings().add(enRecording);
		enRecording.setEnRoom(this);

		return enRecording;
	}

	public Recording removeEnRecording(Recording enRecording) {
		getEnRecordings().remove(enRecording);
		enRecording.setEnRoom(null);

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
		enRental.setEnRoom(this);

		return enRental;
	}

	public Rental removeEnRental(Rental enRental) {
		getEnRentals().remove(enRental);
		enRental.setEnRoom(null);

		return enRental;
	}

	public Sale getEnSale() {
		return this.enSale;
	}

	public void setEnSale(Sale enSale) {
		this.enSale = enSale;
	}

}