package com.aryanrt.stats.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Teamstats;
import com.aryanrt.stats.models.TeamstatsPK;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.aryanrt.stats.repositories.TeamstatsRepository;
import com.google.gson.JsonObject;

@RestController
public class GameController {
	
//	@Autowired
//	private MatchupRepository matchupRepository;
//	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private TeamstatsRepository teamstatsRepository;

	  @GetMapping("/games")
	  public JsonObject all(HttpServletRequest request)
	  {
		  List<Game> games = ((List<Game>) gameRepository.findAll());
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		  for(int i=0; i < games.size(); i++)
		  {
			  JsonObject matchupJson = new JsonObject();
			  Game game = games.get(i);
			  Matchup matchup = game.getId().getMatchupID();
			  String date = game.getId().getDate();

			  //self Link
			  matchupJson.addProperty("href",baseURL+"/games/"+game.getGameID());
			  matchupJson.addProperty("Location",game.getLocation());
			  matchupJson.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );
			  
			  //matchup JSON
			  JsonObject temp = new JsonObject();
			  temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());	
			  temp.addProperty("team1",matchup.getTeam1().getTeamName());
			  temp.addProperty("team1 stats",baseURL+"/teamstats/"+matchup.getTeam1().getAbbriviation()+"/" +game.getGameID());
			  temp.addProperty("team2",matchup.getTeam2().getTeamName());		
			  temp.addProperty("team2 stats",baseURL+"/teamstats/"+matchup.getTeam2().getAbbriviation()+"/" +game.getGameID());		  
			  matchupJson.add("Matchup", temp);
			  		  
			  
			  result.add(Integer.toString(i), matchupJson);			  
		  }
	
		  return result;
	  }

	  @GetMapping("/games/{id}")
	  public JsonObject one(@PathVariable int id, HttpServletRequest request) {

		//  List<Game> games = ((List<Game>) gameRepository.findAll());
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		  JsonObject matchupJson = new JsonObject();
		  Game game = gameRepository.findByGameID(id);
		  Matchup matchup = game.getId().getMatchupID();
		  String date = game.getId().getDate();
		  
		  //self Link
		  matchupJson.addProperty("href",baseURL+"/games/"+id);
		  matchupJson.addProperty("Location",game.getLocation());
		  matchupJson.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );

		  //matchup and teamstats JSON
		  JsonObject temp = new JsonObject();
		  temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());
		  temp.addProperty("team1",matchup.getTeam1().getTeamName());
		  temp.addProperty("team1 stats",baseURL+"/teamstats/"+matchup.getTeam1().getAbbriviation()+"/" +game.getGameID());
		  temp.addProperty("team2",matchup.getTeam2().getTeamName());
		  temp.addProperty("team2 stats",baseURL+"/teamstats/"+matchup.getTeam2().getAbbriviation()+"/" +game.getGameID());
		  			  
		  matchupJson.add("Matchup", temp);
		  		  
		  
		  result.add("Game", matchupJson);			  
	  
		  return result;
		
	  }

}
