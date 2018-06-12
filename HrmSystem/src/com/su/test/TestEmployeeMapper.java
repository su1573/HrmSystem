package com.su.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.su.domain.Employee;
import com.su.mapper.EmployeeMapper;

public class TestEmployeeMapper {

	public static void main(String[] args) {
		try{
			
		
		//���������ļ�
		InputStream is = Resources.getResourceAsStream("mybatisconfig.xml");
		//����SqlSessionFactory����
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
		SqlSession ss = ssf.openSession();
		
//		EmployeeMapper em = ss.getMapper(EmployeeMapper.class);
//		
//		List<Employee> list = em.findEmployeeWithJobExtendDept();
//		
//		for(Employee ee : list){
//			System.out.println("������"+ee.getEmployeeName()+"\t�������ţ�"+ee.getDept().getDeptName()+"\tְλ��"+ee.getJob().getJobName());
//		}
		
		int count = ss.selectOne("notice.findAllCountByName");
		System.out.println(count);
		
		
		
		
		
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
