package com.aryanrt.stats.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.PlayerService;
import com.aryanrt.stats.service.PlayerstatService;
import com.google.gson.JsonObject;

@RestController
public class playerstatController {

	final private PlayerstatService playerstatService;
	final private PlayerService playerService;
	final private GameService gameService;

	public playerstatController(PlayerstatService playerstatService, PlayerService playerService, GameService gameService) 
	{
		super();
		this.playerstatService = playerstatService;
		this.playerService = playerService;
		this.gameService = gameService;		
	}
	
	@GetMapping(value="/playerstats",produces="application/json")
	List<Playerstat> all(HttpServletRequest request) 
	{
		return playerstatService.findAll();
	}

	@GetMapping(value="/playerstats/{playerID}/{gameID}", produces="application/json")
	public JsonObject one(@PathVariable int playerID, @PathVariable int gameID, HttpServletRequest request) 
	{
		String baseURL = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		JsonObject result = new JsonObject();
		JsonObject temp = new JsonObject();
				
		Player player = playerService.findOne(playerID);
		if(player == null)
			return result;
		
		Playerstat playerstat = playerstatService.findOne(playerID, gameID);
		if(playerstat == null )
			return result;
		
		Game game = gameService.findOne(gameID);
		Team team = player.getId().getTeam();
		Matchup matchup= game.getId().getMatchupID(); 
		Team TeamVS = (matchup.getTeam1()!= team)? matchup.getTeam1():matchup.getTeam2();
		String date = game.getId().getDate();
		
		result.addProperty("href",baseURL+"/playerstats/"+playerID+"/"+gameID);
		String firstName = Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId().getFirstName().substring(1);
		String lastName = Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().getLastName().substring(1);;
		
		result.addProperty("Name",  firstName + " " + lastName );
		result.addProperty("Player Profile",  baseURL+"/players/"+playerID);
		result.addProperty("Team Name",player.getId().getTeam().getTeamName().substring(0,player.getId().getTeam().getTeamName().length()-1));
		result.addProperty("Team href",baseURL+"/teams/"+player.getId().getTeam().getAbbriviation());
		result.addProperty("Agianst",TeamVS.getTeamName()); //.substring(0,opponentName.length()-1));
		result.addProperty("Against href",baseURL+"/teams/"+TeamVS.getAbbriviation());
		result.addProperty("Location",game.getLocation());
		result.addProperty("Date", date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) );

		DecimalFormat df = new DecimalFormat("#.##");		
		temp.addProperty("Points",playerstat.getPts());
		temp.addProperty("Assists",playerstat.getAst());
		temp.addProperty("Steals",playerstat.getStl());
		temp.addProperty("Blocks",playerstat.getBs());
		temp.addProperty("Overall Rebounds",playerstat.getReb());
		temp.addProperty("Off Rebounds",playerstat.getOrb());
		temp.addProperty("Def Rebounds",playerstat.getDrb());
		temp.addProperty("FG %",(playerstat.getFga() != 0) ? Double.parseDouble(df.format(playerstat.getFgm() / playerstat.getFga())) : 0) ;
		temp.addProperty("FGA",playerstat.getFga());
		temp.addProperty("FGM",playerstat.getFgm());
		temp.addProperty("3P %",playerstat.getThreepa() != 0 ?  Double.parseDouble(df.format(playerstat.getThreepm()/playerstat.getThreepa())):0);
		temp.addProperty("3PA",playerstat.getThreepa());
		temp.addProperty("3PM",playerstat.getThreepm());
		temp.addProperty("FT %",playerstat.getFta() != 0 ?  Double.parseDouble(df.format(playerstat.getFtm()/playerstat.getFta())):0);
		temp.addProperty("FTA",playerstat.getFta());
		temp.addProperty("FTM",playerstat.getFtm());
		temp.addProperty("Minutes",playerstat.getMin());
		temp.addProperty("Turnovers",playerstat.getTov());
		temp.addProperty("Personal Fouls",playerstat.getPf());
		  
		result.add("Performance", temp);
		return result;
	}
}
