package com.aryanrt.stats.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.models.Teamstat;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.MatchupService;
import com.aryanrt.stats.service.TeamService;
import com.aryanrt.stats.service.TeamstatService;
import com.google.gson.JsonObject;

@RestController
public class TeamstatController {

	private final TeamstatService teamstatService;
	private final TeamService teamService;
	private final GameService gameService;
	public TeamstatController(TeamstatService teamstatService, TeamService teamService, GameService gameService, MatchupService matchupService) {
		super();
		this.teamstatService = teamstatService;
		this.teamService = teamService;
		this.gameService = gameService;
	}

	@GetMapping(value="/teamstats",produces="application/json")
	public List<Teamstat> all(HttpServletRequest request)
	{
		return teamstatService.finaAll();
	}

	@GetMapping(value="/teamstats/{teamID}/{gameID}",produces="application/json")
	public JsonObject one(@PathVariable String teamID, @PathVariable int  gameID, HttpServletRequest request) {

		String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		JsonObject result = new JsonObject();
		Team team1 = teamService.findOne(teamID);
		Game game = gameService.findOne(gameID);
		if(game == null || team1 == null)
			return new JsonObject();	
		
		String date = game.getId().getDate();
		Matchup matchup = game.getId().getMatchupID();
		Team team2 = teamService.findOne((matchup.getTeam1()!= team1)? matchup.getTeam1().getAbbriviation(): matchup.getTeam2().getAbbriviation());
		Teamstat teamstat = teamstatService.findOne(team1.getAbbriviation(), game.getGameID());
		JsonObject temp = new JsonObject();
		
		result.addProperty("Team href",baseURL+"/teams/"+team1.getAbbriviation());
		result.addProperty("Self Link",baseURL+"/teamstats/"+ team1.getAbbriviation()+"/"+game.getGameID());
		result.addProperty("Agianst Link",baseURL+"/teamstats/"+ team2.getAbbriviation()+"/"+game.getGameID());
		result.addProperty("Game",baseURL+"/games/"+ game.getGameID());
		
		result.addProperty("Team", team1.getTeamName());
		result.addProperty("Against", team2.getTeamName());
		result.addProperty("Against href",baseURL+"/teams/"+team2.getAbbriviation());
		result.addProperty("Date",date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6));
		result.addProperty("Location", game.getLocation());
		
		temp.addProperty("points", teamstat.getPts());
		temp.addProperty("Rebounds", teamstat.getReb());
		temp.addProperty("Offensive Rebounds", teamstat.getOrb());
		temp.addProperty("Defensive Rebounds", teamstat.getDrb());
		temp.addProperty("Assists", teamstat.getAst());
		temp.addProperty("Block Shots", teamstat.getBs());
		temp.addProperty("Steals", teamstat.getStl());
		temp.addProperty("FGM", teamstat.getFgm());
		temp.addProperty("FGA", teamstat.getFga());
		temp.addProperty("3GM", teamstat.getThreepm());
		temp.addProperty("3GA", teamstat.getThreepm());
		temp.addProperty("FTM", teamstat.getFtm());
		temp.addProperty("FTA", teamstat.getFta());
		temp.addProperty("Turnovers", teamstat.getTov());
		temp.addProperty("Fouls", teamstat.getPf());
		
		result.add(team1.getAbbriviation()+" game stats", temp);		
		return result;
	}

}
