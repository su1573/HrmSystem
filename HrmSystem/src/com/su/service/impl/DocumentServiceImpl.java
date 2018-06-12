package com.su.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.DocumentDao;
import com.su.domain.Document;
import com.su.mapper.DocumentMapper;
import com.su.service.DocumentService;
import com.su.util.Page;

public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentMapper documentMapper;
	
	@Autowired
	private DocumentDao documentDao;
	
	@Override
	public void addDocument(Document document) {
		document.setDocumentCreateDate(new Date());
		
		documentMapper.addDocument(document);

	}

	@Override
	public Page findDocByPageName(int currentPage, Document document) {
		
		return documentDao.findDocByPageName(currentPage, document);
	}

	@Override
	public void deleteDoc(int documentId) {
		documentMapper.deleteDoc(documentId);
		
	}

	@Override
	public Document findDocById(int documentId) {
		
		return documentMapper.findDocById(documentId);
	}

	
	
	

}
