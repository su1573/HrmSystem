package com.su.mapper;

import java.util.List;

import com.su.domain.Student;

public interface StudentMapper {

	public List<Student> findAllStudent();
	
	public Student findStudentById(Integer stuId);
}
