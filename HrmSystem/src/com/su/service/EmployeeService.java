package com.su.service;

import java.util.List;

import com.su.domain.Employee;
import com.su.util.Page;

public interface EmployeeService {
	
	public List<Employee> findEmployeeWithJobExtendDept();   //查询全部
	
	public Page findEmployeeBypage(int currentPage,Employee employee);   //分页查询
	
	public Page findEmployeeByPageName(int currentPage,Employee employee);   //按条件分页查询
	
	public void deleteEmployeeById(Integer employeeId);    //根据id 删除员工
	
	public Employee findEmployeeById(Integer employeeId);  //根据id查找员工
	
	public void updateEmployee(Employee employee);     //更新员工
	
	public void addEmployee(Employee employee);      //新增员工

}
