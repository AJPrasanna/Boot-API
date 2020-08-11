package com.sboot.wrestle.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sboot.wrestle.entity.Wrestlers;

@Repository
public class WrestlersDAOImpl implements WrestlersDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public WrestlersDAOImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	@Override
	public List<Wrestlers> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query<Wrestlers> query=
				session.createQuery("from Wrestlers",Wrestlers.class);
		
		List<Wrestlers> wrestlerlist = query.getResultList();
		return wrestlerlist;
	}
	@Override
	public Wrestlers findById(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Wrestlers wrestler =
				currentSession.get(Wrestlers.class, theId);
		
		// return the employee
		return wrestler;
	}
	@Override
	public void save(Wrestlers wrestler) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(wrestler);
		
	}
	@Override
	public void deleteById(int Id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Wrestlers where id=:theId");
		theQuery.setParameter("theId", Id);
		
		theQuery.executeUpdate();
		
	}

}
