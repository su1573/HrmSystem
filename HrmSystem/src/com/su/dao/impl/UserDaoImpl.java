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
		System.out.println("******总记录数："+count);
		page.setTatalNums(count);   //总记录数
		int totalPages = (page.getTatalNums() % page.PAGESIZE) == 0?
				page.getTatalNums() / page.PAGESIZE : (page.getTatalNums() / page.PAGESIZE)+1;
		System.out.println("******总页数："+totalPages);
		page.setTotalPages(totalPages);  //总页数
		if(currentPage < 1 || currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("******当前页："+currentPage);
		page.setCurrentPage(currentPage);  //当前页
		int firstResult = (currentPage-1) * page.PAGESIZE;
		page.setFirstResult(firstResult);
		RowBounds rowBounds = new RowBounds(page.getFirstResult(), page.PAGESIZE); // offset起始行 // limit是当前页显示多少条数据
		
		List list = sqlSession.selectList("user.findUserByPage", user,rowBounds);
		
		page.setList(list);	
		
		return page;
	}
	
	@Override
	public Page findUserByPageName(int currentPage, User user) {
		Page page = new Page();
		SqlSession sqlSession = this.getSqlSession();    //得到session
		int count = sqlSession.selectOne("user.findNameCount",user);    //根据条件查询记录数
		System.out.println("******总记录数："+count);
		page.setTatalNums(count);   	//总记录数
		int totalPages = (page.getTatalNums() % page.PAGESIZE) == 0?
				page.getTatalNums() / page.PAGESIZE : (page.getTatalNums() / page.PAGESIZE)+1;
		System.out.println("******总页数："+totalPages);
		page.setTotalPages(totalPages);  	//总页数
		if(currentPage < 1 || currentPage == 0){
			currentPage = 1;
		}else if(currentPage > totalPages){
			currentPage = totalPages;
		}
		System.out.println("******当前页："+currentPage);
		page.setCurrentPage(currentPage);  	//当前页
		int firstResult = (currentPage-1) * page.PAGESIZE;  //起始行
		page.setFirstResult(firstResult);   
		
		// RowBounds(offset,limit)   offset起始行 ，limit是当前页显示多少条数据
		RowBounds rowBounds = new RowBounds(page.getFirstResult(), page.PAGESIZE); 
		
		//查询记录
		List list = sqlSession.selectList("user.findUserByPageName", user,rowBounds);
		
		page.setList(list);
		
		return page;
	}
	
	
	
	
	
	

}
