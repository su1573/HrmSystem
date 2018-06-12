package com.su.mapper;

import java.util.List;

import com.su.domain.Job;

public interface JobMapper {
	
	public void addJob(Job job);
	
	public Job findJobById(Integer jobId);
	
	public void updateJob(Job job);
	
	public void deleteJobById(Integer jobId);
	
	public List<Job> findAllJob();

}
