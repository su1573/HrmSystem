package com.su.dao;

import java.util.List;
import java.util.Map;

import com.su.domain.User;
import com.su.util.Page;

public interface UserDao {
	
	public User checkUserLogin(User user);//用户登录
	public Integer Count(Map<String,Object> params);     //查询用户总数
	public List<User> selectByPage(Map<String, Object> params);
	public List<User> findAllUser();  //查询全部用户
	
	public void addUser(User user);  //添加新用户
	
	public void deleteUser(Integer userId);//根据id删用户
	
	public List<User> findUserByName(String userName);  //根据模糊用户名查找用户
	
	public User findUserById(Integer userId);      //根据id查找用户
	
	public void updateUser(User user);    //更新用户
	
	public Page findUserByPage(int currentPage,User user);  //分页查询
	
	public Page findUserByPageName(int currentPage, User user);  //根据条件分页查询

}
