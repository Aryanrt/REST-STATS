package com.aryanrt.stats.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.MatchupService;
import com.google.gson.JsonObject;


@RestController
public class MatchupController{
	
    private final MatchupService matchupService;
    private final GameService gameService;
    
    public MatchupController(MatchupService matchupService, GameService gameService) 
    {
        this.matchupService = matchupService;
        this.gameService = gameService;
    }

    @GetMapping(value="/matchups", produces="application/json")
    public JsonObject all(HttpServletRequest request)
    {
    	JsonObject result = new JsonObject();
    	String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
    	int counter = 1;
    	
    	for(Matchup matchup: matchupService.findAll())
    	{
    		JsonObject matchupJson = new JsonObject();
    		matchupJson.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());
    		
    		//team1 JSON
    		JsonObject temp = new JsonObject();
    		temp.addProperty("Abbriviation",matchup.getTeam1().getAbbriviation());
    		temp.addProperty("Name",matchup.getTeam1().getTeamName());
    		temp.addProperty("href",baseURL+"/teams/"+matchup.getTeam1().getAbbriviation());	
    		matchupJson.add("Team 1", temp);
			//Team2 Json
			temp = new JsonObject();
			temp.addProperty("Abbriviation",matchup.getTeam2().getAbbriviation());
			temp.addProperty("Name",matchup.getTeam2().getTeamName());
			temp.addProperty("href",baseURL+"/teams/"+matchup.getTeam2().getAbbriviation());			  
			matchupJson.add("Team 2", temp);	
			
			//Games Json	
			temp = new JsonObject();
			for(Game game: gameService.findByMatchup(matchup))
			{
				String date = game.getId().getDate();
				temp.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());
			}
			matchupJson.add("Games", temp);
			result.add(Integer.toString(counter++), matchupJson);	   
    	}    	
    	return result;
  }

    @GetMapping(value="/matchups/{id}",produces="application/json")
    public JsonObject one(@PathVariable int id, HttpServletRequest request) {
    	JsonObject result = new JsonObject();
    	String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
    	
    	//self link
    	result.addProperty("href",baseURL+"/matchups/"+id);
    	Matchup matchup = matchupService.findOne(id);
    	
    	//team1 JSON
		JsonObject temp = new JsonObject();
		temp.addProperty("Abbriviation",matchup.getTeam1().getAbbriviation());
		temp.addProperty("Name",matchup.getTeam1().getTeamName());
		temp.addProperty("href",baseURL+"/teams/"+matchup.getTeam1().getAbbriviation());	
		result.add("Team 1", temp);
		//Team2 Json
		temp = new JsonObject();
		temp.addProperty("Abbriviation",matchup.getTeam2().getAbbriviation());
		temp.addProperty("Name",matchup.getTeam2().getTeamName());
		temp.addProperty("href",baseURL+"/teams/"+matchup.getTeam2().getAbbriviation());			  
		result.add("Team 2", temp);	
		
		//Games Json	
		temp = new JsonObject();
		for(Game game: gameService.findByMatchup(matchup))
		{
			String date = game.getId().getDate();
			temp.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());
		}
		result.add("Games", temp);
		return result;	
  }

}
