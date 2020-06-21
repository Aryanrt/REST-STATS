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
	private PlayerPK id;

	@Column(name="3pa")
	private double _pa;

	@Column(name="3pm")
	private double _pm;

	private double ast;

	private double bs;

	@Column(name="DRB")
	private double drb;

	private double fga;

	private double fgm;

	@Column(name="FP")
	private double fp;

	private double fta;

	private double ftm;

	private double min;

	@Column(name="ORB")
	private double orb;

	private double pf;

	private int playerID;

	private String position;

	private double pts;

	private double reb;

	private double stl;

	private double tov;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamID")
	private Team team;

	public Player() {
	}

	public PlayerPK getId() {
		return this.id;
	}

	public void setId(PlayerPK id) {
		this.id = id;
	}

	public double get_pa() {
		return this._pa;
	}

	public void set_pa(double _pa) {
		this._pa = _pa;
	}

	public double get_pm() {
		return this._pm;
	}

	public void set_pm(double _pm) {
		this._pm = _pm;
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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
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

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
