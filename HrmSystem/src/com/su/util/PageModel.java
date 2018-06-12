package com.su.util;

import java.util.List;

public class PageModel {
	//总记录数
	private Integer recordCount;
	//当前页面
	private Integer pageIndex;
	//每页数据条数
	private Integer pageSize = 4;
	//总页数
	private Integer totalPage;
	
	private List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getRecordCount() {
		this.recordCount = this.recordCount <= 0 ? 0:this.recordCount;
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public Integer getPageIndex() {
		this.pageIndex = this.pageIndex <= 0?1:this.pageIndex;
		/** 判断当前页面是否超过了总页数:如果超过了默认给最后一页作为当前页  */
		this.pageIndex = this.pageIndex>=this.getTotalPage()?this.getTotalPage():this.pageIndex;
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		this.pageSize = this.pageSize <= 4 ? 4 : this.pageSize;
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		if(this.getRecordCount() <= 0){
			totalPage = 0;
		}else{
			totalPage = (this.getRecordCount() -1)/this.getPageSize() + 1;
		}
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getFirstLimitParam(){
		return (this.getPageIndex()-1)*this.getPageSize() ;
	}
	
}
