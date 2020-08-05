package com.aryanrt.stats.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.repositories.PlayerRepository;
import com.aryanrt.stats.service.PlayerService;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}

	@Override
	public List<Player> finalAll() {
		return (List<Player>) playerRepository.findAll();
	}

	@Override
	public Player findOne(int id) {
		// TODO Auto-generated method stub
		return playerRepository.findByPlayerID(id);
	}

}
