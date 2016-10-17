package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EN_MERCHAN database table.
 * 
 */
@Entity
@Table(name="EN_MERCHAN")
@NamedQuery(name="Merchan.findAll", query="SELECT m FROM Merchan m")
public class Merchan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_MERCHAN_CODMERCHAN_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_MERCHAN_CODMERCHAN_GENERATOR")
	@Column(name="COD_MERCHAN")
	private int codMerchan;

	@Column(name="CONTACT")
	private String contact;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional one-to-one association to MerchanType
	@OneToOne
	@JoinColumn(name="COD_MERCHAN")
	private MerchanType enMerchanType;

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

	public MerchanType getEnMerchanType() {
		return this.enMerchanType;
	}

	public void setEnMerchanType(MerchanType enMerchanType) {
		this.enMerchanType = enMerchanType;
	}

}