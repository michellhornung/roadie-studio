package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EN_USER database table.
 * 
 */
@Entity
@Table(name="EN_USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_USER_CODUSER_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="EN_USER_CODUSER_GENERATOR")
	@Column(name="COD_USER")
	private int codUser;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	@Column(name="LAST_NAME")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LATEST_UPDATE")
	private Date latestUpdate;

	@Column(name="PASSWORD")
	private String password;

	@Lob
	@Column(name="PHOTO")
	private byte[] photo;

	@Column(name="USERNAME")
	private String userName;

	//bi-directional one-to-one association to Band
	@OneToOne(mappedBy="enUser")
	private Band enBand;

	//bi-directional one-to-one association to Sale
	@OneToOne(mappedBy="enUser")
	private Sale enSale;

	//bi-directional one-to-one association to RoleType
	@OneToOne
	@JoinColumn(name="COD_USER")
	private RoleType enRoleType;

	public User() {
	}

	public int getCodUser() {
		return this.codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLatestUpdate() {
		return this.latestUpdate;
	}

	public void setLatestUpdate(Date latestUpdate) {
		this.latestUpdate = latestUpdate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getUsername() {
		return this.userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public Band getEnBand() {
		return this.enBand;
	}

	public void setEnBand(Band enBand) {
		this.enBand = enBand;
	}

	public Sale getEnSale() {
		return this.enSale;
	}

	public void setEnSale(Sale enSale) {
		this.enSale = enSale;
	}

	public RoleType getEnRoleType() {
		return this.enRoleType;
	}

	public void setEnRoleType(RoleType enRoleType) {
		this.enRoleType = enRoleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codUser;
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
		User other = (User) obj;
		if (codUser != other.codUser)
			return false;
		return true;
	}

}