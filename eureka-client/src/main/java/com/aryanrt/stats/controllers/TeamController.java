
package com.aryanrt.stats.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.MatchupService;
import com.aryanrt.stats.service.PlayerService;
import com.aryanrt.stats.service.TeamService;
import com.google.gson.JsonObject;


@RestController
public class TeamController {
	
    private final TeamService teamService;
    private final GameService gameService;
    private final MatchupService matchupService;
    private final PlayerService playerService;

    
    public TeamController(TeamService teamService, GameService gameService, MatchupService matchupService, PlayerService playerService) {
    	this.playerService = playerService;
        this.teamService = teamService;
        this.gameService = gameService;
        this.matchupService = matchupService;
    }

    @GetMapping(value="/teams",produces="application/json")
    public JsonObject all(HttpServletRequest request)
    {
    	String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
    	JsonObject result = new JsonObject();
    	int counter =1;
    	
    	for(Team team: teamService.findAll())
    	{
    		JsonObject teamJson = new JsonObject();
    		JsonObject tempJson = new JsonObject();    
    		JsonObject tempJson2 = new JsonObject();
		  
    		//self Link
    		teamJson.addProperty("href",baseURL+"/teams/"+team.getAbbriviation());
    		teamJson.addProperty("name",team.getTeamName());
    		teamJson.addProperty("Abbriviation",team.getAbbriviation());      		
    		
    		//matchups
    		for(Matchup matchup: matchupService.findAll(team))	
    		{
    			tempJson2 = new JsonObject();
    			String otherTeam = (matchup.getTeam1().getTeamName() == team.getTeamName()? matchup.getTeam2().getTeamName():matchup.getTeam1().getTeamName()); 
    			tempJson2.addProperty("Matchup Link" ,baseURL+"/matchups/"+ matchup.getMatchupID());
    			
    			//games
    			for(Game game : gameService.findByMatchup(matchup))
    			{    				
    				String date = game.getId().getDate();
    				tempJson2.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
      			}    			
    			tempJson.add(otherTeam, tempJson2);			
    		}
    		teamJson.add("Matchups and Games", tempJson);
    		result.add(Integer.toString(counter), teamJson);
    		counter++;   		
    	}
    	return result;	  
    }	  	  

    @GetMapping(value="/teams/{abbriviation}",produces="application/json")
	public JsonObject one(@PathVariable String abbriviation, HttpServletRequest request) {
    	String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
    	JsonObject result = new JsonObject();
    	Team team = teamService.findOne(abbriviation);
    	JsonObject tempJson = new JsonObject();	
    	JsonObject tempJson2 = new JsonObject();
    	
    	//self Link
    	result.addProperty("href",baseURL+"/teams/"+team.getAbbriviation());
    	result.addProperty("name",team.getTeamName());
    	result.addProperty("Abbriviation",team.getAbbriviation());
    		
    	//players
    	for(Player player: playerService.findByTeam(team))
    	{
    		String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
			String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);
			tempJson.addProperty(firstName+" "+ lastName ,baseURL+"/players/"+player.getPlayerID());    		
    	}	
    	result.add("Players", tempJson);
    	
    	tempJson = new JsonObject();
    	//matchups
		for(Matchup matchup: matchupService.findAll(team))	
		{
			tempJson2 = new JsonObject();
			String otherTeam = (matchup.getTeam1().getTeamName() == team.getTeamName()? matchup.getTeam2().getTeamName():matchup.getTeam1().getTeamName()); 
			tempJson2.addProperty("Matchup Link" ,baseURL+"/matchups/"+ matchup.getMatchupID());
			
			//games
			for(Game game : gameService.findByMatchup(matchup))
			{    				
				String date = game.getId().getDate();
				tempJson2.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
				
			}    			
			tempJson.add(otherTeam, tempJson2);			
		}
		result.add("Matchups and Games", tempJson);    	
    	return result;
	  }

}
