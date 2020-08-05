package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Player;

public interface PlayerService {
	List<Player> finalAll();
	Player findOne(int id);

}
