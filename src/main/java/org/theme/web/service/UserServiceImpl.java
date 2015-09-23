package org.theme.web.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theme.entity.User;
import org.theme.web.command.SignupCommand;
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

	public void save(SignupCommand command) {
		User user = new User();
		user.setName(command.getName());
		user.setLoginName(command.getUsername());
		user.setPassword(new Md5Hash(command.getPassword()).toHex());
		user.setRegisterDate(new Date());
		user.setRoles("user");
		user.setEmail(command.getEmail());
		user.setSalt(System.currentTimeMillis()+"");
		userRepository.save(user);
		syncToActiviti(user);
	}
	
	/**
	 * @see 同步用户信息到Activiti
	 * @param user
	 */
	@Transactional
	public void syncToActiviti(User user){
		org.activiti.engine.identity.User identity = identityService.newUser(user.getLoginName());
		identity.setEmail(user.getEmail());
		identity.setFirstName(user.getName());
		Group queryed = identityService.createGroupQuery().groupId(user.getRoles()).singleResult();
		if(queryed == null){
			queryed = identityService.newGroup(user.getRoles());
			identityService.saveGroup(queryed);
		}
		identityService.saveUser(identity);
		identityService.createMembership(user.getLoginName(), user.getRoles());
	}
}
