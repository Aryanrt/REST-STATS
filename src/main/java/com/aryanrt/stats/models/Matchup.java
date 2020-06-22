package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matchup database table.
 * 
 */
@Entity
@Table(name="matchup")
@NamedQuery(name="Matchup.findAll", query="SELECT m FROM Matchup m")
public class Matchup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int matchupID;
//
//	//bi-directional many-to-one association to Game
//	@OneToMany(mappedBy="matchupID")
//	private List<Game> games;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team1")
	private Team team1;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team2")
	private Team team2;

	public Matchup() {
	}

	public int getMatchupID() {
		return this.matchupID;
	}

	public void setMatchupID(int matchupID) {
		this.matchupID = matchupID;
	}

//	public List<Game> getGames() {
//		return this.games;
//	}
//
//	public void setGames(List<Game> games) {
//		this.games = games;
//	}

//	public Game addGame(Game game) {
//		getGames().add(game);
//		game.getId().setMatchupID(this);
//
//		return game;
//	}
//
//	public Game removeGame(Game game) {
//		getGames().remove(game);
//		//game.getId().setMatchup(null);
//
//		return game;
//	}

	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

}
