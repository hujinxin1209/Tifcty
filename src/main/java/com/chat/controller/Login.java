package com.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chat.pojo.Staff;
import com.chat.service.LoginService;

@Controller
public class Login {
	@Autowired
	LoginService loginservice;
	
	@RequestMapping("/loginvalidate")
	public String loginvalidate(@RequestParam("username") String username,@RequestParam("pic") String pic,@RequestParam("password") String pwd,HttpSession httpSession){
		String picode=(String) httpSession.getAttribute("rand");
		if(!picode.equalsIgnoreCase(pic))
			return "failcode";
		if(username==null)
			return "login";
		Staff staff = loginservice.getStaffByName(username);
		if(staff != null && staff.getPassword() != null && pwd.equals(staff.getPassword()))
		{
			long uid = staff.getStaffId();
			httpSession.setAttribute("username", username);
			httpSession.setAttribute("uid", uid);
			return "chatroom";
		}else
			return "fail";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession){
		httpSession.removeAttribute("username");
		httpSession.removeAttribute("uid");
		return "login";
	}
}
