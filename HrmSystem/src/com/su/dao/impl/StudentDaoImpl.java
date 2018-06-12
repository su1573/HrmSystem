package com.su.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.su.dao.StudentDao;
import com.su.domain.Student;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {

	@Override
	public List<Student> findAllStudent() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("student.findAllStudent");
	}

	@Override
	public Student findStudentById(Integer stuId) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("student.findAllStudent",stuId);
	}

}
