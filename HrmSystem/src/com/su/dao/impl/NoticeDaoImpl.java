package com.su.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.su.dao.NoticeDao;
import com.su.domain.Notice;
import com.su.util.Page;

public class NoticeDaoImpl extends SqlSessionDaoSupport implements NoticeDao {

	@Override
	public Page findNoticeByPageName(int currentPage, Notice notice) {
		SqlSession sqlSession = this.getSqlSession();
		Page pageIndex = new Page();                //ʵ����Page����
		int countResult = 0;
		if(notice.getNoticeTitle() == null || notice.getNoticeTitle().equals("")){
			countResult = sqlSession.selectOne("notice.findAllCountByName");
		}else if(notice.getNoticeTitle() != null){
			countResult = sqlSession.selectOne("notice.findAllCount",notice);
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
		RowBounds rowBounds = new RowBounds(pageIndex.getFirstResult(), pageIndex.PAGESIZE); // offset��ʼ�� // limit�ǵ�ǰҳ��ʾ����������
		if(notice.getNoticeTitle() == null || notice.getNoticeTitle().equals("")){
			deptList = sqlSession.selectList("notice.findNoticeByPage", notice, rowBounds);
			
		}else if(notice.getNoticeTitle() != null){
			
			deptList = sqlSession.selectList("notice.findNoticeByPageName", notice, rowBounds);	
		}

		pageIndex.setList(deptList);
		System.out.println("���ݳ��ȣ�"+deptList.size());
		return pageIndex;
	}

}
