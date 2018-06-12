package com.su.dao;

import com.su.domain.Job;
import com.su.util.Page;

public interface JobDao {
	
	public Page findJobByPage(int currentPage,Job job);   //∑÷“≥≤È—Ø

}
