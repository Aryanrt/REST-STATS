package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teamstats database table.
 * 
 */
@Entity
@Table(name="teamstats")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Teamstats t")
public class Teamstats implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TeamstatsPK id;

	@Column(name="3pa")
	private double _pa;

	public double get_pa() {
		return _pa;
	}

	public void set_pa(double _pa) {
		this._pa = _pa;
	}

	public double get_pm() {
		return _pm;
	}

	public void set_pm(double _pm) {
		this._pm = _pm;
	}

	@Column(name="3pm")
	private double _pm;

	@Column(name="ast")
	private double ast;

	@Column(name="bs")
	private double bs;

	@Column(name="DRB")
	private double drb;

	@Column(name="fga")
	private double fga;

	@Column(name="fgm")
	private double fgm;

	@Column(name="fta")
	private double fta;

	@Column(name="ftm")
	private double ftm;

	@Column(name="ORB")
	private double orb;

	@Column(name="pf")
	private double pf;

	@Column(name="pts")
	private double pts;

	@Column(name="reb")
	private double reb;

	@Column(name="stl")
	private double stl;
	
	@Column(name="tov")
	private double tov;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamID")
	private Team team;
	
	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="gameID")
	private Game game;
	
	public Teamstats() {
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


	public TeamstatsPK getId() {
		return this.id;
	}

	public void setId(TeamstatsPK id) {
		this.id = id;
	}


	public double getAst() {
		return this.ast;
	}

	public void setAst(double ast) {
		this.ast = ast;
	}

	public double getBs() {
		return this.bs;
	}

	public void setBs(double bs) {
		this.bs = bs;
	}

	public double getDrb() {
		return this.drb;
	}

	public void setDrb(double drb) {
		this.drb = drb;
	}

	public double getFga() {
		return this.fga;
	}

	public void setFga(double fga) {
		this.fga = fga;
	}

	public double getFgm() {
		return this.fgm;
	}

	public void setFgm(double fgm) {
		this.fgm = fgm;
	}

	public double getFta() {
		return this.fta;
	}

	public void setFta(double fta) {
		this.fta = fta;
	}

	public double getFtm() {
		return this.ftm;
	}

	public void setFtm(double ftm) {
		this.ftm = ftm;
	}

	public double getOrb() {
		return this.orb;
	}

	public void setOrb(double orb) {
		this.orb = orb;
	}

	public double getPf() {
		return this.pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}


	public double getPts() {
		return this.pts;
	}

	public void setPts(double pts) {
		this.pts = pts;
	}

	public double getReb() {
		return this.reb;
	}

	public void setReb(double reb) {
		this.reb = reb;
	}

	public double getStl() {
		return this.stl;
	}

	public void setStl(double stl) {
		this.stl = stl;
	}

	public double getTov() {
		return this.tov;
	}

	public void setTov(double tov) {
		this.tov = tov;
	}
	
}
