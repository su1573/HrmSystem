package com.su.service;

import java.util.List;

import com.su.domain.Student;

public interface StudentService {
public List<Student> findAllStudent();
	
	public Student findStudentById(Integer stuId);

}
