package org.theme.web.service;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theme.entity.User;
import org.theme.web.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IdentityService identityService;
	
	public User getUser(long id) {
		return userRepository.getUser(id);
	}

	public User findUserByLoginName(String loginName) {
		return userRepository.findUserByLoginName(loginName);
	}

	public void save(User user) {
		userRepository.save(user);
		syncToActiviti(user);
	}
	
	/**
	 * @see 同步用户信息到Activiti
	 * @param user
	 */
	public void syncToActiviti(User user){
		String role = user.getRoles().split(",")[0];
		org.activiti.engine.identity.User identity = identityService.newUser(user.getLoginName());
		identity.setEmail(user.getEmail());
		identity.setFirstName(user.getName());
		Group queryed = identityService.createGroupQuery().groupId(role).singleResult();
		if(queryed == null){
			queryed = identityService.newGroup(role);
			identityService.saveGroup(queryed);
		}
		identityService.saveUser(identity);
		identityService.createMembership(user.getLoginName(), role);
	}
}
