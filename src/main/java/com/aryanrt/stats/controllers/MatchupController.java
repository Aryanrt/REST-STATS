package com.aryanrt.stats.controllers;

import java.util.Collection;
//import org.json;
import java.util.List;
import java.util.stream.Collectors;
//import org.springframework.hateoas.Resource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.google.gson.JsonObject;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class MatchupController{
	
	@Autowired
	private MatchupRepository repository;

	  @GetMapping("/matchups")
	  public JsonObject all(HttpServletRequest request)
	  {
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		  for(int i=0; i < ((List<Matchup>) repository.findAll()).size(); i++)
		  {
			  JsonObject matchupJson = new JsonObject();
			  Matchup matchup = ((List<Matchup>) repository.findAll()).get(i);
			  
			  //self Link
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
			  
			  result.add(Integer.toString(i), matchupJson);			  
		  }
		
	    return result;
	  }

	  @GetMapping("/matchups/{id}")
	  public JsonObject one(@PathVariable int id, HttpServletRequest request) {

		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  
		  Matchup matchup = repository.findById(id);
		  
		  JsonObject matchupJson = new JsonObject();
		  //self Link
		  matchupJson.addProperty("href",baseURL+"/matchups/"+id);
		  
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
		  
		  //result.add(Integer.toString(i), matchupJson);	
		  
		  return matchupJson;
		
	  }

}
