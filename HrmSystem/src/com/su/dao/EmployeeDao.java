package com.su.dao;

import com.su.domain.Employee;
import com.su.util.Page;

public interface EmployeeDao {
	
	public Page findEmployeeBypage(int currentPage,Employee employee);   //分页查询

	public Page findEmployeeByPageName(int currentPage,Employee employee);   //按条件分页查询
}
