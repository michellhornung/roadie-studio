package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EN_ROLE_TYPE database table.
 * 
 */
@Entity
@Table(name="EN_ROLE_TYPE")
@NamedQuery(name="RoleType.findAll", query="SELECT r FROM RoleType r")
public class RoleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EN_ROLE_TYPE_CODROLETYPE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="EN_ROLE_TYPE_CODROLETYPE_GENERATOR")
	@Column(name="COD_ROLE_TYPE")
	private int codRoleType;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="enRoleType")
	private User enUser;

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

	public User getEnUser() {
		return this.enUser;
	}

	public void setEnUser(User enUser) {
		this.enUser = enUser;
	}

	public static Object values() {
		// TODO Auto-generated method stub
		return null;
	}

}