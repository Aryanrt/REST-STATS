package com.aryanrt.stats;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.GamePK;
import com.aryanrt.stats.repositories.MatchupRepository;

@Component
class CustomBackendIdConverter implements BackendIdConverter {

	@Autowired
	private MatchupRepository repository;
	
  @Override
  public Serializable fromRequestId(String id, Class<?> entityType) {

    // Make sure you validate the input
	  

    String[] parts = id.split("_");
    GamePK gpk = new GamePK();
    gpk.setMatchupID(repository.findById(Integer.parseInt(parts[0])));
    gpk.setDate(parts[1]);
    return gpk;
  }

  @Override
  public String toRequestId(Serializable source, Class<?> entityType) {

    GamePK gpk = (GamePK) source;
    return String.format("%s_%s", gpk.getMatchupID().getMatchupID(), gpk.getDate());
  }

  @Override
  public boolean supports(Class<?> type) {
    return Game.class.equals(type);
  }
}