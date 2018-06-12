package com.su.mapper;

import java.util.List;

import com.su.domain.Dept;
import com.su.util.Page;

public interface DeptMapper {
	
	public List<Dept> findAllDept();
	
	public List<Dept> findDeptByName(String deptName);
	
	public void deleteDept(Integer deptId);
	
	public Dept findDeptById(Integer deptId);
	
	public void updateDept(Dept dept);
	
	public void addDept(Dept dept);
	
	public List<Dept> findDeptByPage(Dept dept,Page page);
	
	public int findCount();
}
