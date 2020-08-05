package com.aryanrt.stats.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.PlayerstatsPK;
import com.aryanrt.stats.repositories.PlayerstatRepository;
import com.aryanrt.stats.service.PlayerstatService;

@Service
@Transactional
public class playerstatServiceImpl implements PlayerstatService{

	private PlayerstatRepository playerstatRepository;

	public playerstatServiceImpl(PlayerstatRepository playerstatRepository) {
		super();
		this.playerstatRepository = playerstatRepository;
	}

	@Override
	public List<Playerstat> findAll() {
		return (List<Playerstat>) playerstatRepository.findAll();
	}

	@Override
	public Playerstat findOne(int playerId, int gameId) {
		return playerstatRepository.findById(new PlayerstatsPK(playerId, gameId)).orElse(null);
	}
	
	
}
