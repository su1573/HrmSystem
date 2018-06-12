package com.su.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.JobDao;
import com.su.domain.Job;
import com.su.mapper.JobMapper;
import com.su.service.JobService;
import com.su.util.Page;

public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private JobMapper jobMapper;
	
	@Override
	public Page findJobByPage(int currentPage, Job job) {
		
		return jobDao.findJobByPage(currentPage, job);
	}

	@Override
	public void addJob(Job job) {
		jobMapper.addJob(job);
		
	}

	@Override
	public Job findJobById(Integer jobId) {
		
		return jobMapper.findJobById(jobId);
	}

	@Override
	public void deleteJobById(Integer jobId) {
		jobMapper.deleteJobById(jobId);
		
	}

	@Override
	public void updateJob(Job job) {
		jobMapper.updateJob(job);
		
	}

	@Override
	public List<Job> findAllJob() {
		
		return jobMapper.findAllJob();
	}
	

}
