
package com.aryanrt.stats.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.aryanrt.stats.repositories.PlayerRepository;
import com.aryanrt.stats.repositories.TeamRepository;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.MatchupService;
import com.aryanrt.stats.service.TeamService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository repository;

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private MatchupRepository matchupRepository;

	
	@Autowired
	private PlayerRepository playerRepository;
	
    private final TeamService teamService;
    private final GameService gameService;
    private final MatchupService matchupService;

    
    public TeamController(TeamService teamService, GameService gameService, MatchupService matchupService) {
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
    		JsonArray gamesJson = new JsonArray();
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
    			
    			for(Game game : gameService.findByMatchup(matchup))
    			{    				
    				String date = game.getId().getDate();
    				tempJson2.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
    				
    			}    			
    			tempJson.add(otherTeam, tempJson2);			
    		}
    		teamJson.add("Matchups", tempJson);
    		result.add(Integer.toString(counter), teamJson);
    		counter++;   		
    	}
    	return result;
	  
    }	  	  

	  @GetMapping(value="/teams/{abbriviation}",produces="application/json")
	  public Team one(@PathVariable String abbriviation, HttpServletRequest request) {
		  return teamService.findOne(abbriviation);
		  //		  List<Game> games = ((List<Game>) gameRepository.findAll());
//		  List<Matchup> matchups = ((List<Matchup>) matchupRepository.findAll());
//		  
//		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
//		
//		  JsonObject result = new JsonObject();
//		  Team team = repository.findByAbbriviation(abbriviation);
//		  
//		  //self Link
//		  result.addProperty("href",baseURL+"/teams/"+team.getAbbriviation());
//		  result.addProperty("name",team.getTeamName());
//		  result.addProperty("Abbriviation",team.getAbbriviation());
//		  
//		  //players Json			  
//		  JsonObject temp = new JsonObject();	
//		  for( int j = 0 ; j < ((List<Player>)playerRepository.findAll()).size(); j++)
//		  {
//			Player player = ((List<Player>)playerRepository.findAll()).get(j);
//			if(player.getId().getTeam() != team)
//				  continue;
//			 
//			 String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
//			 String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);;
//			 temp.addProperty(firstName+" "+ lastName ,baseURL+"/players/"+player.getPlayerID());
//		  }		
//			 
//		  result.add("Players", temp);	
//		  
//		  //matchups Json			  
//		  temp = new JsonObject();			  
//		  for( int j = 0 ; j < matchups.size(); j++)
//		  {
//			Matchup matchup = matchups.get(j);
//			if(matchup.getTeam1() == team)
//				temp.addProperty(matchup.getTeam2().getTeamName().substring(0,matchup.getTeam2().getTeamName().length()-1),baseURL+"/matchups/"+ matchup.getMatchupID());	
//			else if(matchup.getTeam2() == team )
//				temp.addProperty(matchup.getTeam1().getTeamName().substring(0, matchup.getTeam1().getTeamName().length()-1),baseURL+"/matchups/"+ matchup.getMatchupID());	
//			
//		  }			  
//		  result.add("Matchups", temp);	
//		  
//		  //Games Json			  
//		  temp = new JsonObject();			  
//		  for( int j = 0 ; j < games.size(); j++)
//		  {
//			Game game = games.get(j);
//			if(game.getId().getMatchupID().getTeam1() == team || game.getId().getMatchupID().getTeam2() == team )
//			{
//				String date = game.getId().getDate();
//				temp.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
//			}
//		  }			  
//		  result.add("Games", temp);			
//		
//	    return result;
	  }

}
