package com._520it.shopping.test;

import java.util.List;

import org.junit.Test;

import com._520it.shopping.dao.IUserDAO;
import com._520it.shopping.dao.impl.UserDAOImpl;
import com._520it.shopping.domain.User;



public class UserDAOTest {
	private IUserDAO dao = new UserDAOImpl();
	@Test
	public void testSave() {
		User u = new User();
		 u.setUsername("haha");
		 u.setPassword("123456");
		 dao.save(u);
	}
	
	@Test
	public void testUpdate() {
		User u = dao.get(4L);
		 u.setUsername("潘飞飞");
		 dao.update(u);
	}
	
	@Test
	public void testGet() {
		User u = dao.get(2L);
		System.out.println(u);
	}
	
	@Test
	public void testListAll() {
		List<User> list = dao.listAll();
		System.out.println(list);
	}
	
	@Test
	public void testGetUserByUsername() {
		User u = dao.getUserByUsername("潘飞飞111");
		System.out.println(u);
	}
}
