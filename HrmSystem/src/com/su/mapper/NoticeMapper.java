package com.su.mapper;

import com.su.domain.Notice;

public interface NoticeMapper {
	
	public Notice findNoticeById(int noticeId);
	
	public void addNotice(Notice notice);
	
	public void deleteNotice(int noticeId);
	
	public void updateNotice(Notice notice);

}
