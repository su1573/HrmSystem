package com.su.dao;

import com.su.domain.Employee;
import com.su.util.Page;

public interface EmployeeDao {
	
	public Page findEmployeeBypage(int currentPage,Employee employee);   //��ҳ��ѯ

	public Page findEmployeeByPageName(int currentPage,Employee employee);   //��������ҳ��ѯ
}
