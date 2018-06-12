package com.su.service;

import java.util.List;

import com.su.domain.Employee;
import com.su.util.Page;

public interface EmployeeService {
	
	public List<Employee> findEmployeeWithJobExtendDept();   //��ѯȫ��
	
	public Page findEmployeeBypage(int currentPage,Employee employee);   //��ҳ��ѯ
	
	public Page findEmployeeByPageName(int currentPage,Employee employee);   //��������ҳ��ѯ
	
	public void deleteEmployeeById(Integer employeeId);    //����id ɾ��Ա��
	
	public Employee findEmployeeById(Integer employeeId);  //����id����Ա��
	
	public void updateEmployee(Employee employee);     //����Ա��
	
	public void addEmployee(Employee employee);      //����Ա��

}
