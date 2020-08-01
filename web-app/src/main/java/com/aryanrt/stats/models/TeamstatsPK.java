package com.aryanrt.stats.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class TeamstatsPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name = "teamID" ,referencedColumnName = "abbriviation")
	private Team teamID;
	
	@Column(name="gameID")
	int gameID;
	
	public TeamstatsPK() {
	}
	public TeamstatsPK(int gameID, Team team) {
		this.gameID = gameID;
		this.teamID = team;
	}
	public Team getTeam() {
		return teamID;
	}

	public void setTeam(Team team) {
		this.teamID = team;
	}

	public int getGame() {
		return gameID;
	}

	public void setGame(int game) {
		this.gameID = gameID;
	}


	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		//if (!(other instanceof PlayerPK)) {
			//return false;
		//}
		TeamstatsPK castOther = (TeamstatsPK)other;
		return 
			this.teamID.equals(castOther.teamID)
			&& this.gameID == castOther.gameID;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.teamID.hashCode();
		//hash = hash * prime + this.gameID.hashCode();
		return hash;
	}
	
}
