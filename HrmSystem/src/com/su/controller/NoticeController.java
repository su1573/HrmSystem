package com.su.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.su.domain.Notice;
import com.su.service.NoticeService;
import com.su.util.Page;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("findNoticeByPageName.action")
	public ModelAndView findNoticeByPageName(int currentPage,Notice notice,ModelAndView mav,HttpServletRequest request){
		System.out.println("in NoticeController method findNoticeByPageName()");
		if(notice.getNoticeTitle() != null){
			System.out.println("检索的公告标题："+notice.getNoticeTitle());
			request.setAttribute("notice", notice);
		}
		
		Page page = noticeService.findNoticeByPageName(currentPage, notice);
		request.setAttribute("page", page);
		mav.setViewName("jsp/notice/noticeList.jsp");
		
		return mav;
	}
	
	@RequestMapping("previewNotice.action")
	public ModelAndView previewNotice(int noticeId,ModelAndView mav){
		System.out.println("in NoticeController method previewNotice()");
		Notice notice = noticeService.findNoticeById(noticeId);
		mav.addObject("notice",notice);
		mav.setViewName("jsp/notice/previewNotice.jsp");
		
		return mav;
	}
	
	@RequestMapping("addNotice.action")
	public ModelAndView addNotice(String flag,Notice notice,ModelAndView mav){
		System.out.println("in NoticeController method addNotice()");
		if(flag.equals("1")){
			mav.setViewName("jsp/notice/showAddNotice.jsp");
		}else{
			noticeService.addNotice(notice);
			mav.setViewName("redirect:findNoticeByPageName.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("removeNotice.action")
	public ModelAndView removeNotice(String ids,Notice notice,ModelAndView mav){
		System.out.println("in NoticeController method removeNotice()");
		String[] idArray = ids.split(",");
		for(String id : idArray){
			 noticeService.deleteNotice(Integer.parseInt(id));
		}
		mav.setViewName("redirect:findNoticeByPageName.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("updateNotice.action")
	public ModelAndView updateNotice(String flag,Notice notice,ModelAndView mav){
		System.out.println("in NoticeController method updateNotice()");
		if(flag.equals("1")){
			Notice no = noticeService.findNoticeById(notice.getNoticeId());
			mav.addObject("notice", no);
			mav.setViewName("jsp/notice/showUpdateNotice.jsp");
		}else{
			noticeService.updateNotice(notice);
			mav.setViewName("redirect:findNoticeByPageName.action?currentPage=1");
		}
		return mav;
	}

}
