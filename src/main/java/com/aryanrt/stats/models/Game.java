package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NaturalId;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@Table(name="game")
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Column(name="id")
	private GamePK id;

	@Column(name="gameID")
	private int gameID;

	@Column(name="location")
	private String location;


	public Game() {
	}

	public GamePK getId() {
		return this.id;
	}

	public void setId(GamePK id) {
		this.id = id;
	}

	public int getGameID() {
		return this.gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



}