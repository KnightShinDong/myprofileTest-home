package com.sdh.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdh.home.dao.IDao;

@Controller
public class controller {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/")
	public String home() {
		
		return "index";
	}
	@RequestMapping(value = "index")
	public String index() {
		
		return "index";
	}
	@RequestMapping(value = "join")
	public String jon() {
		
		return "join";
	}
	
	@RequestMapping(value = "contact")
	public String contact() {
		
		return "contact";
	}
	@RequestMapping(value = "joinFail")
	public String joinFail() {
		
		return "jionFail";
	}
	
	@RequestMapping(value = "login")
	public String login() {
		
		return "login";
	}
	@RequestMapping(value = "loginOk")
	public String loginOk() {
		
		return "loginOk";
	}
	@RequestMapping(value = "memberModify")
	public String memberModify() {
		
		return "memberModify";
	}
	@RequestMapping(value = "memberModifyOk")
	public String memberModifyOk() {
		
		return "memberModifyOk";
	}
	@RequestMapping(value = "profile")
	public String profile() {
		
		return "profile";
	}
	@RequestMapping(value = "question")
	public String question() {
		
		return "question";
	}
	
	@RequestMapping(value = "qustionList")
	public String qustionList() {
		
		return "qustionList";
	}
	@RequestMapping(value = "qustionModify")
	public String qustionModify() {
		
		return "qustionModify";
	}
	
	@RequestMapping(value = "joinOk")
	public String joinOk(HttpServletRequest request, Model model, HttpSession session) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		int joinFlag = (int) dao.memberJoinDao(mid, mpw, mname, memail);
		if(joinFlag ==  1) {
			session.setAttribute("memberId", mid);
			session.setAttribute("memberName", mname);
			
			model.addAttribute("mid", mid);
			model.addAttribute("mname", mname);
			return "joinOk";	
		} else {
			return "joinFail";
		}
	}
	@RequestMapping(value = "boardView")
	public String boardView() {
		
		return "boardViews";
	}
	
}
