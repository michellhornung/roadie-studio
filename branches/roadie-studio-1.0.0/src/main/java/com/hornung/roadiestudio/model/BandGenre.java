package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the en_band_genre database table.
 * 
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

	@Column(name="DESCRIPTION")
	private String description;

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

}