package org.theme.web.repository;

import org.hibernate.SessionFactory;
import org.theme.entity.User;

public class UserSessionableRepository implements UserRepository {

	private SessionFactory sessionFactory;

	public User getUser(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User findUserByLoginName(String loginName) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User user where user.loginName = ?")
				.setString(1, loginName).uniqueResult();
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
}
