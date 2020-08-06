package com.aryanrt.stats.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.models.Teamstat;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.repositories.PlayerRepository;
import com.aryanrt.stats.repositories.TeamstatRepository;
import com.aryanrt.stats.service.DownloadService;
import com.aryanrt.stats.service.GameService;
import com.aryanrt.stats.service.PlayerService;
import com.aryanrt.stats.service.PlayerstatService;
import com.aryanrt.stats.service.TeamService;
import com.aryanrt.stats.service.TeamstatService;
import com.mysql.cj.log.Log;

@Service
@Transactional
public class DownloadServiceImpl implements DownloadService
{
	private GameRepository gameRepository;
	private GameService gameService;
	private TeamService teamService;
	private TeamstatService teamstatService;
	private TeamstatRepository teamstatRepository;
	private PlayerService playerService;
	private PlayerstatService playerstatService;
	
	
	public DownloadServiceImpl(GameRepository gameRepository, GameService gameService, TeamService teamService,
			TeamstatService teamstatService, TeamstatRepository teamstatRepository, PlayerService playerService
			,PlayerstatService playerstatService) {
		super();
		this.gameRepository = gameRepository;
		this.gameService = gameService;
		this.teamService = teamService;
		this.teamstatService = teamstatService;
		this.teamstatRepository = teamstatRepository;
		this.playerService = playerService;
		this.playerstatService = playerstatService;
	}
	public String getStatDate(String date)
	{
		
		String result= "";
		for(Game game: gameService.findByDate(date))
		{			
			String boxScore1="";
			String boxScore2= "";
			Team team1 = game.getId().getMatchupID().getTeam1();
			Team team2 = game.getId().getMatchupID().getTeam2();
			
			result += "Date, "+date.substring(0,4)+"/"+ date.substring(4,6)+"/"+ date.substring(6) +"\n";
			result += "Game,"+team1.getAbbriviation()+ ",vs," + team2.getAbbriviation()+"\n";
			result += "Location,"+game.getLocation()+"\n\n";
			
			for(Playerstat playerstat: playerstatService.findByGameID(game.getGameID()))
			{
				if(playerstat.getMin().equals("0"))
					continue;
				String temp="";
				Player player = playerService.findOne(playerstat.getId().getPlayerID());
				temp += player.getId().getFirstName()+","+ player.getId().getLastName()+"," + playerstat.getPts()+","+
						playerstat.getAst()+","+playerstat.getReb()+","+playerstat.getOrb()+"," +playerstat.getDrb()+","
						+playerstat.getStl()+","+playerstat.getBs()+","+playerstat.getFgm()+","+playerstat.getFga()+","+
						playerstat.getThreepm()+","+playerstat.getThreepa()+","+playerstat.getFtm()+","+playerstat.getFta()+
						","+playerstat.getTov()+","+playerstat.getPf()+","+playerstat.getMin();
				if(player.getId().getTeam() == team1)
					boxScore1 += temp;
				else
					boxScore2 += temp;
			}
			result += "Box Score, "+team1.getTeamName();
			result += ",,PTS,AST,TOT-REB,OFF-REB,DEF-REB,STL,BLK,FGM,FGA,3PM,3PA,FTM,FTA,TOV,FOUL,MIN\n";
			result += boxScore1 +"\n";
			
			result += "Box Score, "+team2.getTeamName();
			result += ",,PTS,AST,TOT-REB,OFF-REB,DEF-REB,STL,BLK,FGM,FGA,3PM,3PA,FTM,FTA,TOV,FOUL,MIN\n";
			result += boxScore2 + "\n\n";
			
			Teamstat teamstat1 = teamstatService.findOne(team1.getAbbriviation(), game.getGameID());
			Teamstat teamstat2 = teamstatService.findOne(team2.getAbbriviation(), game.getGameID());
			
			
		}
		
		return result;
		
	}
	@Override
	public File getStatDate(String date, String teams[])
	{
		return null;
		
	}
	@Override
	public File getStatDateRange(String dateFrom, String dateTo)
	{
		return null;
		
	}
	@Override
	public File getStatDateRange(String dateFrom, String dateTo, String teams[])
	{
		return null;
		
	}
	
}
