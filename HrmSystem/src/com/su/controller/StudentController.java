package com.su.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.su.domain.Student;
import com.su.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("findAllStudent.action")
	public String findAllStudents(HttpServletRequest request) throws Exception{
		System.out.println("in StudentController method findAllStudents()");
		List<Student> list = studentService.findAllStudent();
		request.setAttribute("list", list);
		return "successOne.jsp";
	}
	
	@RequestMapping("findStudentById.action")
	public String findStudentById(Integer stuId,HttpServletRequest request) throws Exception{
		System.out.println("in StudentController method findStudentById()");
		Student stu = studentService.findStudentById(stuId);
		request.setAttribute("stu", stu);
		return "successTwo.jsp";
		
	}
}
