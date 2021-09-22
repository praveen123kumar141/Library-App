package com.oktay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oktay.model.Admin;
import com.oktay.model.Adminlog;
import com.oktay.service.AdminService1;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Admincontroller {
	@Autowired
	AdminService1 as;
	
		
	@RequestMapping("/list_libs")
	public String   getlibs(Model m)
	{
		List l=(List)as.getAlllib();
		m.addAttribute("model", l);
		return "displib";
	}
	
	@RequestMapping("/add_lib")
	public String   adding1(Model m)
	{
		m.addAttribute("model", new Admin());
		   return  "addlib";
	}
		@RequestMapping("/save_lib")
	public String   adding(@ModelAttribute("model") Admin b,Model m)
	{
		as.addlib(b);
		List  l=(List)as.getAlllib();
		m.addAttribute("model", l);
		return "redirect:/list_libs";
	}
	
	@RequestMapping(value="/edit_lib", method = RequestMethod.GET)
	public String editBook1(@RequestParam("code")  int  code , Model m)
	{
		
		Admin c=as.getlib(code);
		as.deletelib(code);
		m.addAttribute("model", c);
		return "addlib";
	}
	
	@RequestMapping(value="/delete_lib", method = RequestMethod.GET)
	public String deleteBook1(@RequestParam("code")  int  code)
	{
		
		 as.deletelib(code);
		 		 return "redirect:/list_libs";}

	@RequestMapping("/admin_login")
	public String adminlogin(Model m) {
		m.addAttribute("model",new Adminlog());
		return "adminlogin";
	}
	@RequestMapping("/admin_logincheck")
	public String adminlogincheck(@ModelAttribute("model") Adminlog al,Model m) {
		String s1="praveen@gmail.com";
		String s2="praveen1234";
		System.out.println(al.getUsername());
		System.out.println(al.getPassword());
		if(s1.equals(al.getUsername()) && s2.equals(al.getPassword())) {
			System.out.println("hello");
			return "redirect:/list_libs";}
		else {
			return "adminlogin";
			}
	
}
	@RequestMapping("/log_out")
	public String adminlogin() {
		return "admins";
	}
}