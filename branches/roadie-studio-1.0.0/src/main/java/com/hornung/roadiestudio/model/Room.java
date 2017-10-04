package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the en_room database table.
 * 
 */
@Entity
@Table(name="en_room")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_ROOM")
	private int codRoom;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NAME")
	private String name;
	
	//bi-directional many-to-one association to Recording
	@OneToMany(mappedBy="Room")
	private List<Recording> Recordings;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="Room")
	private List<Rental> Rentals;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="Room")
	private List<Sale> Sales;

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

	public List<Recording> getRecordings() {
		return this.Recordings;
	}

	public void setRecordings(List<Recording> Recordings) {
		this.Recordings = Recordings;
	}

	public Recording addRecording(Recording Recording) {
		getRecordings().add(Recording);
		Recording.setRoom(this);

		return Recording;
	}

	public Recording removeRecording(Recording Recording) {
		getRecordings().remove(Recording);
		Recording.setRoom(null);

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
		Rental.setRoom(this);

		return Rental;
	}

	public Rental removeRental(Rental Rental) {
		getRentals().remove(Rental);
		Rental.setRoom(null);

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
		Sale.setRoom(this);

		return Sale;
	}

	public Sale removeSale(Sale Sale) {
		getSales().remove(Sale);
		Sale.setRoom(null);

		return Sale;
	}

}