package com.example.demo.contronller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.memberMapper;
import com.example.demo.service.impl.memberServiceIpml;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;

import jakarta.servlet.http.HttpSession;

@RestController
public class memberController {
	
	@Autowired
		memberServiceIpml msi;
	
	@Autowired 
	HttpSession session;
	
	@PostMapping("/Login")
	public ModelAndView gotologin(String username,String password)
	{
		member m=msi.Login(username, password);
		ModelAndView mav=null;
		if(m!=null)
		{
			session.setAttribute("M", m);
			List<porder> lo=new ArrayList();
			
			mav=new ModelAndView("/loginSuccess");
		}else {
			mav=new ModelAndView("/loginError");
		}
		return mav;
	}
	@GetMapping("/addMember")
	 public ModelAndView gotoAddMember()
	 {
		return new ModelAndView("/addMember");
	 }
	
	@PostMapping("/add")
	public ModelAndView addMember(String name,String username,String password)
	{
		boolean u=msi.UsernameRepeat(username);
		ModelAndView mav=null;
		if(u)
		{
			mav=new ModelAndView("/addMemberError");
		}else {
			member m=new member(name,username,password);
			msi.addMember(m);
			mav=new ModelAndView("/addMemberSuccess");
		}
		return mav;
	}

	
	
	
}
