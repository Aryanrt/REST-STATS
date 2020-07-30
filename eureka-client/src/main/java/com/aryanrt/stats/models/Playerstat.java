package com.aryanrt.stats.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the playerstats database table.
 * 
 */
@Entity
@Table(name="playerstat")
@NamedQuery(name="Playerstat.findAll", query="SELECT t FROM Playerstat t")
public class Playerstat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlayerstatsPK id;

	@Column(name="threepa")
	private double threepa;

	public double getThreepa() {
		return threepa;
	}

	public void setThreepa(double threepa) {
		this.threepa = threepa;
	}

	@Column(name="threepm")
	private double threepm;
	
	@Column(name="FP")
	private double FP;
	
	@Column(name="PM")
	private double PM;

	public double getPM() {
		return PM;
	}

	public void setPM(double pM) {
		PM = pM;
	}

	public double getFP() {
		return FP;
	}

	public void setFP(double fP) {
		FP = fP;
	}

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

	@Column(name="min")
	private String min;

	public double getThreepm() {
		return threepm;
	}

	public void setThreepm(double threepm) {
		this.threepm = threepm;
	}


	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public Playerstat() {
	}

	public PlayerstatsPK getId() {
		return this.id;
	}

	public void setId(PlayerstatsPK id) {
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
