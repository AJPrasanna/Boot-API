package com.sboot.wrestle.service;

import java.util.List;

import com.sboot.wrestle.entity.Wrestlers;

public interface WrestlersService {
	

	public List<Wrestlers> findAll();
	
	public Wrestlers findById(int theId);
	
	public void save(Wrestlers wrestler);
	
	public void deleteById(int Id);

}
