package com.aryanrt.stats.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Game;
import com.aryanrt.stats.models.GamePK;
import com.aryanrt.stats.models.Matchup;

@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameRepository extends PagingAndSortingRepository<Game, GamePK> {

    //Matchup findById(long id);
}