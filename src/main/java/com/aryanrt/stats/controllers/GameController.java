package com.aryanrt.stats.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.google.gson.JsonObject;

@RestController
public class GameController {
	
//	@Autowired
//	private MatchupRepository matchupRepository;
//	
	@Autowired
	private GameRepository gameRepository;

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

			  //self Link
			  matchupJson.addProperty("href",baseURL+"/games/"+game.getGameID());
			  matchupJson.addProperty("Location",game.getLocation());
			  
			  //matchup JSON
			  JsonObject temp = new JsonObject();
			  temp.addProperty("team1",matchup.getTeam1().getTeamName());
			  temp.addProperty("team2",matchup.getTeam2().getTeamName());			  
			  temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());			  
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

		  //self Link
		  matchupJson.addProperty("href",baseURL+"/games/"+id);
		  matchupJson.addProperty("Location",game.getLocation());
		  
		  //matchup JSON
		  JsonObject temp = new JsonObject();
		  temp.addProperty("team1",matchup.getTeam1().getTeamName());
		  temp.addProperty("team2",matchup.getTeam2().getTeamName());			  
		  temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());			  
		  matchupJson.add("Matchup", temp);
		  		  
		  
		  result.add("Game", matchupJson);			  
	  
		  return result;
		
	  }

}
