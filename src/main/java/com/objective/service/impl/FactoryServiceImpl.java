package com.objective.service.impl;

import com.objective.model.Factory;
import com.objective.repository.FactoryRepository;
import com.objective.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {

	public final FactoryRepository factoryRepository;

	@Autowired
	public FactoryServiceImpl(FactoryRepository factoryRepository) {
		this.factoryRepository = factoryRepository;
	}

	public List<Factory> getFactories() {
		return factoryRepository.findAll();
	}
}
