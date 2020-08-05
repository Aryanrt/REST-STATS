package com.aryanrt.stats.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PlayerstatsPK  implements Serializable {

	private static final long serialVersionUID = 1L;

	public PlayerstatsPK(int playerID, int gameID) {
		super();
		this.playerID = playerID;
		this.gameID = gameID;
	}

	@Column(name="playerID")
	private int playerID;
	
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
	public int getPlayerID() {
		return this.playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
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
			this.playerID == castOther.playerID
			&& this.gameID == castOther.gameID;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		//hash = hash * prime + this.team.hashCode();
		return hash;
	}
	
}
