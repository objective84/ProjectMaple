package com.objective.controller;

import com.objective.model.Factory;
import com.objective.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Boolean addFactories(@RequestBody Factory factory){
		return factoryService.addFactory(factory);
	}

	@RequestMapping(value = "/generate/{id}/{count}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean generateNumber(@PathVariable Integer id, @PathVariable Integer count){
		return factoryService.generateNumber(id, count);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean generateNumber(@PathVariable Integer id){
		return factoryService.deleteFactory(id);
	}

}
