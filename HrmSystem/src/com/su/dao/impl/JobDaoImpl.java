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
		Page pageIndex = new Page();                //实例化Page对象
		int count = sqlSession.selectOne("job.findCount",job);   //查询job中数据总数，或者符合条件的数据总数
		System.out.println("******总记录数："+count);
		pageIndex.setTatalNums(count);           
		int totalPages = (pageIndex.getTatalNums() % pageIndex.PAGESIZE) == 0?
				pageIndex.getTatalNums() / pageIndex.PAGESIZE : (pageIndex.getTatalNums() / pageIndex.PAGESIZE)+1;
		pageIndex.setTotalPages(totalPages);  //总页数
		System.out.println("******总页数："+totalPages);
		
		if(currentPage < 1 ||currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("当前页："+currentPage);
		pageIndex.setCurrentPage(currentPage);
		int firstResult = (currentPage - 1) * pageIndex.PAGESIZE;
		System.out.println("起始行："+firstResult);
		pageIndex.setFirstResult(firstResult);
		RowBounds rowBounds = new RowBounds(pageIndex.getFirstResult(), pageIndex.PAGESIZE); // offset起始行 // limit是当前页显示多少条数据

		List deptList = sqlSession.selectList("job.findJobByPage", job, rowBounds);
		pageIndex.setList(deptList);
		System.out.println("数据长度："+deptList.size());
		
		return pageIndex;
	}

}
