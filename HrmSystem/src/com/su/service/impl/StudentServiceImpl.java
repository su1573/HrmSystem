package com.su.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.StudentDao;
import com.su.domain.Student;
import com.su.mapper.StudentMapper;
import com.su.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private StudentMapper studentMapper;
	
	
	@Override
	public List<Student> findAllStudent() {
		
		return studentDao.findAllStudent();
	}

	@Override
	public Student findStudentById(Integer stuId) {
		
		return studentMapper.findStudentById(stuId);
	}

}
