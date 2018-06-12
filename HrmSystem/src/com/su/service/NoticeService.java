package com.su.service;

import com.su.domain.Notice;
import com.su.util.Page;

public interface NoticeService {

	public Page findNoticeByPageName(int currentPage,Notice notice);  //��ҳ��ѯ
	
	public Notice findNoticeById(int noticeId);   //����id����notice
	
	public void addNotice(Notice notice);   //��������
	
	public void deleteNotice(int noticeId);   //ɾ������
	
	public void updateNotice(Notice notice);   //���¹���
}
