package com.su.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.DeptDao;
import com.su.domain.Dept;
import com.su.mapper.DeptMapper;
import com.su.service.DeptService;
import com.su.util.Page;

public class DeptServiceImpl  implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private DeptDao deptDao;
	
	
	@Override
	public List<Dept> findAllDept() {
		System.out.println("in DeptServiceImpl method findAllDept()");
		return deptMapper.findAllDept();	
	}


	@Override
	public List<Dept> findDeptByName(String deptName) {
		
		return deptMapper.findDeptByName(deptName);
	}


	@Override
	public void deleteDept(Integer deptId) {
		deptMapper.deleteDept(deptId);
		
	}


	@Override
	public Dept findDeptById(Integer deptId) {
		
		return deptMapper.findDeptById(deptId);
	}


	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
		
	}


	@Override
	public void addDept(Dept dept) {
		deptMapper.addDept(dept);
	}


	@Override
	public int findCount() {
		
		return deptMapper.findCount();
	}


	@Override
	public Page findDeptByPage(Dept dept, int currentPage) {
		return deptDao.findDeptByPage(dept, currentPage);
	}
	
	
	

}
