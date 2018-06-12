package com.su.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.UserDao;
import com.su.domain.User;
import com.su.mapper.UserMapper;
import com.su.service.UserService;
import com.su.util.Page;
import com.su.util.PageModel;

public class UserServiceImpl  implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public User checkUserLogin(User user) {
		// TODO Auto-generated method stub
		System.out.println("in UserServiceImpl method checkUserLogin()");
		return userMapper.checkUserLogin(user);
	}


	@Override
	public List<User> findUser(User user, PageModel pageModel) {
		// TODO Auto-generated method stub
		System.out.println("in UserServiceImpl method findUser()");
		Map<String,Object> params = new HashMap<>();   //当前需要分页的总数据条数
		params.put("user", user);
		int recordCount = userDao.Count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
			params.put("pageModel", pageModel);  //开始分页查询数据：查询第几页的数据
		}
		List<User> list ;
		return null;
	}


	@Override
	public List<User> findAllUser() {
		
		return userDao.findAllUser();
	}


	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}


	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}


	@Override
	public List<User> findUserByName(String userName) {
		
		return userDao.findUserByName(userName);
	}


	@Override
	public User findUserById(Integer userId) {
		
		return userDao.findUserById(userId);
	}


	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}


	@Override
	public Page findUserByPage(int currentPage, User user) {
		
		return userDao.findUserByPage(currentPage, user);
	}


	@Override
	public Page findUserByPageName(int currentPage, User user) {
		
		return userDao.findUserByPageName(currentPage, user);
	}
	
	
	
	
	
	

}
