package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


/**
 * The persistent class for the en_band_genre database table.
 */
@Entity
@Table(name="en_band_genre")
@NamedQuery(name="BandGenre.findAll", query="SELECT b FROM BandGenre b")
public class BandGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_BAND_GENRE")
	private int codBandGenre;

	@NotBlank(message = "Descrição é obrigatório.")
	@Column(name="DESCRIPTION")
	private String description;

	@OneToMany(mappedBy="BandGenre")
	private List<Band> Bands;

	public BandGenre() {
	}

	public int getCodBandGenre() {
		return this.codBandGenre;
	}

	public void setCodBandGenre(int codBandGenre) {
		this.codBandGenre = codBandGenre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Band> getBands() {
		return this.Bands;
	}

	public void setBands(List<Band> Bands) {
		this.Bands = Bands;
	}

	public Band addBand(Band Band) {
		getBands().add(Band);
		Band.setBandGenre(this);

		return Band;
	}

	public Band removeBand(Band Band) {
		getBands().remove(Band);
		Band.setBandGenre(null);

		return Band;
	}

}