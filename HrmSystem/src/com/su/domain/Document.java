package com.su.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Document {
	
	private Integer documentId;   //文件id
	private String documentTitle; //文件标题
	private String fileName;      //文件名
	private MultipartFile file;   //文件
	
	private String documentDesc;   //文件描述
	private Date documentCreateDate;   //创建时间
	
	private Integer userId;    //用户id
	private User user;
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getDocumentDesc() {
		return documentDesc;
	}
	public void setDocumentDesc(String documentDesc) {
		this.documentDesc = documentDesc;
	}
	public Date getDocumentCreateDate() {
		return documentCreateDate;
	}
	public void setDocumentCreateDate(Date documentCreateDate) {
		this.documentCreateDate = documentCreateDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
