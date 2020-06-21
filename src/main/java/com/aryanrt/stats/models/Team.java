package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@Table(name="team")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String abbriviation;

	@Column(name="3pa")
	private double _pa;

	@Column(name="3pm")
	private double _pm;

	private double ast;

	private double bs;

	@Column(name="CA")
	private double ca;

	@Column(name="DRB")
	private double drb;

	private double fga;

	private double fgm;

	private double fta;

	private double ftm;

	private double min;

	@Column(name="ORB")
	private double orb;

	private double pf;

	@Column(name="PFA")
	private double pfa;

	@Column(name="PGA")
	private double pga;

	private double pts;

	private double reb;

	@Column(name="SFA")
	private double sfa;

	@Column(name="SGA")
	private double sga;

	private double stl;

	private String teamName;

	private double tov;

	//bi-directional many-to-one association to Matchup
	@OneToMany(mappedBy="team1Bean")
	private List<Matchup> matchups1;

	//bi-directional many-to-one association to Matchup
	@OneToMany(mappedBy="team2Bean")
	private List<Matchup> matchups2;

	//bi-directional many-to-one association to Player
	@OneToMany(mappedBy="team")
	private List<Player> players;

	public Team() {
	}

	public String getAbbriviation() {
		return this.abbriviation;
	}

	public void setAbbriviation(String abbriviation) {
		this.abbriviation = abbriviation;
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

	public double getCa() {
		return this.ca;
	}

	public void setCa(double ca) {
		this.ca = ca;
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

	public double getPfa() {
		return this.pfa;
	}

	public void setPfa(double pfa) {
		this.pfa = pfa;
	}

	public double getPga() {
		return this.pga;
	}

	public void setPga(double pga) {
		this.pga = pga;
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

	public double getSfa() {
		return this.sfa;
	}

	public void setSfa(double sfa) {
		this.sfa = sfa;
	}

	public double getSga() {
		return this.sga;
	}

	public void setSga(double sga) {
		this.sga = sga;
	}

	public double getStl() {
		return this.stl;
	}

	public void setStl(double stl) {
		this.stl = stl;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getTov() {
		return this.tov;
	}

	public void setTov(double tov) {
		this.tov = tov;
	}

	public List<Matchup> getMatchups1() {
		return this.matchups1;
	}

	public void setMatchups1(List<Matchup> matchups1) {
		this.matchups1 = matchups1;
	}

	public Matchup addMatchups1(Matchup matchups1) {
		getMatchups1().add(matchups1);
		matchups1.setTeam1Bean(this);

		return matchups1;
	}

	public Matchup removeMatchups1(Matchup matchups1) {
		getMatchups1().remove(matchups1);
		matchups1.setTeam1Bean(null);

		return matchups1;
	}

	public List<Matchup> getMatchups2() {
		return this.matchups2;
	}

	public void setMatchups2(List<Matchup> matchups2) {
		this.matchups2 = matchups2;
	}

	public Matchup addMatchups2(Matchup matchups2) {
		getMatchups2().add(matchups2);
		matchups2.setTeam2Bean(this);

		return matchups2;
	}

	public Matchup removeMatchups2(Matchup matchups2) {
		getMatchups2().remove(matchups2);
		matchups2.setTeam2Bean(null);

		return matchups2;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player addPlayer(Player player) {
		getPlayers().add(player);
		player.setTeam(this);

		return player;
	}

	public Player removePlayer(Player player) {
		getPlayers().remove(player);
		player.setTeam(null);

		return player;
	}

}
