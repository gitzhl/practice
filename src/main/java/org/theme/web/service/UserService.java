package org.theme.web.service;

import org.theme.entity.User;
import org.theme.web.command.SignupCommand;

public interface UserService {
	public static final String HASH_ALGORITHM = "MD5";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
	public User getUser(long id);
	public User findUserByLoginName(String loginName);
	public void save(SignupCommand command);
}
