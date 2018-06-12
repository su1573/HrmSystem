package com.su.dao;

import com.su.domain.Document;
import com.su.util.Page;

public interface DocumentDao {
	
	public Page findDocByPageName(int currentPage,Document doc);

}
