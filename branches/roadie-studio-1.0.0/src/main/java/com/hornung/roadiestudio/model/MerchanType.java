package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EN_MERCHAN_TYPE database table.
 * 
 */
@Entity
@Table(name="EN_MERCHAN_TYPE")
@NamedQuery(name="MerchanType.findAll", query="SELECT m FROM MerchanType m")
public class MerchanType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_MERCHAN_TYPE_CODMERCHANTYPE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="EN_MERCHAN_TYPE_CODMERCHANTYPE_GENERATOR")
	@Column(name="COD_MERCHAN_TYPE")
	private int codMerchanType;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional one-to-one association to Merchan
	@OneToOne(mappedBy="enMerchanType")
	private Merchan enMerchan;

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

	public Merchan getEnMerchan() {
		return this.enMerchan;
	}

	public void setEnMerchan(Merchan enMerchan) {
		this.enMerchan = enMerchan;
	}

}