package org.theme.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theme.entity.User;
import org.theme.web.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User getUser(long id) {
		return userRepository.getUser(id);
	}

	public User findUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userRepository.findUserByLoginName(loginName);
	}

	public void save(User user) {
		userRepository.save(user);
	}

}
