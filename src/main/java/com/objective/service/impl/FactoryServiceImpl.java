package com.objective.service.impl;

import com.objective.model.Factory;
import com.objective.repository.FactoryRepository;
import com.objective.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

	public Boolean addFactory(Factory factory) {
		factoryRepository.save(factory);
		return true;
	}

	public Boolean generateNumber(Integer id, Integer count) {
		Factory factory = factoryRepository.findOne(id);
		factory.getNumbers().clear();
		Random rand = new Random();
		int max = factory.getUpperLimit();
		int min = factory.getLowerLimit();
		for (int i = 0; i < count; i++) {
			factory.getNumbers().add(rand.nextInt((max - min) + 1) + min);
		}
		factoryRepository.save(factory);
		return true;
	}

	public Boolean deleteFactory(Integer id) {
		factoryRepository.delete(id);
		return true;
	}
}
