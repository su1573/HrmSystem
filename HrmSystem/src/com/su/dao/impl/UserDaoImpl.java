package com.su.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.su.dao.UserDao;
import com.su.domain.User;
import com.su.util.Page;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User checkUserLogin(User user) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("user.checkUserLogin",user);
	}

	@Override
	public Integer Count(Map<String,Object> params) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("user.findUserToCount");
	}

	@Override
	public List<User> selectByPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("user.findAllUser");
	}

	@Override
	public void addUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		user.setUserCreateDate(new Date());
		sqlSession.insert("user.addUser",user);
		
	}

	@Override
	public void deleteUser(Integer userId) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("user.deleteUser", userId);
	}

	@Override
	public List<User> findUserByName(String userName) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("user.findUserByName",userName);
	}

	@Override
	public User findUserById(Integer userId) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("user.findUserById",userId);
	}

	@Override
	public void updateUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		user.setUserCreateDate(new Date());
		sqlSession.update("user.updateUser", user);
	}

	@Override
	public Page findUserByPage(int currentPage, User user) {
		Page page = new Page();
		SqlSession sqlSession = this.getSqlSession();
		int count = sqlSession.selectOne("user.findUserToCount");
		System.out.println("******�ܼ�¼����"+count);
		page.setTatalNums(count);   //�ܼ�¼��
		int totalPages = (page.getTatalNums() % page.PAGESIZE) == 0?
				page.getTatalNums() / page.PAGESIZE : (page.getTatalNums() / page.PAGESIZE)+1;
		System.out.println("******��ҳ����"+totalPages);
		page.setTotalPages(totalPages);  //��ҳ��
		if(currentPage < 1 || currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("******��ǰҳ��"+currentPage);
		page.setCurrentPage(currentPage);  //��ǰҳ
		int firstResult = (currentPage-1) * page.PAGESIZE;
		page.setFirstResult(firstResult);
		RowBounds rowBounds = new RowBounds(page.getFirstResult(), page.PAGESIZE); // offset��ʼ�� // limit�ǵ�ǰҳ��ʾ����������
		
		List list = sqlSession.selectList("user.findUserByPage", user,rowBounds);
		
		page.setList(list);	
		
		return page;
	}
	
	@Override
	public Page findUserByPageName(int currentPage, User user) {
		Page page = new Page();
		SqlSession sqlSession = this.getSqlSession();    //�õ�session
		int count = sqlSession.selectOne("user.findNameCount",user);    //����������ѯ��¼��
		System.out.println("******�ܼ�¼����"+count);
		page.setTatalNums(count);   	//�ܼ�¼��
		int totalPages = (page.getTatalNums() % page.PAGESIZE) == 0?
				page.getTatalNums() / page.PAGESIZE : (page.getTatalNums() / page.PAGESIZE)+1;
		System.out.println("******��ҳ����"+totalPages);
		page.setTotalPages(totalPages);  	//��ҳ��
		if(currentPage < 1 || currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("******��ǰҳ��"+currentPage);
		page.setCurrentPage(currentPage);  	//��ǰҳ
		int firstResult = (currentPage-1) * page.PAGESIZE;  //��ʼ��
		page.setFirstResult(firstResult);   
		
		// RowBounds(offset,limit)   offset��ʼ�� ��limit�ǵ�ǰҳ��ʾ����������
		RowBounds rowBounds = new RowBounds(page.getFirstResult(), page.PAGESIZE); 
		
		//��ѯ��¼
		List list = sqlSession.selectList("user.findUserByPageName", user,rowBounds);
		
		page.setList(list);
		
		return page;
	}
	
	
	
	
	
	

}
