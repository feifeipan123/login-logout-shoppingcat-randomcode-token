package com._520it.shopping.dao.impl;

import java.util.List;

import com._520it.shopping.dao.IProductDirDAO;
import com._520it.shopping.dao.IUserDAO;
import com._520it.shopping.domain.Product;
import com._520it.shopping.domain.ProductDir;
import com._520it.shopping.domain.User;
import com._520it.shopping.util.BeanHandler;
import com._520it.shopping.util.BeanListHandler;
import com._520it.shopping.util.JdbcTemplate;

public class UserDAOImpl implements IUserDAO{

	public void save(User obj) {
		 String sql = "insert into t_user(username,password) VALUES(?,?)";
		 Object[] params = {
				     obj.getUsername(),obj.getPassword()
				 };
		 JdbcTemplate.update(sql,params); 
	}

	public void delete(Long id) {
		String sql = "delete from t_user where id=?";
		 JdbcTemplate.update(sql,id); 
	}

	public void update(User obj) {
		 String sql = "update t_user set username=?,password=? where id=?";
		 Object[] params = {
				 obj.getUsername(),obj.getPassword(),obj.getId()
			 };
	     JdbcTemplate.update(sql,params); 
	}

	public User get(Long id) {
		 String sql = "select * from t_user where id=?";
		 return JdbcTemplate.query(sql,new BeanHandler<User>(User.class),id); 
	}

	public List<User> listAll() {
		 String sql = "select * from t_user";
		 return JdbcTemplate.query(sql,new BeanListHandler<User>(User.class)); 
	}


	public User getUserByUsername(String username) {
		  String sql = "select * from t_user where username=? limit 1";
		 return JdbcTemplate.query(sql,new BeanHandler<User>(User.class),username); 
	}
}
