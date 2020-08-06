package com.aryanrt.stats.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.PlayerstatsPK;
import com.aryanrt.stats.models.Team;
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
	@Override
	public List<Playerstat> findByGameID(int gameId) {
		return playerstatRepository.findById_gameID(gameId);
	}
	@Override
	public List<Playerstat> findByPlayerId(int playerId) {
		List<Playerstat> result = new ArrayList<Playerstat>();
		
		for(Playerstat playerstat: playerstatRepository.findById_playerID(playerId))
		{
			if(! playerstat.getMin().equals("0"))
				result.add(playerstat);
		}
		
		return result;
	}
	
	
}
