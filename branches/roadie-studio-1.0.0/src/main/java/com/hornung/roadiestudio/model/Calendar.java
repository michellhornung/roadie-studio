package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * The persistent class for the en_band database table.
 */
@Entity
@Table(name="en_calendar")
@NamedQuery(name="Calendar.findAll", query="SELECT c FROM Calendar c")
public class Calendar implements Serializable {
	
	private static final long serialVersionUID = 3065972240352862635L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_CALENDAR")
	private int codCalendar;

	@ManyToOne
	@JoinColumn(name="COD_RENTAL")
	private Rental rental;

	@ManyToOne
	@JoinColumn(name="COD_RECORDING")
	private Recording recording;
	
	@Column(name="DESCRIPTION")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name="START_DATETIME")
	private Date startDatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name="END_DATETIME")
	private Date endDatetime;

	public Calendar() {
		
	}

	public int getCodCalendar() {
		return codCalendar;
	}

	public void setCodCalendar(int codCalendar) {
		this.codCalendar = codCalendar;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Recording getRecording() {
		return recording;
	}

	public void setRecording(Recording recording) {
		this.recording = recording;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Date getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Date endDatetime) {
		this.endDatetime = endDatetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codCalendar;
		result = prime * result + ((recording == null) ? 0 : recording.hashCode());
		result = prime * result + ((rental == null) ? 0 : rental.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDatetime == null) ? 0 : endDatetime.hashCode());
		result = prime * result + ((startDatetime == null) ? 0 : startDatetime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		if (codCalendar != other.codCalendar)
			return false;
		if (recording == null) {
			if (other.recording != null)
				return false;
		} else if (!recording.equals(other.recording))
			return false;
		if (rental == null) {
			if (other.rental != null)
				return false;
		} else if (!rental.equals(other.rental))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDatetime == null) {
			if (other.endDatetime != null)
				return false;
		} else if (!endDatetime.equals(other.endDatetime))
			return false;
		if (startDatetime == null) {
			if (other.startDatetime != null)
				return false;
		} else if (!startDatetime.equals(other.startDatetime))
			return false;
		return true;
	}
}