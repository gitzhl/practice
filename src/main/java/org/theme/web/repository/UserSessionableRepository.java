package org.theme.web.repository;

import org.hibernate.SessionFactory;
import org.theme.entity.User;

public class UserSessionableRepository implements UserRepository {

	private SessionFactory sessionFactory;
	

	public User getUser(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User findUserByLoginName(String loginName) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User user where user.loginName = :loginName")
				.setString("loginName", loginName).uniqueResult();
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
