package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the en_role_type database table.
 * 
 */
@Entity
@Table(name="en_role_type")
@NamedQuery(name="RoleType.findAll", query="SELECT e FROM RoleType e")
public class RoleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_ROLE_TYPE")
	private int codRoleType;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional many-to-one association to EnUser
	@OneToMany(mappedBy="RoleType")
	private List<User> Users;

	public RoleType() {
	}

	public int getCodRoleType() {
		return this.codRoleType;
	}

	public void setCodRoleType(int codRoleType) {
		this.codRoleType = codRoleType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return this.Users;
	}

	public void setUsers(List<User> Users) {
		this.Users = Users;
	}

	public User addEnUser(User enUser) {
		getUsers().add(enUser);
		enUser.setRoleType(this);

		return enUser;
	}

	public User removeUser(User User) {
		getUsers().remove(User);
		User.setRoleType(null);

		return User;
	}

}