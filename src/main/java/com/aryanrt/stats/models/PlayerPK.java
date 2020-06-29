package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the player database table.
 * 
 */
@Embeddable
public class PlayerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="team")
	private Team team;

	@Column(name="FIRSTNAME")
	private String firstName;

	@Column(name="LASTNAME")
	private String lastName;

	public PlayerPK() {
	}
	public Team getTeam() {
		return this.team;
	}
	public void setTeam(Team team) {
		this.team = team;
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

	public boolean equals(Object other) {
//		if (this == other) {
//			return true;
//		}
//		if (!(other instanceof PlayerPK)) {
//			return false;
//		}
		PlayerPK castOther = (PlayerPK)other;
		return 
			this.team.getAbbriviation().equals(castOther.team.getAbbriviation())
			 && this.firstName.equals(castOther.firstName)
			&& this.lastName.equals(castOther.lastName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		//hash = hash * prime + this.team.hashCode();
		hash = hash * prime + this.firstName.hashCode();
		hash = hash * prime + this.lastName.hashCode();
		
		return hash;
	}
}
