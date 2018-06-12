package com.su.service;

import java.util.List;

import com.su.domain.Dept;
import com.su.util.Page;

public interface DeptService {
	
	public List<Dept> findAllDept(); //��ѯȫ������
	
	public List<Dept> findDeptByName(String deptName);  //���ݲ������Ʋ���
	
	public void deleteDept(Integer deptId);   //����idɾ������
	
	public Dept findDeptById(Integer deptId);  //����id���Ҳ���
	
	public void updateDept(Dept dept);   //���²���
	
	public void addDept(Dept dept);    //��������
	
	public Page findDeptByPage(Dept dept,int currentPage);  //��ҳ��ѯ
	
	public int findCount();   //��ѯ����
}
