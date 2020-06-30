package com.aryanrt.stats.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.PlayerPK;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.PlayerstatsPK;
import com.aryanrt.stats.models.TeamstatsPK;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.PlayerRepository;
import com.aryanrt.stats.repositories.PlayerstatRepository;
import com.google.gson.JsonObject;

@RestController
public class playerstatController {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private PlayerstatRepository playerstatRepository;


	  // Aggregate root

	  @GetMapping("/playerstats")
	  JsonObject all(HttpServletRequest request) 
	  {
		//This looks not necessary
		return null;
	  }


	  @GetMapping("/playerstats/{playerID}/{gameID}")
	  public JsonObject one(@PathVariable int playerID, @PathVariable int gameID, HttpServletRequest request) {

		  Player player = playerRepository.findByPlayerID(playerID);
		  String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		  JsonObject result = new JsonObject();

		  PlayerstatsPK pk = new PlayerstatsPK();
		  pk.setGame(gameID);
		  pk.setPlayerID(playerID);
		  Playerstat stat= playerstatRepository.findById(pk).get();
		  Game game = gameRepository.findByGameID(gameID);
		  String opponentName, opp;
		  String date = game.getId().getDate();
		  
		  if( player.getId().getTeam() == game.getId().getMatchupID().getTeam1())
		  {
			  opponentName = game.getId().getMatchupID().getTeam2().getTeamName();
			  opp = game.getId().getMatchupID().getTeam2().getAbbriviation();
		  }
		  else
		  {
			  opponentName = game.getId().getMatchupID().getTeam1().getTeamName();
			  opp = game.getId().getMatchupID().getTeam1().getAbbriviation(); 
		  }
		  
		  
		  result.addProperty("href",baseURL+"/playerstats/"+playerID+"/"+gameID);
			  
		  String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
		  String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);;
		  
		  result.addProperty("Name",  firstName + " " + lastName );
		  result.addProperty("Player Profile",  baseURL+"/players/"+playerID);
		  result.addProperty("Team Name",player.getId().getTeam().getTeamName().substring(0,player.getId().getTeam().getTeamName().length()-1));
		  result.addProperty("Team href",baseURL+"/teams/"+player.getId().getTeam().getAbbriviation());
		  result.addProperty("Agianst",opponentName.substring(0,opponentName.length()-1));
		  result.addProperty("Against href",baseURL+"/teams/"+opp);
		  result.addProperty("Location",game.getLocation());
		  result.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );

		  DecimalFormat df = new DecimalFormat("#.##");
		  
		  JsonObject temp = new JsonObject();
		  temp.addProperty("Points",stat.getPts());
		  temp.addProperty("Assists",stat.getAst());
		  temp.addProperty("Steals",stat.getStl());
		  temp.addProperty("Blocks",stat.getBs());
		  temp.addProperty("Overall Rebounds",stat.getReb());
		  temp.addProperty("Off Rebounds",stat.getOrb());
		  temp.addProperty("Def Rebounds",stat.getDrb());
		  temp.addProperty("FG %",(stat.getFga() != 0) ? Double.parseDouble(df.format(stat.getFgm() / stat.getFga())) : 0) ;
		  temp.addProperty("FGA",stat.getFga());
		  temp.addProperty("FGM",stat.getFgm());
		  temp.addProperty("3P %",stat.getThreepa() != 0 ?  Double.parseDouble(df.format(stat.getThreepm()/stat.getThreepa())):0);
		  temp.addProperty("3PA",stat.getThreepa());
		  temp.addProperty("3PM",stat.getThreepm());
		  temp.addProperty("FT %",stat.getFta() != 0 ?  Double.parseDouble(df.format(stat.getFtm()/stat.getFta())):0);
		  temp.addProperty("FTA",stat.getFta());
		  temp.addProperty("FTM",stat.getFtm());
		  temp.addProperty("Minutes",stat.getMin());
		  temp.addProperty("Turnovers",stat.getTov());
		  temp.addProperty("Personal Fouls",stat.getPf());
		  
		  result.add("Performance", temp);

		  
		
		  return result;
	  }
}
