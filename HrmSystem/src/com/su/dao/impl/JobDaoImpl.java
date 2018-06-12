package com.su.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.su.dao.JobDao;
import com.su.domain.Job;
import com.su.util.Page;

public class JobDaoImpl extends SqlSessionDaoSupport implements JobDao {

	@Override
	public Page findJobByPage(int currentPage, Job job) {
		SqlSession sqlSession = this.getSqlSession();
		Page pageIndex = new Page();                //ʵ����Page����
		int count = sqlSession.selectOne("job.findCount",job);   //��ѯjob���������������߷�����������������
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

		List deptList = sqlSession.selectList("job.findJobByPage", job, rowBounds);
		pageIndex.setList(deptList);
		System.out.println("���ݳ��ȣ�"+deptList.size());
		
		return pageIndex;
	}

}
