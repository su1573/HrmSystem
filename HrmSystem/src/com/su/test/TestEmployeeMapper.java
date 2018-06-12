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
			
		
		//加载配置文件
		InputStream is = Resources.getResourceAsStream("mybatisconfig.xml");
		//创建SqlSessionFactory对象
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession ss = ssf.openSession();
		
//		EmployeeMapper em = ss.getMapper(EmployeeMapper.class);
//		
//		List<Employee> list = em.findEmployeeWithJobExtendDept();
//		
//		for(Employee ee : list){
//			System.out.println("姓名："+ee.getEmployeeName()+"\t所属部门："+ee.getDept().getDeptName()+"\t职位："+ee.getJob().getJobName());
//		}
		
		int count = ss.selectOne("notice.findAllCountByName");
		System.out.println(count);
		
		
		
		
		
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
