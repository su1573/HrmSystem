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
import com.su.service.DeptService;
import com.su.util.Page;
@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("findAllDept.action")
	public void findAllDept(String deptName,HttpServletResponse response) throws ServletException,IOException{
		System.out.println("in DeptController method findAllDept()");
		PrintWriter pw = response.getWriter();
		List<Dept> list = deptService.findAllDept();
		boolean isExits = false;
		for(Dept dept : list){
			if(deptName.equals(dept.getDeptName())){
				isExits = true;
			}
		}
		pw.print(isExits);
		pw.flush();
		pw.close();
		
		
//		request.setAttribute("deptList", list);
//		System.out.println("******");
//		return "jsp/dept/deptList.jsp";
	}
	
	@RequestMapping("findDeptByName.action")
	public ModelAndView findDeptByName(String deptName,ModelAndView mav,HttpServletRequest request){
		System.out.println("in DeptController method findDeptByName()");
		List<Dept> list = deptService.findDeptByName(deptName);
		request.setAttribute("deptList", list);
		System.out.println("******");
		mav.setViewName("jsp/dept/deptList.jsp"); 
		return mav;
	}
	
	@RequestMapping("removeDept.action")
	public ModelAndView deleteDept(String ids,ModelAndView mav){
		System.out.println("in DeptController method deleteDept()");
		String[] idArray = ids.split(",");
		for(String num : idArray){
			System.out.println("删除的部门id:"+num);
			deptService.deleteDept(Integer.parseInt(num));
		}
		mav.setViewName("redirect:findDeptByPage.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("updateDept.action")
	public ModelAndView updateDept(String flag,Dept dept,ModelAndView mav){
		System.out.println("in DeptController method updateDept()");
		if(flag.equals("1")){
			Dept dd = deptService.findDeptById(dept.getDeptId());
			// 设置Model数据
			mav.addObject("dept", dd);
			// 返回修改员工页面
			mav.setViewName("jsp/dept/showUpdateDept.jsp");
		}else{
			deptService.updateDept(dept);
			mav.setViewName("redirect:findDeptByPage.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("addDept.action")
	public ModelAndView addDept(Dept dept,ModelAndView mav){
		System.out.println("in DeptController method addDept()");
		
		deptService.addDept(dept);
		mav.setViewName("redirect:findDeptByPage.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("findDeptByPage.action")
	public ModelAndView findDeptByPage(Dept dept,int currentPage,ModelAndView mav,HttpServletRequest request){
		System.out.println("in DeptController method findDeptByPage()");
		System.out.println("in findDeptByPage() 当前页："+currentPage);
		
		if(dept.getDeptName() !=null){
			System.out.println("检索的部门名称："+dept.getDeptName());
		}
		request.setAttribute("name", dept.getDeptName());
		Page page = deptService.findDeptByPage(dept, currentPage);
		
		request.setAttribute("page", page);
		mav.setViewName("jsp/dept/deptList.jsp");
		
		return mav;
	}
	
	
	
	
}
