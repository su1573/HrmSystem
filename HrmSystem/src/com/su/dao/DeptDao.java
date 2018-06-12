package com.su.dao;

import com.su.domain.Dept;
import com.su.util.Page;

public interface DeptDao {
	
	public Page findDeptByPage(Dept dept, int currentPage);  //∑÷“≥≤È—Ø

}
