package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


/**
 * The persistent class for the en_band database table.
 * 
 */
@Entity
@Table(name="en_band")
@NamedQuery(name="Band.findAll", query="SELECT b FROM Band b")
public class Band implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_BAND")
	private int codBand;

	@NotBlank(message = "Descrição é obrigatório.")
	@Column(name="DESCRIPTION")
	private String description;

	@NotBlank(message = "Nome é obrigatório.")
	@Column(name="NAME")
	private String name;

	@Column(name="XP")
	private int xp;

	//bi-directional many-to-one association to BandGenre
	@NotNull(message = "Gênero é obrigatório.")
	@ManyToOne
	@JoinColumn(name="COD_BAND_GENRE")
	private BandGenre BandGenre;

	//bi-directional many-to-one association to User
	@NotNull(message = "Usuário é obrigatório.")
	@ManyToOne
	@JoinColumn(name="COD_USER")
	private User User;

	//bi-directional many-to-one association to Recording
	@OneToMany(mappedBy="Band")
	private List<Recording> Recordings;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="Band")
	private List<Rental> Rentals;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="Band")
	private List<Sale> Sales;

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

	public BandGenre getBandGenre() {
		return this.BandGenre;
	}

	public void setBandGenre(BandGenre BandGenre) {
		this.BandGenre = BandGenre;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public List<Recording> getRecordings() {
		return this.Recordings;
	}

	public void setRecordings(List<Recording> Recordings) {
		this.Recordings = Recordings;
	}

	public Recording addRecording(Recording Recording) {
		getRecordings().add(Recording);
		Recording.setBand(this);

		return Recording;
	}

	public Recording removeRecording(Recording Recording) {
		getRecordings().remove(Recording);
		Recording.setBand(null);

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
		Rental.setBand(this);

		return Rental;
	}

	public Rental removeRental(Rental Rental) {
		getRentals().remove(Rental);
		Rental.setBand(null);

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
		Sale.setBand(this);

		return Sale;
	}

	public Sale removeSale(Sale Sale) {
		getSales().remove(Sale);
		Sale.setBand(null);

		return Sale;
	}

}