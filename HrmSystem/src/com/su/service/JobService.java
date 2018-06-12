package com.su.service;

import java.util.List;

import com.su.domain.Job;
import com.su.util.Page;

public interface JobService {
	
	public Page findJobByPage(int currentPage,Job job);   //分页查询
	
	public void addJob(Job job);	//新增职位
	
	public Job findJobById(Integer jobId);   //根据id查找Job
	
	public void updateJob(Job job);   //更新Job
	
	public void deleteJobById(Integer jobId);   //根据id 删除Job
	
	public List<Job> findAllJob();  //查询全部

}
