package org.theme.web.repository;

import org.theme.entity.User;

public interface UserRepository {
  public User getUser(long id);
  public User findUserByLoginName(String loginName);
}
