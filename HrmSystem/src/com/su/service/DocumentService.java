package com.su.service;

import com.su.domain.Document;
import com.su.util.Page;

public interface DocumentService {
	public void addDocument(Document document);   //�����ļ�
	
	public Page findDocByPageName(int currentPage, Document document);  //��ҳ��ѯ
	
	public void deleteDoc(int documentId);  //ɾ���ļ�
	
	public Document findDocById(int documentId);  //����Id�����ļ�
	

}
