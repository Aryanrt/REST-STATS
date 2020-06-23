package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the game database table.
 * 
 */
@Embeddable
public class GamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="matchupID")
	private Matchup matchupID;

	@Column(name="date")
	private String date;

	public GamePK() {
	}
	public Matchup getMatchupID() {
		return this.matchupID;
	}
	public void setMatchupID(Matchup matchupID) {
		this.matchupID = matchupID;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GamePK)) {
			return false;
		}
		GamePK castOther = (GamePK)other;
		return 
			(this.matchupID == castOther.matchupID)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matchupID.getMatchupID();
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}

}