package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the en_logo database table.
 * 
 */
@Entity
@Table(name="en_logo")
@NamedQuery(name="Logo.findAll", query="SELECT l FROM Logo l")
public class Logo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_LOGO")
	private int codLogo;

	@Column(name="DESCRIPTION")
	private String description;

	@Lob
	@Column(name="LOGO_FILE")
	private byte[] logoFile;

	@Column(name="NAME")
	private String name;

	public Logo() {
	}

	public int getCodLogo() {
		return this.codLogo;
	}

	public void setCodLogo(int codLogo) {
		this.codLogo = codLogo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getLogoFile() {
		return this.logoFile;
	}

	public void setLogoFile(byte[] logoFile) {
		this.logoFile = logoFile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}