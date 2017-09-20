package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the en_user database table.
 * 
 */
@Entity
@Table(name="en_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_USER")
	private int codUser;

	@NotBlank(message = "E-mail é obrigatório.") @Email
	@Column(name="EMAIL")
	private String email;

	@NotBlank(message = "Nome é obrigatório.")
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LATEST_UPDATE")
	private Date latestUpdate;

	@NotBlank(message = "Senha é obrigatório.")
	@Column(name="PASSWORD")
	private String password;

	@NotBlank(message = "Username é obrigatório.")
	@Column(name="USERNAME")
	private String username;

	//bi-directional many-to-one association to Band
	@OneToMany(mappedBy="User")
	private List<Band> Bands;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="User")
	private List<Sale> Sales;

	//bi-directional many-to-one association to RoleType
	@NotNull(message = "Role é obrigatório.")
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Band> getBands() {
		return this.Bands;
	}

	public void setBands(List<Band> Bands) {
		this.Bands = Bands;
	}

	public Band addBand(Band Band) {
		getBands().add(Band);
		Band.setUser(this);

		return Band;
	}

	public Band removeBand(Band Band) {
		getBands().remove(Band);
		Band.setUser(null);

		return Band;
	}

	public List<Sale> getSales() {
		return this.Sales;
	}

	public void setSales(List<Sale> Sales) {
		this.Sales = Sales;
	}

	public Sale addSale(Sale Sale) {
		getSales().add(Sale);
		Sale.setUser(this);

		return Sale;
	}

	public Sale removeSale(Sale Sale) {
		getSales().remove(Sale);
		Sale.setUser(null);

		return Sale;
	}

	public RoleType getRoleType() {
		return this.RoleType;
	}

	public void setRoleType(RoleType RoleType) {
		this.RoleType = RoleType;
	}

}