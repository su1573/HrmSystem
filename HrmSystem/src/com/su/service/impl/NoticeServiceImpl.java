package com.su.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.NoticeDao;
import com.su.domain.Notice;
import com.su.mapper.NoticeMapper;
import com.su.service.NoticeService;
import com.su.util.Page;

public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public Page findNoticeByPageName(int currentPage, Notice notice) {
		
		return noticeDao.findNoticeByPageName(currentPage, notice);
	}

	@Override
	public Notice findNoticeById(int noticeId) {
		
		return noticeMapper.findNoticeById(noticeId);
	}

	@Override
	public void addNotice(Notice notice) {
		notice.setNoticeCreateDate(new Date());
		noticeMapper.addNotice(notice);
		
	}

	@Override
	public void deleteNotice(int noticeId) {
		
		noticeMapper.deleteNotice(noticeId);
	}

	@Override
	public void updateNotice(Notice notice) {
		notice.setNoticeCreateDate(new Date());
		noticeMapper.updateNotice(notice);
	}

}
