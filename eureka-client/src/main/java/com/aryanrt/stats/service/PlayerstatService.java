package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Playerstat;

public interface PlayerstatService {
	List<Playerstat> findAll();
	Playerstat findOne(int playerId, int gameId);
	List<Playerstat> findByGameID(int gameId);
}
