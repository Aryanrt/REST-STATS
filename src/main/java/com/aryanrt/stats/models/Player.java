package com.aryanrt.stats.models;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@Table(name="player")
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Column(name="id")
	private PlayerPK id;

	@Column(name="threepa")
	private double threepa;

	@Column(name="threepm")
	private double threepm;

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

	@Column(name="FP")
	private double fp;

	@Column(name="fta")
	private double fta;

	@Column(name="ftm")
	private double ftm;

	@Column(name="min")
	private double min;

	@Column(name="ORB")
	private double orb;

	@Column(name="pf")
	private double pf;

	@Column(name="playerID")
	private int playerID;

	@Column(name="position")
	private int position;

	@Column(name="pts")
	private double pts;

	@Column(name="reb")
	private double reb;

	@Column(name="stl")
	private double stl;

	@Column(name="tov")
	private double tov;

	public Player() {
	}

	public PlayerPK getId() {
		return this.id;
	}

	public void setId(PlayerPK id) {
		this.id = id;
	}

	public double getThreepa() {
		return this.threepa;
	}

	public void setThreepa(double _pa) {
		this.threepa = _pa;
	}

	public double getThreepm() {
		return this.threepm;
	}

	public void setThreepm(double threepm) {
		this.threepm = threepm;
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

	public double getFp() {
		return this.fp;
	}

	public void setFp(double fp) {
		this.fp = fp;
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

	public double getMin() {
		return this.min;
	}

	public void setMin(double min) {
		this.min = min;
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

	public int getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
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
