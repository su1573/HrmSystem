package com.su.mapper;

import java.util.List;

import com.su.domain.Employee;

public interface EmployeeMapper {
	
	public List<Employee> findEmployeeWithJobExtendDept();
	
	public void deleteEmployeeById(Integer employeeId);
	
	public Employee findEmployeeById(Integer employeeId);
	
	public void updateEmployee(Employee employee);
	
	public void addEmployee(Employee employee);

}
