package com.aryanrt.stats.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Team;

@RepositoryRestResource
public interface MatchupRepository extends PagingAndSortingRepository<Matchup, Integer> {
    Matchup findById(int id);
    List<Matchup> findByTeam1(Team team1);
    List<Matchup> findByTeam2(Team team2);
}