package com.su.service;

import java.util.List;

import com.su.domain.Job;
import com.su.util.Page;

public interface JobService {
	
	public Page findJobByPage(int currentPage,Job job);   //��ҳ��ѯ
	
	public void addJob(Job job);	//����ְλ
	
	public Job findJobById(Integer jobId);   //����id����Job
	
	public void updateJob(Job job);   //����Job
	
	public void deleteJobById(Integer jobId);   //����id ɾ��Job
	
	public List<Job> findAllJob();  //��ѯȫ��

}
