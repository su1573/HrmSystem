package com.su.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.EmployeeDao;
import com.su.domain.Employee;
import com.su.mapper.EmployeeMapper;
import com.su.service.EmployeeService;
import com.su.util.Page;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public List<Employee> findEmployeeWithJobExtendDept() {
		
		return employeeMapper.findEmployeeWithJobExtendDept();
	}


	@Override
	public Page findEmployeeBypage(int currentPage, Employee employee) {
		
		return employeeDao.findEmployeeBypage(currentPage, employee);
	}


	@Override
	public Page findEmployeeByPageName(int currentPage, Employee employee) {
		
		return employeeDao.findEmployeeByPageName(currentPage, employee);
	}


	@Override
	public void deleteEmployeeById(Integer employeeId) {
		employeeMapper.deleteEmployeeById(employeeId);
		
	}


	@Override
	public Employee findEmployeeById(Integer employeeId) {
		
		return employeeMapper.findEmployeeById(employeeId);
	}


	@Override
	public void updateEmployee(Employee employee) {
		
		employeeMapper.updateEmployee(employee);
	}


	@Override
	public void addEmployee(Employee employee) {
		employee.setEmployeeCreateDate(new Date());
		employeeMapper.addEmployee(employee);
	}

}
