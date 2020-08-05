package com.aryanrt.stats.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.PlayerRepository;
import com.aryanrt.stats.repositories.PlayerstatRepository;
import com.google.gson.JsonObject;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private PlayerstatRepository playerstatRepository;
	@Autowired
	private GameRepository gameRepository;


	  // Aggregate root

	  @GetMapping(value="/players",produces="application/json")
	  JsonObject all(HttpServletRequest request) 
	  {
		  List<Player> players = ((List<Player>) playerRepository.findAll());
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		  for(int i=0; i < players.size(); i++)
		  {
			  JsonObject playerJson = new JsonObject();
			  Player player = players.get(i);
			  //self Link
			  playerJson.addProperty("href",baseURL+"/players/"+player.getPlayerID());
			  			  
			  String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
			  String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);;
			  
			  playerJson.addProperty("Name",  firstName + " " + lastName );
			  playerJson.addProperty("Team",player.getId().getTeam().getTeamName().substring(0,player.getId().getTeam().getTeamName().length()-1));	  
			  result.add(Integer.toString(player.getPlayerID()), playerJson);
		  }
		  return result;
	  }


	  @GetMapping(value="/players/{id}", produces="application/json")
	  JsonObject one(@PathVariable int id, HttpServletRequest request) {

		  Player player = playerRepository.findByPlayerID(id);
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();
		  
		  
		  result.addProperty("href",baseURL+"/players/"+player.getPlayerID());
			  
		  String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
		  String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);;
		  
		  result.addProperty("Name",  firstName + " " + lastName );
		  result.addProperty("Team Name",player.getId().getTeam().getTeamName().substring(0,player.getId().getTeam().getTeamName().length()-1));
		  result.addProperty("Team href",baseURL+"/teams/"+player.getId().getTeam().getAbbriviation());

		  DecimalFormat df = new DecimalFormat("#.##");
		  
		  JsonObject temp = new JsonObject();
		  temp.addProperty("Points",player.getPts());
		  temp.addProperty("Assists",player.getAst());
		  temp.addProperty("Steals",player.getStl());
		  temp.addProperty("Blocks",player.getBs());
		  temp.addProperty("Overall Rebounds",player.getReb());
		  temp.addProperty("Off Rebounds",player.getOrb());
		  temp.addProperty("Def Rebounds",player.getDrb());
		  temp.addProperty("FG %",(player.getFga() != 0) ? Double.parseDouble(df.format(player.getFgm() / player.getFga())) : 0) ;
		  temp.addProperty("FGA",player.getFga());
		  temp.addProperty("FGM",player.getFgm());
		  temp.addProperty("3P %",player.getThreepa() != 0 ?  Double.parseDouble(df.format(player.getThreepm()/player.getThreepa())):0);
		  temp.addProperty("3PA",player.getThreepa());
		  temp.addProperty("3PM",player.getThreepm());
		  temp.addProperty("FT %",player.getFta() != 0 ?  Double.parseDouble(df.format(player.getFtm()/player.getFta())):0);
		  temp.addProperty("FTA",player.getFta());
		  temp.addProperty("FTM",player.getFtm());
		  temp.addProperty("Minutes",player.getMin());
		  temp.addProperty("Turnovers",player.getTov());
		  temp.addProperty("Personal Fouls",player.getPf());
		  
		  result.add("Season Averages(per game)", temp);
		  
		  temp = new JsonObject();
		  for( Playerstat stat: playerstatRepository.findAll())
		  {
			  if(stat.getId().getPlayerID() != id)
				  continue;
			  temp.addProperty(Integer.toString(stat.getId().getGameID()), baseURL+"/playerstats/"+stat.getId().getPlayerID()+"/"+stat.getId().getGameID());
		  }
		  result.add("Individual Stats", temp);

		  
		
		  return result;
	  }

}
