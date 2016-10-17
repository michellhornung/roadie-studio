package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EN_RECORDINGS database table.
 * 
 */
@Embeddable
public class RecordingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_RECORDING", insertable=false, updatable=false)
	private int codRecording;

	@Column(name="HOUR_QUANTITY")
	private long hourQuantity;

	public RecordingPK() {
	}
	public int getCodRecording() {
		return this.codRecording;
	}
	public void setCodRecording(int codRecording) {
		this.codRecording = codRecording;
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
		if (!(other instanceof RecordingPK)) {
			return false;
		}
		RecordingPK castOther = (RecordingPK)other;
		return 
			(this.codRecording == castOther.codRecording)
			&& (this.hourQuantity == castOther.hourQuantity);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codRecording;
		hash = hash * prime + ((int) (this.hourQuantity ^ (this.hourQuantity >>> 32)));
		
		return hash;
	}
}