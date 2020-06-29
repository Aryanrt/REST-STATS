package com.aryanrt.stats.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PlayerstatsPK  implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="team")
	private Team team;
	
	@Column(name="gameID")
	private int gameID;

	public int getGameID() {
		return gameID;
	}
	public void setGame(int gameID) {
		this.gameID = gameID;
	}
	
	public PlayerstatsPK() {
	}
	public Team getTeam() {
		return this.team;
	}
	public void setTeam(Team playerID) {
		this.team = playerID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlayerPK)) {
			return false;
		}
		PlayerstatsPK castOther = (PlayerstatsPK)other;
		return 
			this.team.equals(castOther.team)
			&& this.gameID == castOther.gameID;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.team.hashCode();
		return hash;
	}
	
}
