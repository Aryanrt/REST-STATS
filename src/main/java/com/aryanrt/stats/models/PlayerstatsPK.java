package com.aryanrt.stats.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlayerstatsPK {

	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String playerID;
	
	@Column(insertable=false, updatable=false)
	private String gameID;

	public String getGameID() {
		return gameID;
	}
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	
	public PlayerstatsPK() {
	}
	public String getplayerID() {
		return this.playerID;
	}
	public void setplayerID(String playerID) {
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
			this.playerID.equals(castOther.playerID)
			&& this.gameID.equals(castOther.gameID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.playerID.hashCode();
		hash = hash * prime + this.gameID.hashCode();
		return hash;
	}
	
}
