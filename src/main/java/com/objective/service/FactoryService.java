package com.objective.service;

import com.objective.model.Factory;

import java.util.List;

public interface FactoryService {
	List<Factory> getFactories();

	Boolean addFactory(Factory factory);

	Boolean generateNumber(Integer id, Integer count);

	Boolean deleteFactory(Integer id);
}
