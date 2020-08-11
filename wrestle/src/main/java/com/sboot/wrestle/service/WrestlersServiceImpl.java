package com.sboot.wrestle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sboot.wrestle.dao.WrestlersDAO;
import com.sboot.wrestle.entity.Wrestlers;

@Service
public class WrestlersServiceImpl implements WrestlersService {

private WrestlersDAO wrestlersDAO;
	
	@Autowired
	public WrestlersServiceImpl(WrestlersDAO wrestlersDAO) {
		this.wrestlersDAO = wrestlersDAO;
	}
	
	@Override
	@Transactional
	public List<Wrestlers> findAll() {
		return wrestlersDAO.findAll();
	}

	@Override
	@Transactional
	public Wrestlers findById(int theId) {
		return wrestlersDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Wrestlers wrestlers) {
		wrestlersDAO.save(wrestlers);
	}

	@Override
	@Transactional
	public void deleteById(int Id) {
		wrestlersDAO.deleteById(Id);
	}
}
