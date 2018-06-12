package com.su.service;

import com.su.domain.Notice;
import com.su.util.Page;

public interface NoticeService {

	public Page findNoticeByPageName(int currentPage,Notice notice);  //分页查询
	
	public Notice findNoticeById(int noticeId);   //根据id查找notice
	
	public void addNotice(Notice notice);   //新增公告
	
	public void deleteNotice(int noticeId);   //删除公告
	
	public void updateNotice(Notice notice);   //更新公告
}
