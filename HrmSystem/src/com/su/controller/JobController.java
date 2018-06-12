package com.su.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.su.domain.Job;
import com.su.service.JobService;
import com.su.util.Page;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping("findAllJob.action")
	public void findAllJob(String jobName,HttpServletResponse response)throws Exception{
		System.out.println("in JobController method findAllJob()");
		PrintWriter pw = response.getWriter();
		List<Job> jobList = jobService.findAllJob();
		boolean isExist = false;
		for(Job job : jobList){
			if(jobName.equals(job.getJobName())){
				isExist = true;
			}
		}
		pw.print(isExist);
		pw.flush();
		pw.close();
		
	}
	
	@RequestMapping("findJobByPage.action")
	public ModelAndView findJobByPage(int currentPage,Job job,ModelAndView mav,HttpServletRequest request){
		System.out.println("in JobController method findJobByPage()");
		System.out.println("当前页："+currentPage);
		request.setAttribute("name", job.getJobName());
		Page page = jobService.findJobByPage(currentPage, job);
		request.setAttribute("page", page);
		
		mav.setViewName("jsp/job/jobList.jsp");

		return mav;
	}
	
	@RequestMapping("addJob.action")
	public ModelAndView addJob(Job job,ModelAndView mav){
		System.out.println("in JobController method addJob()");
		jobService.addJob(job);
		mav.setViewName("redirect:findJobByPage.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("updateJob.action")
	public ModelAndView updateJob(String flag,Job job,ModelAndView mav){
		System.out.println("in JobController method updateJob()");
		
		if(flag.equals("1")){
			System.out.println("需要修改的id:"+job.getJobId());
			Job jobTwo = jobService.findJobById(job.getJobId());
			mav.addObject("job", jobTwo);
			mav.setViewName("jsp/job/showUpdateJob.jsp");
		}else{
			jobService.updateJob(job);
			mav.setViewName("redirect:findJobByPage.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("removeJob.action")
	public ModelAndView removeJob(String ids,ModelAndView mav){
		System.out.println("in JobController method removeJob()");
		String[] idArray = ids.split(",");
		for(String id : idArray){
			System.out.println("删除的职位id:"+id);
			jobService.deleteJobById(Integer.parseInt(id));	
		}
		mav.setViewName("redirect:findJobByPage.action?currentPage=1");
		return mav;
	}

}
