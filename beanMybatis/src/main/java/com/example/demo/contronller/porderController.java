package com.example.demo.contronller;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.porderService;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.demo.vo.porder;
@RestController
@RequestMapping("/porder")
public class porderController {
	
	@Autowired
		porderService ps;
	
	@Autowired
		HttpSession session;
	
	@Autowired
	 HttpServletResponse response;
	
	@PostMapping("/add")
	public ModelAndView add(int a,int b,int c)
	{
		member m=(member) session.getAttribute("M");
		porder p=new porder(m.getName(),a,b,c);
		session.setAttribute("P", p);
		
		return new ModelAndView("/porder/confirm");
	}

	
	@GetMapping("/porder")
	public ModelAndView gotoPorder()
	{
		return new ModelAndView("/porder/porder");
	}
	

	@RequestMapping("/finish")
	public ModelAndView gotoFinish()
	{
		
		porder p=(porder) session.getAttribute("P");
		ps.addporder(p);
		return new ModelAndView("/porder/finish");
	}
	
	@RequestMapping("/logout")
	public void logout()
	{
		session.removeAttribute("M");
		session.removeAttribute("P");
		
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
