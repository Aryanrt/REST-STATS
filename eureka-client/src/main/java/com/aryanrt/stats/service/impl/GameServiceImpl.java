package com.aryanrt.stats.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.repositories.GameRepository;
import com.aryanrt.stats.service.GameService;

@Service
@Transactional
public class GameServiceImpl implements GameService {

	private GameRepository gameRepository;
	
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	@Override
	public List<Game> findAll() {
		return (List<Game>) gameRepository.findAll();		
	}
	@Override
	public Game findOne(int gameId) {
		return gameRepository.findByGameID(gameId);
	}
}
