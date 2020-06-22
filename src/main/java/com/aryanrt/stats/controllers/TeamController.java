package com.aryanrt.stats.controllers;

import java.util.List;
import java.util.Optional;

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
import com.aryanrt.stats.repositories.TeamRepository;
import com.google.gson.JsonObject;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.BasicLinkBuilder;


@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository repository;

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private MatchupRepository matchupRepository;

		  // Aggregate root

	  @GetMapping("/teams")
	  public JsonObject all(HttpServletRequest request)
	  {
		  List<Game> games = ((List<Game>) gameRepository.findAll());
		  List<Matchup> matchups = ((List<Matchup>) matchupRepository.findAll());
		  
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		  for(int i=0; i < ((List<Team>) repository.findAll()).size(); i++)
		  {
			  JsonObject matchupJson = new JsonObject();
			  Team team = ((List<Team>) repository.findAll()).get(i);
			  
			  //self Link
			  matchupJson.addProperty("href",baseURL+"/teams/"+team.getAbbriviation());
			  matchupJson.addProperty("name",team.getTeamName());
			  matchupJson.addProperty("Abbriviation",team.getAbbriviation());
			  	  			  
			  //matchups Json			  
			  JsonObject temp = new JsonObject();			  
			  for( int j = 0 ; j < matchups.size(); j++)
			  {
				Matchup matchup = matchups.get(j);
				if(matchup.getTeam1() == team)
					temp.addProperty(matchup.getTeam2().getTeamName(),baseURL+"/matchups/"+ matchup.getMatchupID());	
				else if(matchup.getTeam2() == team )
					temp.addProperty(matchup.getTeam1().getTeamName(),baseURL+"/matchups/"+ matchup.getMatchupID());	
				
			  }			  
			  matchupJson.add("Matchups", temp);	
			  
			  //Games Json			  
			  temp = new JsonObject();			  
			  for( int j = 0 ; j < games.size(); j++)
			  {
				Game game = games.get(j);
				if(game.getId().getMatchupID().getTeam1() == team || game.getId().getMatchupID().getTeam2() == team )
				{
					String date = game.getId().getDate();
					temp.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
				}
			  }			  
			  matchupJson.add("Games", temp);			
			  			  
			  result.add(Integer.toString(i), matchupJson);			  
		  }
		
	    return result;
	  }

	  @GetMapping("/teams/{abbriviation}")
	  public JsonObject one(@PathVariable String abbriviation, HttpServletRequest request) {

		  List<Game> games = ((List<Game>) gameRepository.findAll());
		  List<Matchup> matchups = ((List<Matchup>) matchupRepository.findAll());
		  
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		
		  JsonObject matchupJson = new JsonObject();
		  Team team = repository.findByAbbriviation(abbriviation);
		  
		  //self Link
		  matchupJson.addProperty("href",baseURL+"/teams/"+team.getAbbriviation());
		  matchupJson.addProperty("name",team.getTeamName());
		  matchupJson.addProperty("Abbriviation",team.getAbbriviation());
		  	  			  
		  //matchups Json			  
		  JsonObject temp = new JsonObject();			  
		  for( int j = 0 ; j < matchups.size(); j++)
		  {
			Matchup matchup = matchups.get(j);
			if(matchup.getTeam1() == team)
				temp.addProperty(matchup.getTeam2().getTeamName(),baseURL+"/matchups/"+ matchup.getMatchupID());	
			else if(matchup.getTeam2() == team )
				temp.addProperty(matchup.getTeam1().getTeamName(),baseURL+"/matchups/"+ matchup.getMatchupID());	
			
		  }			  
		  matchupJson.add("Matchups", temp);	
		  
		  //Games Json			  
		  temp = new JsonObject();			  
		  for( int j = 0 ; j < games.size(); j++)
		  {
			Game game = games.get(j);
			if(game.getId().getMatchupID().getTeam1() == team || game.getId().getMatchupID().getTeam2() == team )
			{
				String date = game.getId().getDate();
				temp.addProperty(date.substring(0, 4)+"/"+date.substring(4, 6)+"/"+ date.substring(6),baseURL+"/games/"+ game.getGameID());	
			}
		  }			  
		  matchupJson.add("Games", temp);			
		
	    return matchupJson;
	  }

}
