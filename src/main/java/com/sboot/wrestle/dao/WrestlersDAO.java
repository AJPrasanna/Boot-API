package com.sboot.wrestle.dao;

import java.util.List;

import com.sboot.wrestle.entity.Wrestlers;

public interface WrestlersDAO {
	
	public List<Wrestlers> findAll();
	
	public Wrestlers findById(int theId);
	
	public void save(Wrestlers wrestler);
	
	public void deleteById(int Id);

}
