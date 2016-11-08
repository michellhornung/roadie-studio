package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the en_merchan_type database table.
 * 
 */
@Entity
@Table(name="en_merchan_type")
@NamedQuery(name="MerchanType.findAll", query="SELECT m FROM MerchanType m")
public class MerchanType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_MERCHAN_TYPE")
	private int codMerchanType;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional many-to-one association to Merchan
	@OneToMany(mappedBy="MerchanType")
	private List<Merchan> Merchans;

	public MerchanType() {
	}

	public int getCodMerchanType() {
		return this.codMerchanType;
	}

	public void setCodMerchanType(int codMerchanType) {
		this.codMerchanType = codMerchanType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Merchan> getMerchans() {
		return this.Merchans;
	}

	public void setMerchans(List<Merchan> Merchans) {
		this.Merchans = Merchans;
	}

	public Merchan addMerchan(Merchan Merchan) {
		getMerchans().add(Merchan);
		Merchan.setMerchanType(this);

		return Merchan;
	}

	public Merchan removeMerchan(Merchan Merchan) {
		getMerchans().remove(Merchan);
		Merchan.setMerchanType(null);

		return Merchan;
	}

}