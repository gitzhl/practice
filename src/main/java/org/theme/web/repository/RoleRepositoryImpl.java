package org.theme.web.repository;

import org.hibernate.SessionFactory;
import org.theme.entity.Role;

public class RoleRepositoryImpl implements RoleRepository {

	private SessionFactory sessionFactory;
	
	@Override
	public void save(Role role) {
		sessionFactory.getCurrentSession().persist(role);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
