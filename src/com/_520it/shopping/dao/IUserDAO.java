package com._520it.shopping.dao;

import java.util.List;

import com._520it.shopping.domain.ProductDir;
import com._520it.shopping.domain.User;

public interface IUserDAO {
	void save(User Obj);
	void delete(Long id);
	void update(User obj);
	User get(Long i);
	List<User> listAll();
	User getUserByUsername(String username);
}
