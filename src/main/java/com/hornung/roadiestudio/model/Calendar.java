package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
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

	@Column(name="TYPE")
	private String type;
	
	@NotNull(message = "Sala é obrigatório.")
	@ManyToOne
	@JoinColumn(name="COD_ROOM")
	private Room room;

	@NotNull(message = "Banda é obrigatório.")
	@ManyToOne
	@JoinColumn(name="COD_BAND")
	private Band band;
	
	@NotBlank(message = "Descrição é obrigatório.")
	@Column(name="DESCRIPTION")
	private String description;

	@NotBlank(message = "Data inicial é obrigatório.")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name="START_DATETIME")
	private Date startDatetime;
	
	@NotBlank(message = "Data final é obrigatório.")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name="END_DATETIME")
	private Date endDatetime;
	
	@Transient
	private int status;
	
	@Transient
	public Date dateTimeNow = new Date();
	
	@Transient
	private boolean compare;
		
	public Calendar() {
		
	}
	
	public boolean compare() {
		return endDatetime.equals(dateTimeNow) ||  endDatetime.after(dateTimeNow);
	}
	
	
	
	public int getCodCalendar() {
		return codCalendar;
	}

	public void setCodCalendar(int codCalendar) {
		this.codCalendar = codCalendar;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateTimeNow() {
		return dateTimeNow;
	}

	public void setDateTimeNow(Date dateTimeNow) {
		this.dateTimeNow = dateTimeNow;
	}

	public boolean isCompare() {
		compare = endDatetime.equals(dateTimeNow) ||  endDatetime.after(dateTimeNow);
		return compare;
	}

	public void setCompare(boolean compare) {
		this.compare = compare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((band == null) ? 0 : band.hashCode());
		result = prime * result + codCalendar;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDatetime == null) ? 0 : endDatetime.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((startDatetime == null) ? 0 : startDatetime.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (band == null) {
			if (other.band != null)
				return false;
		} else if (!band.equals(other.band))
			return false;
		if (codCalendar != other.codCalendar)
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
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (startDatetime == null) {
			if (other.startDatetime != null)
				return false;
		} else if (!startDatetime.equals(other.startDatetime))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}





}