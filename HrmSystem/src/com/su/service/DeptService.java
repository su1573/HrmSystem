package com.su.service;

import java.util.List;

import com.su.domain.Dept;
import com.su.util.Page;

public interface DeptService {
	
	public List<Dept> findAllDept(); //查询全部部门
	
	public List<Dept> findDeptByName(String deptName);  //根据部门名称查找
	
	public void deleteDept(Integer deptId);   //根据id删除部门
	
	public Dept findDeptById(Integer deptId);  //根据id查找部门
	
	public void updateDept(Dept dept);   //更新部门
	
	public void addDept(Dept dept);    //新增部门
	
	public Page findDeptByPage(Dept dept,int currentPage);  //分页查询
	
	public int findCount();   //查询总数
}
