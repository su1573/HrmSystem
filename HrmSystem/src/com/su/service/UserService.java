package com.su.service;

import java.util.List;

import com.su.domain.User;
import com.su.util.Page;
import com.su.util.PageModel;

public interface UserService {
	public User checkUserLogin(User user);  //用户登录
	
	public List<User> findUser(User user,PageModel pageModel);   //根据条件查询
	
	public List<User> findAllUser();     //查询全部
	
	public void addUser(User user);  //添加新用户
	
	public void deleteUser(Integer userId);//根据id删用户
	
	public List<User> findUserByName(String userName);  //根据模糊用户名查找用户
	
	public User findUserById(Integer userId);      //根据id查找用户
	
	public void updateUser(User user);    //更新用户
	
	public Page findUserByPage(int currentPage,User user);  //分页查询
	
	public Page findUserByPageName(int currentPage, User user);  //根据条件分页查询

}
