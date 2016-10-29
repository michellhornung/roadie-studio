package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;


/**
 * The persistent class for the en_user database table.
 * 
 */
@Entity
@Table(name="en_user")
@NamedQuery(name="User.findAll", query="SELECT e FROM User e")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_USER")
	private int codUser;
	
	@NotBlank(message = "E-mail é obrigatório.")
	@Column(name="EMAIL")
	private String email;
	
	@NotBlank(message = "Nome é obrigatório.")
	@Column(name="FIRST_NAME")
	private String firstName;

	@NotNull(message = "Informe se usuário é ativo no sistema.")
	@Column(name="IS_ACTIVE")
	private byte isActive;

	@NotBlank(message = "Sobrenome é obrigatório.")
	@Column(name="LAST_NAME")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LATEST_UPDATE")
	private Date latestUpdate;

	@NotBlank(message = "Senha é obrigatório.")
	@Column(name="PASSWORD")
	private String password;

	@Lob
	@Column(name="PHOTO")
	private byte[] photo;

	@NotBlank(message = "Username é obrigatório.")
	@Column(name="USERNAME")
	private String username;

	//bi-directional many-to-one association to RoleType
	@ManyToOne
	@JoinColumn(name="COD_ROLE_TYPE")
	private RoleType RoleType;

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
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RoleType getRoleType() {
		return this.RoleType;
	}

	public void setRoleType(RoleType RoleType) {
		this.RoleType = RoleType;
	}

}