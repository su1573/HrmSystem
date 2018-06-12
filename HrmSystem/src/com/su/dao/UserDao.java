package com.su.dao;

import java.util.List;
import java.util.Map;

import com.su.domain.User;
import com.su.util.Page;

public interface UserDao {
	
	public User checkUserLogin(User user);//�û���¼
	public Integer Count(Map<String,Object> params);     //��ѯ�û�����
	public List<User> selectByPage(Map<String, Object> params);
	public List<User> findAllUser();  //��ѯȫ���û�
	
	public void addUser(User user);  //������û�
	
	public void deleteUser(Integer userId);//����idɾ�û�
	
	public List<User> findUserByName(String userName);  //����ģ���û��������û�
	
	public User findUserById(Integer userId);      //����id�����û�
	
	public void updateUser(User user);    //�����û�
	
	public Page findUserByPage(int currentPage,User user);  //��ҳ��ѯ
	
	public Page findUserByPageName(int currentPage, User user);  //����������ҳ��ѯ

}
