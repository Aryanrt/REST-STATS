package com.aryanrt.stats.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.GamePK;
import com.aryanrt.stats.models.Matchup;

@RepositoryRestResource
public interface GameRepository extends PagingAndSortingRepository<Game, GamePK> {
	Game findByGameID(int id);
	List<Game> findById_Date(String Date);
	List<Game> findById_MatchupID(Matchup matchupID);
}