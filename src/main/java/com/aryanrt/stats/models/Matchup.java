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
	private Team team1Bean;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team2")
	private Team team2Bean;

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

	public Team getTeam1Bean() {
		return this.team1Bean;
	}

	public void setTeam1Bean(Team team1Bean) {
		this.team1Bean = team1Bean;
	}

	public Team getTeam2Bean() {
		return this.team2Bean;
	}

	public void setTeam2Bean(Team team2Bean) {
		this.team2Bean = team2Bean;
	}

}
