package com.aryanrt.stats.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamstatsPK {

	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String teamID;
	
	@Column(insertable=false, updatable=false)
	private String gameID;

	public String getGameID() {
		return gameID;
	}
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	private String firstName;

	private String lastName;

	public TeamstatsPK() {
	}
	public String getTeamID() {
		return this.teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlayerPK)) {
			return false;
		}
		TeamstatsPK castOther = (TeamstatsPK)other;
		return 
			this.teamID.equals(castOther.teamID)
			&& this.gameID.equals(castOther.gameID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.teamID.hashCode();
		hash = hash * prime + this.gameID.hashCode();
		return hash;
	}
	
}
