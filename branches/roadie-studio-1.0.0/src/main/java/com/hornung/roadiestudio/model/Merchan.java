package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the en_merchan database table.
 * 
 */
@Entity
@Table(name="en_merchan")
@NamedQuery(name="Merchan.findAll", query="SELECT m FROM Merchan m")
public class Merchan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_MERCHAN")
	private int codMerchan;

	@Column(name="CONTACT")
	private String contact;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional many-to-one association to MerchanType
	@ManyToOne
	@JoinColumn(name="COD_MERCHAN_TYPE")
	private MerchanType MerchanType;

	public Merchan() {
	}

	public int getCodMerchan() {
		return this.codMerchan;
	}

	public void setCodMerchan(int codMerchan) {
		this.codMerchan = codMerchan;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MerchanType getMerchanType() {
		return this.MerchanType;
	}

	public void setMerchanType(MerchanType MerchanType) {
		this.MerchanType = MerchanType;
	}

}