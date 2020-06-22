package com.aryanrt.stats.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.GamePK;
import com.aryanrt.stats.models.Matchup;

@RepositoryRestResource(collectionResourceRel = "games", path = "games")
public interface GameRepository extends PagingAndSortingRepository<Game, GamePK> {

	
}