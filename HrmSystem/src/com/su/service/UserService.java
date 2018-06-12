package com.su.service;

import java.util.List;

import com.su.domain.User;
import com.su.util.Page;
import com.su.util.PageModel;

public interface UserService {
	public User checkUserLogin(User user);  //�û���¼
	
	public List<User> findUser(User user,PageModel pageModel);   //����������ѯ
	
	public List<User> findAllUser();     //��ѯȫ��
	
	public void addUser(User user);  //������û�
	
	public void deleteUser(Integer userId);//����idɾ�û�
	
	public List<User> findUserByName(String userName);  //����ģ���û��������û�
	
	public User findUserById(Integer userId);      //����id�����û�
	
	public void updateUser(User user);    //�����û�
	
	public Page findUserByPage(int currentPage,User user);  //��ҳ��ѯ
	
	public Page findUserByPageName(int currentPage, User user);  //����������ҳ��ѯ

}
