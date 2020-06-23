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
import com.aryanrt.stats.models.Teamstats;
import com.aryanrt.stats.models.TeamstatsPK;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.aryanrt.stats.repositories.TeamRepository;
import com.aryanrt.stats.repositories.TeamstatsRepository;
import com.google.gson.JsonObject;

@RestController
public class TeamstatsController {

	@Autowired
	private TeamstatsRepository teamstatsRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private MatchupRepository matchupRepository;

	// Aggregate root

//	  @GetMapping("/teamstats")
//	  public JsonObject all(HttpServletRequest request)
//	  {
//		  List<Game> games = ((List<Game>) gameRepository.findAll());
//		  List<Matchup> matchups = ((List<Matchup>) matchupRepository.findAll());
//		  
//		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
//		  JsonObject result = new JsonObject();
//		  for(int i=0; i < ((List<Team>) repository.findAll()).size(); i++)
//		  {
//			  JsonObject matchupJson = new JsonObject();
//			  Team team = ((List<Team>) repository.findAll()).get(i);
//			  
//			  //self Link
//			  matchupJson.addProperty("href",baseURL+"/teams/"+team.getAbbriviation());
//			  matchupJson.addProperty("name",team.getTeamName());
//			  matchupJson.addProperty("Abbriviation",team.getAbbriviation());
//			  	  			  
//			  //matchups Json			  
//			  JsonObject temp = new JsonObject();			  
//			  for( int j = 0 ; j < matchups.size(); j++)
//			  {
//				Matchup matchup = matchups.get(j);
//				if(matchup.getTeam1() == team)
//					temp.addProperty(matchup.getTeam2().getTeamName(),baseURL+"/matchups/"+ matchup.getMatchupID());	
//				else if(matchup.getTeam2() == team )
//					temp.addProperty(matchup.getTeam1().getTeamName(),baseURL+"/matchups/"+ matchup.getMatchupID());	
//				
//			  }			  
//			  matchupJson.add("Matchups", temp);	
//			  
//			  //Games Json			  
//			  temp = new JsonObject();			  
//			  for( int j = 0 ; j < games.size(); j++)
//			  {
//				Game game = games.get(j);
//				if(game.getId().getMatchupID().getTeam1() == team || game.getId().getMatchupID().getTeam2() == team )
//				{
//					String date = game.getId().getDate();
//					temp.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
//				}
//			  }			  
//			  matchupJson.add("Games", temp);			
//			  			  
//			  result.add(Integer.toString(i), matchupJson);			  
//		  }
//		
//	    return result;
//	  }
//
	@GetMapping("/teamstats/{teamID}/{gameID}")
	public JsonObject one(@PathVariable String teamID, @PathVariable String gameID, HttpServletRequest request) {

		String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		Team team = teamRepository.findByAbbriviation(teamID);
		Game game = gameRepository.findByGameID(Integer.parseInt(gameID));
		Team team2 = game.getId().getMatchupID().getTeam1() != team ? game.getId().getMatchupID().getTeam1() :game.getId().getMatchupID().getTeam2();
		String date = game.getId().getDate();
		Teamstats teamstat = teamstatsRepository.findById(new TeamstatsPK(Integer.parseInt(gameID),team)).orElse(null);
		
		JsonObject result = new JsonObject();
		result.addProperty("team", team.getAbbriviation());
		result.addProperty("against", team2.getAbbriviation());
		result.addProperty(team2.getAbbriviation() +" stat", baseURL+"/teamstats/"+ team2.getAbbriviation()+"/"+ gameID);
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
		
		result.add(team.getAbbriviation()+" stat", temp);
		
		
		return result;
	}

}
