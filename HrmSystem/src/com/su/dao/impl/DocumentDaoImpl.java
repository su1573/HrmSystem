package com.su.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.su.dao.DocumentDao;
import com.su.domain.Document;
import com.su.util.Page;

public class DocumentDaoImpl extends SqlSessionDaoSupport implements DocumentDao {

	@Override
	public Page findDocByPageName(int currentPage, Document document) {
		SqlSession sqlSession = this.getSqlSession();
		Page pageIndex = new Page();                //ʵ����Page����
		int countResult = 0;
		if(document.getDocumentTitle() == null || document.getDocumentTitle().equals("")){
			countResult = sqlSession.selectOne("document.findAllDoc");
		}else if(document.getDocumentTitle() != null){
			countResult = sqlSession.selectOne("document.findAllDocByName",document);
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
		
		RowBounds rowBounds = new RowBounds(pageIndex.getFirstResult(), pageIndex.PAGESIZE); // offset��ʼ�� // limit�ǵ�ǰҳ��ʾ����������
//		if(document.getDocumentTitle() == null || document.getDocumentTitle().equals("")){
//			deptList = sqlSession.selectList("document.findNoticeByPage", document, rowBounds);
//			
//		}else if(document.getDocumentTitle() != null){
//					
//		}
		List deptList = sqlSession.selectList("document.findDocByPageName", document, rowBounds);
		pageIndex.setList(deptList);
		System.out.println("���ݳ��ȣ�"+deptList.size());
		return pageIndex;
	}

}
