package com.su.service;

import com.su.domain.Document;
import com.su.util.Page;

public interface DocumentService {
	public void addDocument(Document document);   //新增文件
	
	public Page findDocByPageName(int currentPage, Document document);  //分页查询
	
	public void deleteDoc(int documentId);  //删除文件
	
	public Document findDocById(int documentId);  //根据Id查找文件
	

}
