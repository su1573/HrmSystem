package com.su.util;

import java.util.List;

public class Page {
	public static final int PAGESIZE = 3;  //ÿҳ��ʾ�ļ�¼��
	private Integer totalPages;     //��ҳ��
	private Integer currentPage;    //��ǰҳ
	private Integer tatalNums;      //�ܼ�¼��
	private List list;             //list����
	private Integer firstResult;   //��ʼλ��
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public static int getPagesize() {
		return PAGESIZE;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTatalNums() {
		return tatalNums;
	}
	public void setTatalNums(Integer tatalNums) {
		this.tatalNums = tatalNums;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
