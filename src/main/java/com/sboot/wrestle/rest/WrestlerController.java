package com.sboot.wrestle.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.wrestle.dao.WrestlersDAO;
import com.sboot.wrestle.entity.Wrestlers;
import com.sboot.wrestle.service.WrestlersService;

@RestController
@RequestMapping("/api")
public class WrestlerController {
	
	private WrestlersService wrestlersService;
	
	@Autowired
	public WrestlerController(WrestlersService wrestlersService)
	{
		this.wrestlersService=wrestlersService;
	}
	@GetMapping("/wrestlers")
	public List<Wrestlers> findAll()
	{
		return this.wrestlersService.findAll();
		
	}
	
	@GetMapping("/wrestlers/{Id}")
	public Wrestlers getWrestler(@PathVariable int Id) {
		
		Wrestlers wrestler = wrestlersService.findById(Id);
		
		if (wrestler == null) {
			throw new RuntimeException("wrestler id not found - " + Id);
		}
		
		return wrestler;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/wrestlers")
	public Wrestlers addWrestler(@RequestBody Wrestlers wrestler) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		wrestler.setId(0);
		
		wrestlersService.save(wrestler);
		
		return wrestler;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/wrestlers")
	public Wrestlers updateWrestler(@RequestBody Wrestlers wrestler) {
		
		wrestlersService.save(wrestler);
		
		return wrestler;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/wrestlers/{Id}")
	public String deleteEmployee(@PathVariable int Id) {
		
		Wrestlers tempEmployee = wrestlersService.findById(Id);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("wrestler id not found - " + Id);
		}
		
		wrestlersService.deleteById(Id);
		
		return "Deleted wrestler  id - " + Id;
	}
}
