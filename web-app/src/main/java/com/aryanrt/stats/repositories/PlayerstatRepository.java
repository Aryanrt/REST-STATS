package com.aryanrt.stats.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.PlayerstatsPK;

@RepositoryRestResource(collectionResourceRel = "playerstat", path = "playerstat")
public interface PlayerstatRepository extends PagingAndSortingRepository<Playerstat, PlayerstatsPK> {
	//List<Playerstat>findByGameID(int gameID);
}