package com.su.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.su.domain.User;
import com.su.service.UserService;
import com.su.util.Page;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("main.action")
	public ModelAndView toLogin(ModelAndView mav){
		System.out.println("in UserController method toLogin()");
		mav.setViewName("forward:jsp/loginForm.jsp");
		
		return mav;
	}
	
	
	@RequestMapping("login.action")
	public ModelAndView checkUserLogin(User user,HttpSession session,ModelAndView mav) throws Exception{
		System.out.println("in UserController method checkUserLogin()");
		System.out.println("登录名："+user.getLoginName());
		User userResult = userService.checkUserLogin(user);
		if(userResult != null){
			session.setAttribute("userSession", userResult);
			mav.setViewName("redirect:jsp/main.jsp");
		}else{
			mav.addObject("message", "登录名或密码错误，请重新输入！");
			mav.setViewName("forward:jsp/loginForm.jsp");
		}
		
		return mav;
	}
	
	@RequestMapping("loginOut.action")
	public ModelAndView LoginOut(HttpSession session,ModelAndView mav)throws Exception{
		System.out.println("in UserController method LoginOut()");
		if(session != null){
			session.invalidate();
		}
		mav.setViewName("forward:index.jsp");
		return mav;
	}
	
	
	@RequestMapping("selectAllUser.action")
	public String selectAllUser(User user,Model model,HttpServletRequest request){
		System.out.println("in UserController method selectAllUser()");
		List<User> list = userService.findAllUser();
		
		request.setAttribute("list", list);
		
		return "jsp/user/userListTwo.jsp";
	}
	
	@RequestMapping("addUser.action")
	public ModelAndView addUser(User user,ModelAndView mav){
		System.out.println("in UserController method addUser()");
		System.out.println(user.getUserName());
		userService.addUser(user);
		mav.setViewName("redirect:findUserByPageName.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("removeUser.action")
	public ModelAndView deleteUser(String ids,ModelAndView mav){
		System.out.println("in UserController method deleteUser()");
		String[] idArray = ids.split(",");  // 分解id字符串
		for(String id : idArray){
			userService.deleteUser(Integer.parseInt(id));
		}
		mav.setViewName("redirect:findUserByPageName.action?currentPage=1");
		return mav;
	}
	
	@RequestMapping("findUserByName.action")
	public ModelAndView findUserByName(String userName,ModelAndView mav,HttpServletRequest request){
		System.out.println("in UserController method findUserByName()");
		List<User> list = userService.findUserByName(userName);
		request.setAttribute("list", list);
		mav.setViewName("jsp/user/userList.jsp"); 
		return mav;
	}
	
	@RequestMapping("updateUser.action")
	public ModelAndView updateUser(User user,String flag,ModelAndView mav){
		System.out.println("in UserController method updateUser1()");
		if(flag.equals("1")){
			System.out.println("in UserController method findUserById()");
			User uu = userService.findUserById(user.getUserId()); // 根据id查询用户
			// 设置Model数据
			mav.addObject("user", uu);
			// 返回修改员工页面
			mav.setViewName("jsp/user/showUpdateUser.jsp");
		}else{
			System.out.println("in UserController method updateUser2()");
			userService.updateUser(user);
			mav.setViewName("redirect:findUserByPageName.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("findUserByPage.action")
	public ModelAndView findUserByPage(Integer currentPage,User user,ModelAndView mav,HttpServletRequest request){
		System.out.println("in UserController method findUserByPage()");
		if(user != null){
			System.out.println("搜索名："+user.getUserName());
		}
		Page page = userService.findUserByPage(currentPage, user);
		System.out.println(page.getCurrentPage());
		request.setAttribute("page", page);
		mav.setViewName("jsp/user/userList.jsp");
		return mav;
	}
	
	@RequestMapping("findUserByPageName.action")
	public ModelAndView findUserByPageName(Integer currentPage,User user,ModelAndView mav,HttpServletRequest request){
		System.out.println("in UserController method findUserByPageName()");
		if(user != null){
			System.out.println("搜索名："+user.getUserName());
		}
		request.setAttribute("name", user.getUserName());   //检索条件，放到request中，在jsp页面回显搜索条件
		Page page = userService.findUserByPageName(currentPage, user);
		System.out.println(page.getCurrentPage());
		request.setAttribute("page", page);
		mav.setViewName("jsp/user/userListTwo.jsp");
		return mav;
	}
	

}
