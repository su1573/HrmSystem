package com.su.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.su.dao.EmployeeDao;
import com.su.domain.Employee;
import com.su.util.Page;

public class EmployeeDaoImpl extends SqlSessionDaoSupport implements EmployeeDao {

	@Override
	public Page findEmployeeBypage(int currentPage, Employee employee) {
		SqlSession sqlSession = this.getSqlSession();
		Page pageIndex = new Page();                //ʵ����Page����
		int count = sqlSession.selectOne("employee.findAllCount");   //��ѯjob���������������߷�����������������
		System.out.println("******�ܼ�¼����"+count);
		pageIndex.setTatalNums(count);           
		int totalPages = (pageIndex.getTatalNums() % pageIndex.PAGESIZE) == 0?
				pageIndex.getTatalNums() / pageIndex.PAGESIZE : (pageIndex.getTatalNums() / pageIndex.PAGESIZE)+1;
		pageIndex.setTotalPages(totalPages);  //��ҳ��
		System.out.println("******��ҳ����"+totalPages);
		
		if(currentPage < 1 ||currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("��ǰҳ��"+currentPage);
		pageIndex.setCurrentPage(currentPage);
		int firstResult = (currentPage - 1) * pageIndex.PAGESIZE;
		System.out.println("��ʼ�У�"+firstResult);
		pageIndex.setFirstResult(firstResult);
		RowBounds rowBounds = new RowBounds(pageIndex.getFirstResult(), pageIndex.PAGESIZE); // offset��ʼ�� // limit�ǵ�ǰҳ��ʾ����������

		List deptList = sqlSession.selectList("employee.findEmployeeByPage", employee, rowBounds);
		pageIndex.setList(deptList);
		System.out.println("���ݳ��ȣ�"+deptList.size());
		return pageIndex;
	}

	@Override
	public Page findEmployeeByPageName(int currentPage, Employee employee) {
		SqlSession sqlSession = this.getSqlSession();
		Page pageIndex = new Page();                //ʵ����Page����
		int countResult = 0;
		if(employee.getEmployeeName() == null || employee.getEmployeeName().equals("")){
			//��ѯemployee���������������߷�����������������
			countResult = sqlSession.selectOne("employee.findAllCount");   
		}else if(employee.getEmployeeName() != null){
			//��ѯemployee���������������߷�����������������
			countResult = sqlSession.selectOne("employee.findCount",employee);   
		}
		
		System.out.println("******�ܼ�¼����"+countResult);
		pageIndex.setTatalNums(countResult);           
		int totalPages = (pageIndex.getTatalNums() % pageIndex.PAGESIZE) == 0?
				pageIndex.getTatalNums() / pageIndex.PAGESIZE : (pageIndex.getTatalNums() / pageIndex.PAGESIZE)+1;
		pageIndex.setTotalPages(totalPages);  //��ҳ��
		System.out.println("******��ҳ����"+totalPages);
		
		if(currentPage < 1 ||currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("��ǰҳ��"+currentPage);
		pageIndex.setCurrentPage(currentPage);
		int firstResult = (currentPage - 1) * pageIndex.PAGESIZE;
		System.out.println("��ʼ�У�"+firstResult);
		pageIndex.setFirstResult(firstResult);
		List deptList = null;
		// offset��ʼ�� // limit�ǵ�ǰҳ��ʾ����������
		RowBounds rowBounds = new RowBounds(pageIndex.getFirstResult(), pageIndex.PAGESIZE); 
		if(employee.getEmployeeName() == null || employee.getEmployeeName().equals("")){
			deptList = sqlSession.selectList("employee.findEmployeeByPage", employee, rowBounds);
			
		}else if(employee.getEmployeeName() != null){
			
			deptList = sqlSession.selectList("employee.findEmployeeByPageName", employee, rowBounds);	
		}

		pageIndex.setList(deptList);
		System.out.println("���ݳ��ȣ�"+deptList.size());
		return pageIndex;
	}

}
