package com.aryanrt.stats.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BaseUri;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.models.Teamstat;
import com.aryanrt.stats.models.TeamstatsPK;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.aryanrt.stats.repositories.TeamRepository;
import com.aryanrt.stats.repositories.TeamstatRepository;
import com.google.gson.JsonObject;

@RestController
public class TeamstatController {

	@Autowired
	private TeamstatRepository teamstatsRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	// Aggregate root

	  @GetMapping(value="/teamstats",produces="application/json")
	  public JsonObject all(HttpServletRequest request)
	  {
		 //This looks super necessary
	    return null;
	  }

	@GetMapping(value="/teamstats/{teamID}/{gameID}",produces="application/json")
	public JsonObject one(@PathVariable String teamID, @PathVariable String gameID, HttpServletRequest request) {

		String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		Team team = teamRepository.findByAbbriviation(teamID);
		Game game = gameRepository.findByGameID(Integer.parseInt(gameID));
		Team team2 = game.getId().getMatchupID().getTeam1() != team ? game.getId().getMatchupID().getTeam1() :game.getId().getMatchupID().getTeam2();
		String date = game.getId().getDate();
		Teamstat teamstat = teamstatsRepository.findById(new TeamstatsPK(Integer.parseInt(gameID),team)).orElse(null);
		Teamstat team2stat = teamstatsRepository.findById(new TeamstatsPK(Integer.parseInt(gameID),team2)).orElse(null);
		
		JsonObject result = new JsonObject();
		result.addProperty("team1", team.getAbbriviation());
		result.addProperty("team2", team2.getAbbriviation());
		//result.addProperty(team2.getAbbriviation() +" stat", baseURL+"/teamstats/"+ team2.getAbbriviation()+"/"+ gameID);
		result.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );
		result.addProperty("location", game.getLocation());
		
		JsonObject temp = new JsonObject();
		temp.addProperty("points", teamstat.getPts());
		temp.addProperty("Rebounds", teamstat.getReb());
		temp.addProperty("Offensive Rebounds", teamstat.getOrb());
		temp.addProperty("Defensive Rebounds", teamstat.getDrb());
		temp.addProperty("Assists", teamstat.getAst());
		temp.addProperty("Block Shots", teamstat.getBs());
		temp.addProperty("Steals", teamstat.getStl());
		temp.addProperty("Turnovers", teamstat.getTov());
		temp.addProperty("Fouls", teamstat.getPf());
		temp.addProperty("FGM", teamstat.getFgm());
		temp.addProperty("FGA", teamstat.getFga());
		temp.addProperty("3GM", teamstat.getThreepm());
		temp.addProperty("3GA", teamstat.getThreepm());
		temp.addProperty("FTM", teamstat.getFtm());
		temp.addProperty("FTA", teamstat.getFta());
		
		result.add(team.getAbbriviation()+" game stats", temp);
		
		temp = new JsonObject();
		temp.addProperty("points", team2stat.getPts());
		temp.addProperty("Rebounds", team2stat.getReb());
		temp.addProperty("Offensive Rebounds", team2stat.getOrb());
		temp.addProperty("Defensive Rebounds", team2stat.getDrb());
		temp.addProperty("Assists", team2stat.getAst());
		temp.addProperty("Block Shots", team2stat.getBs());
		temp.addProperty("Steals", team2stat.getStl());
		temp.addProperty("Turnovers", team2stat.getTov());
		temp.addProperty("Fouls", team2stat.getPf());
		temp.addProperty("FGM", team2stat.getFgm());
		temp.addProperty("FGA", team2stat.getFga());
		temp.addProperty("3GM", team2stat.getThreepm());
		temp.addProperty("3GA", team2stat.getThreepm());
		temp.addProperty("FTM", team2stat.getFtm());
		temp.addProperty("FTA", team2stat.getFta());
		
		result.add(team2.getAbbriviation()+" game stats", temp);
		
		
		return result;
	}

}
