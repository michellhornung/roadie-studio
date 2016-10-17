package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EN_RENTAL database table.
 * 
 */
@Embeddable
public class RentalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_RENTAL", insertable=false, updatable=false)
	private int codRental;

	@Column(name="HOUR_QUANTITY")
	private long hourQuantity;

	public RentalPK() {
	}
	public int getCodRental() {
		return this.codRental;
	}
	public void setCodRental(int codRental) {
		this.codRental = codRental;
	}
	public long getHourQuantity() {
		return this.hourQuantity;
	}
	public void setHourQuantity(long hourQuantity) {
		this.hourQuantity = hourQuantity;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RentalPK)) {
			return false;
		}
		RentalPK castOther = (RentalPK)other;
		return 
			(this.codRental == castOther.codRental)
			&& (this.hourQuantity == castOther.hourQuantity);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codRental;
		hash = hash * prime + ((int) (this.hourQuantity ^ (this.hourQuantity >>> 32)));
		
		return hash;
	}
}