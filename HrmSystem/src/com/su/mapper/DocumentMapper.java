package com.su.mapper;

import com.su.domain.Document;

public interface DocumentMapper {
	
	public void addDocument(Document document);
	
	public void deleteDoc(int documentId);
	
	public Document findDocById(int documentId);
	
	

}
