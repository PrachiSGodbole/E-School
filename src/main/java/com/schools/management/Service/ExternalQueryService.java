package com.schools.management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schools.management.Model.ExternalQueries;
import com.schools.management.Repository.ExternalQueryRepository;

@Service
public class ExternalQueryService {

	@Autowired
	private ExternalQueryRepository externalQueryRepository;
	
	public void saveQuery(ExternalQueries externalQueries) {
		externalQueries.setIsActive(true);
		externalQueryRepository.save(externalQueries);
	}
}
