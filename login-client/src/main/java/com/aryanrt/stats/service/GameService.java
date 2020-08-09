package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.Matchup;

public interface GameService {
	List<Game> findAll();
	Game findOne(int gameId);
	List<Game> findByMatchup(Matchup matchup);
	List<Game> findByDate(String Date);
}
