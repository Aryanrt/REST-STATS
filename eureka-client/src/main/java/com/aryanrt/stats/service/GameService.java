package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Game;

public interface GameService {
	List<Game> findAll();
	Game findOne(int gameId);
}
