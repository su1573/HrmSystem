package com.su.dao;

import java.util.List;

import com.su.domain.Student;

public interface StudentDao {
	
	public List<Student> findAllStudent();
	
	public Student findStudentById(Integer stuId);

}
