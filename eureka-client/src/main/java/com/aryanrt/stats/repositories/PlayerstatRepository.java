package com.aryanrt.stats.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.PlayerstatsPK;

@RepositoryRestResource
public interface PlayerstatRepository extends PagingAndSortingRepository<Playerstat, PlayerstatsPK> {
	List<Playerstat>findById_gameID(int gameID);
}