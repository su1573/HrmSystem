package com.su.dao;

import com.su.domain.Notice;
import com.su.util.Page;

public interface NoticeDao {
	
	public Page findNoticeByPageName(int currentPage,Notice notice);

}
