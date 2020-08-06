package com.aryanrt.stats.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.PlayerService;
import com.aryanrt.stats.service.PlayerstatService;
import com.google.gson.JsonObject;

@RestController
public class GameController {
		
	private GameService gameService;
	private PlayerService playerService;
	private PlayerstatService playerstatService;
	
	public GameController(GameService gameService, PlayerService playerService, PlayerstatService playerstatService)
	{
		this.gameService = gameService;
		this.playerService = playerService;
		this.playerstatService = playerstatService;
	}

  @GetMapping(value="/games",produces="application/json")
  public JsonObject all(HttpServletRequest request)
  {
	  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
	  JsonObject result = new JsonObject();
	  int counter = 1;
	  
	  for(Game game: gameService.findAll())
	  {
		  JsonObject matchupJson = new JsonObject(); 
		  Matchup matchup = game.getId().getMatchupID();
		  String date = game.getId().getDate();
		  
		  //self Link
		  matchupJson.addProperty("href",baseURL+"/games/"+game.getGameID());
		  matchupJson.addProperty("Location",game.getLocation());
		  matchupJson.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );

		  //matchups
		  JsonObject temp = new JsonObject();
		  temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());	
		  temp.addProperty("team1",matchup.getTeam1().getTeamName());
		  temp.addProperty("team1 stats",baseURL+"/teamstats/"+matchup.getTeam1().getAbbriviation()+"/" +game.getGameID());
		  temp.addProperty("team2",matchup.getTeam2().getTeamName());		
		  temp.addProperty("team2 stats",baseURL+"/teamstats/"+matchup.getTeam2().getAbbriviation()+"/" +game.getGameID());		  
		  matchupJson.add("Matchup", temp); 
		  result.add(Integer.toString(counter++), matchupJson);
	  }
	  return result; 
  }

  @GetMapping(value="/games/{id}",produces="application/json")
  public JsonObject one(@PathVariable int id, HttpServletRequest request) 
  {
	  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
	  JsonObject result = new JsonObject();
	  JsonObject matchupJson = new JsonObject();
	  JsonObject temp = new JsonObject();
	  JsonObject temp2 = new JsonObject();
	  Game game = gameService.findOne(id);
	  Matchup matchup = game.getId().getMatchupID();
	  String date = game.getId().getDate();
	  
	  //self Link
	  matchupJson.addProperty("href",baseURL+"/games/"+id);
	  matchupJson.addProperty("Location",game.getLocation());
	  matchupJson.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );
	  
	  //matchup and teamstats JSON
	  temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());
	  temp.addProperty("team1",matchup.getTeam1().getTeamName());
	  temp.addProperty("team1 stats",baseURL+"/teamstats/"+matchup.getTeam1().getAbbriviation()+"/" +game.getGameID());
	  temp.addProperty("team2",matchup.getTeam2().getTeamName());
	  temp.addProperty("team2 stats",baseURL+"/teamstats/"+matchup.getTeam2().getAbbriviation()+"/" +game.getGameID());
	  
	  matchupJson.add("Matchup", temp);		  
	  result.add("Game", matchupJson);
	  
	  temp = new JsonObject();
	  for(Playerstat playerstat: playerstatService.findByGameID(id))
	  {
		  Player player = playerService.findOne(playerstat.getId().getPlayerID());
		  String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
		  String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);;  
		
		  if(player.getId().getTeam() == matchup.getTeam1())
			  temp.addProperty(firstName+" "+ lastName ,baseURL+"/playerstats/"+player.getPlayerID()+"/"+id);
		  else
			  temp2.addProperty(firstName+" "+ lastName ,baseURL+"/playerstats/"+player.getPlayerID()+"/"+id);
	  }
	  matchupJson.add(matchup.getTeam1().getTeamName()+"Players Stats", temp);
	  matchupJson.add(matchup.getTeam2().getTeamName()+"Players Stats", temp2);
	  result.add("Game", matchupJson);	
	  return result;
  }
}
