package com.su.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.su.domain.Dept;
import com.su.domain.Employee;
import com.su.domain.Job;
import com.su.service.DeptService;
import com.su.service.EmployeeService;
import com.su.service.JobService;
import com.su.util.Page;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private DeptService deptService;
	
	
	@RequestMapping("findAllEmployee.action")
	public void findAllEmployee(String Id,ModelAndView mav,HttpServletResponse response) throws ServletException,IOException{
		System.out.println("in EmployeeController method findAllEmployee()");
		PrintWriter pw = response.getWriter();
		List<Employee> employeeList = employeeService.findEmployeeWithJobExtendDept();
		boolean isExits = false;
		for(Employee em : employeeList){
			if(Id.equals(em.getEmployeeCardId())){
				isExits = true;
			}else if(Id.equals(em.getEmployeePhone())){
				isExits = true;
			}
		}
		pw.print(isExits);
		pw.flush();
		pw.close();
		
		
//		List<Dept> deptList = deptService.findAllDept();
//		List<Job> jobList = jobService.findAllJob();
//		request.setAttribute("employeeList", employeeList);
//		request.setAttribute("deptList", deptList);
//		request.setAttribute("jobList", jobList);
//		mav.setViewName("jsp/employee/employeeList.jsp");	
	}
	
	@RequestMapping("findEmployeeByPage.action")
	public ModelAndView findEmployeeByPage(int currentPage,Employee employee,ModelAndView mav,HttpServletRequest request){
		System.out.println("in EmployeeController method findEmployeeByPage()");
		if(employee.getEmployeeName() != null){
			System.out.println("检索的员工姓名："+employee.getEmployeeName());
		}
		Page page = employeeService.findEmployeeBypage(currentPage, employee);
		List<Dept> deptList = deptService.findAllDept();
		List<Job> jobList = jobService.findAllJob();
		request.setAttribute("page", page);
		request.setAttribute("deptList", deptList);
		request.setAttribute("jobList", jobList);
		mav.setViewName("jsp/employee/employeeList.jsp");
		return mav;
	}
	
	@RequestMapping("findEmployeeByPageName.action")
	public ModelAndView findEmployeeByPageName(int currentPage,Employee employee,ModelAndView mav,HttpServletRequest request){
		System.out.println("in EmployeeController method findEmployeeByPageName()");
		if(employee.getEmployeeName() != null){
			System.out.println("检索的员工姓名："+employee.getEmployeeName());
		}
		request.setAttribute("empBack", employee);
		Page page = employeeService.findEmployeeByPageName(currentPage, employee);
		List<Dept> deptList = deptService.findAllDept();
		List<Job> jobList = jobService.findAllJob();
		request.setAttribute("page", page);
		request.setAttribute("deptList", deptList);
		request.setAttribute("jobList", jobList);
		mav.setViewName("jsp/employee/employeeList.jsp");
		return mav;
	}
	
	@RequestMapping("removeEmployee.action")
	public ModelAndView removeEmployee(String ids,ModelAndView mav){
		System.out.println("in EmployeeController method removeEmployee()");
		String[] idArray = ids.split(",");
		for(String id : idArray){
			System.out.println("删除的员工id:"+id);
			employeeService.deleteEmployeeById(Integer.parseInt(id));	
		}
		mav.setViewName("redirect:findEmployeeByPage.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("updateEmployee.action")
	public ModelAndView updateEmployee(String flag,Employee employee,ModelAndView mav,HttpServletRequest request){
		System.out.println("in EmployeeController method updateJob()");
		
		if(flag.equals("1")){
			System.out.println("需要修改的id:"+employee.getEmployeeId());
			Employee employeeTwo = employeeService.findEmployeeById(employee.getEmployeeId());
			List<Dept> deptList = deptService.findAllDept();
			List<Job> jobList = jobService.findAllJob();
			mav.addObject("employee", employeeTwo);
			request.setAttribute("deptList", deptList);
			request.setAttribute("jobList", jobList);
			mav.setViewName("jsp/employee/showUpdateEmployee.jsp");
		}else{
			System.out.println("修改的部门id，职位id："+employee.getDeptId()+","+employee.getJobId());
			employeeService.updateEmployee(employee);
			mav.setViewName("redirect:findEmployeeByPage.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("addEmployee.action")
	public ModelAndView addEmployee(String flag,Employee employee,ModelAndView mav,HttpServletRequest request){
		System.out.println("in EmployeeController method addEmployee()");
		if(flag.equals("1")){
			List<Dept> deptList = deptService.findAllDept();
			List<Job> jobList = jobService.findAllJob();
			request.setAttribute("deptList", deptList);
			request.setAttribute("jobList", jobList);
			mav.setViewName("jsp/employee/showAddEmployee.jsp");
		}else{
			employeeService.addEmployee(employee);
			mav.setViewName("redirect:findEmployeeByPage.action?currentPage=1");
		}
		return mav;
	}
	
}
