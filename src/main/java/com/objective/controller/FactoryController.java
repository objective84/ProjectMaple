package com.objective.controller;

import com.objective.model.Factory;
import com.objective.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/factory")
public class FactoryController {

	private final FactoryService factoryService;

	@Autowired
	public FactoryController(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Factory> getFactories(){
		return factoryService.getFactories();
	}
}
