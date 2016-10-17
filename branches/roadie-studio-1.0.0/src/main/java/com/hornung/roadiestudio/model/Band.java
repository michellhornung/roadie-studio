package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EN_BAND database table.
 * 
 */
@Entity
@Table(name="EN_BAND")
@NamedQuery(name="Band.findAll", query="SELECT b FROM Band b")
public class Band implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_BAND_CODBAND_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_BAND_CODBAND_GENERATOR")
	@Column(name="COD_BAND")
	private int codBand;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="GENRE")
	private String genre;

	@Column(name="NAME")
	private String name;

	@Column(name="XP")
	private int xp;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="COD_BAND")
	private User enUser;

	//bi-directional one-to-one association to Logo
	@OneToOne(mappedBy="enBand")
	private Logo enLogo;

	//bi-directional many-to-one association to Recording
	@OneToMany(mappedBy="enBand")
	private List<Recording> enRecordings;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="enBand")
	private List<Rental> enRentals;

	//bi-directional one-to-one association to Sale
	@OneToOne(mappedBy="enBand")
	private Sale enSale;

	public Band() {
	}

	public int getCodBand() {
		return this.codBand;
	}

	public void setCodBand(int codBand) {
		this.codBand = codBand;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getXp() {
		return this.xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public User getEnUser() {
		return this.enUser;
	}

	public void setEnUser(User enUser) {
		this.enUser = enUser;
	}

	public Logo getEnLogo() {
		return this.enLogo;
	}

	public void setEnLogo(Logo enLogo) {
		this.enLogo = enLogo;
	}

	public List<Recording> getEnRecordings() {
		return this.enRecordings;
	}

	public void setEnRecordings(List<Recording> enRecordings) {
		this.enRecordings = enRecordings;
	}

	public Recording addEnRecording(Recording enRecording) {
		getEnRecordings().add(enRecording);
		enRecording.setEnBand(this);

		return enRecording;
	}

	public Recording removeEnRecording(Recording enRecording) {
		getEnRecordings().remove(enRecording);
		enRecording.setEnBand(null);

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
		enRental.setEnBand(this);

		return enRental;
	}

	public Rental removeEnRental(Rental enRental) {
		getEnRentals().remove(enRental);
		enRental.setEnBand(null);

		return enRental;
	}

	public Sale getEnSale() {
		return this.enSale;
	}

	public void setEnSale(Sale enSale) {
		this.enSale = enSale;
	}

}