package com.aryanrt.stats.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Teamstat;
import com.aryanrt.stats.models.TeamstatsPK;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.aryanrt.stats.repositories.PlayerRepository;
import com.aryanrt.stats.repositories.PlayerstatRepository;
import com.aryanrt.stats.repositories.TeamstatRepository;
import com.google.gson.JsonObject;

@Controller
public class DownloadController {
	
//	@Autowired
//	private MatchupRepository matchupRepository;
//	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private TeamstatRepository teamstatsRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerstatRepository playerstatRepository;

	 @GetMapping("/downloaded")
	 public String downloaded(@RequestParam(name="one-date", required = false) boolean  oneDate,
			 @RequestParam(name="multi-dates", required = false) boolean  multiDates,
			 @RequestParam(name="date-wanted", required = false) String  dateWanted ,
			 @RequestParam(name="date-from", required = false) String  dateFrom ,
			 @RequestParam(name="date-to", required = false) String  dateTo , 
			 @RequestParam(name="all-teams", required = false) String  allTeams , 
			 @RequestParam(name="some-teams", required = false) String  someTeams ,
			 @RequestParam(name="teams-selected", required = false) String[]  teamsSelected , Model model){

//	        User user = userRepository.findById(userId);
//	        model.addAttribute("user", user);

		 	System.out.println(oneDate);
		 	System.out.println(multiDates);
		 	System.out.println(dateWanted);
		 	System.out.println(dateFrom);
		 	System.out.println(dateTo);
		 	System.out.println(allTeams);
		 	System.out.println(someTeams);
		 	if(teamsSelected!= null);
		 		System.out.println(teamsSelected.length);
	        return "index.html";
	    }
	 
		/* 
		 * @GetMapping(value="/games",produces="application/json") public JsonObject
		 * all(HttpServletRequest request) { List<Game> games = ((List<Game>)
		 * gameRepository.findAll()); String baseURL =
		 * request.getRequestURL().toString().replace(request.getRequestURI(),
		 * request.getContextPath()); JsonObject result = new JsonObject(); for(int i=0;
		 * i < games.size(); i++) { JsonObject matchupJson = new JsonObject(); Game game
		 * = games.get(i); Matchup matchup = game.getId().getMatchupID(); String date =
		 * game.getId().getDate();
		 * 
		 * //self Link
		 * matchupJson.addProperty("href",baseURL+"/games/"+game.getGameID());
		 * matchupJson.addProperty("Location",game.getLocation());
		 * matchupJson.addProperty("Date", date.substring(0,4)+"/"+
		 * date.substring(4,6)+"/"+ date.substring(6) );
		 * 
		 * //matchup JSON JsonObject temp = new JsonObject();
		 * temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());
		 * temp.addProperty("team1",matchup.getTeam1().getTeamName());
		 * temp.addProperty("team1 stats",baseURL+"/teamstats/"+matchup.getTeam1().
		 * getAbbriviation()+"/" +game.getGameID());
		 * temp.addProperty("team2",matchup.getTeam2().getTeamName());
		 * temp.addProperty("team2 stats",baseURL+"/teamstats/"+matchup.getTeam2().
		 * getAbbriviation()+"/" +game.getGameID()); matchupJson.add("Matchup", temp);
		 * 
		 * 
		 * result.add(Integer.toString(i), matchupJson); }
		 * 
		 * return result; }
		 * 
		 * @GetMapping(value="/games/{id}",produces="application/json") public
		 * JsonObject one(@PathVariable int id, HttpServletRequest request) {
		 * 
		 * // List<Game> games = ((List<Game>) gameRepository.findAll()); String baseURL
		 * = request.getRequestURL().toString().replace(request.getRequestURI(),
		 * request.getContextPath()); JsonObject result = new JsonObject(); JsonObject
		 * matchupJson = new JsonObject(); Game game = gameRepository.findByGameID(id);
		 * Matchup matchup = game.getId().getMatchupID(); String date =
		 * game.getId().getDate();
		 * 
		 * //self Link matchupJson.addProperty("href",baseURL+"/games/"+id);
		 * matchupJson.addProperty("Location",game.getLocation());
		 * matchupJson.addProperty("Date", date.substring(0,4)+"/"+
		 * date.substring(4,6)+"/"+ date.substring(6) );
		 * 
		 * //matchup and teamstats JSON JsonObject temp = new JsonObject();
		 * temp.addProperty("href",baseURL+"/matchups/"+matchup.getMatchupID());
		 * temp.addProperty("team1",matchup.getTeam1().getTeamName());
		 * temp.addProperty("team1 stats",baseURL+"/teamstats/"+matchup.getTeam1().
		 * getAbbriviation()+"/" +game.getGameID());
		 * temp.addProperty("team2",matchup.getTeam2().getTeamName());
		 * temp.addProperty("team2 stats",baseURL+"/teamstats/"+matchup.getTeam2().
		 * getAbbriviation()+"/" +game.getGameID());
		 * 
		 * matchupJson.add("Matchup", temp); result.add("Game", matchupJson);
		 * 
		 * temp = new JsonObject(); JsonObject temp2 = new JsonObject();
		 * 
		 * for( int j = 0 ; j < ((List<Player>)playerRepository.findAll()).size(); j++)
		 * { Player player = ((List<Player>)playerRepository.findAll()).get(j);
		 * if(player.getId().getTeam() != matchup.getTeam1() && player.getId().getTeam()
		 * != matchup.getTeam2()) continue;
		 * 
		 * String firstName =
		 * Character.toUpperCase(player.getId().getFirstName().charAt(0))+player.getId()
		 * .getFirstName().substring(1); String lastName =
		 * Character.toUpperCase(player.getId().getLastName().charAt(0))+player.getId().
		 * getLastName().substring(1);; if(player.getId().getTeam() ==
		 * matchup.getTeam1() ) temp.addProperty(firstName+" "+ lastName
		 * ,baseURL+"/playerstats/"+player.getPlayerID()+"/"+id); else
		 * temp2.addProperty(firstName+" "+ lastName
		 * ,baseURL+"/playerstats/"+player.getPlayerID()+"/"+id); }
		 * 
		 * matchupJson.add(matchup.getTeam1().getTeamName()+"Players Stats", temp);
		 * matchupJson.add(matchup.getTeam2().getTeamName()+"Players Stats", temp2);
		 * result.add("Game", matchupJson);
		 * 
		 * return result;
		 * 
		 * }
		 */

}
