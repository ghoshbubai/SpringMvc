package com.sony;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory sf;
	
	//Declarative transaction
	@Transactional
	public void addEmployee(Employee e)
	{
		Session session = sf.getCurrentSession();
		session.save(e);
	}
}
