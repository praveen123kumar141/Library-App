package com.oktay.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oktay.model.Admin;
import com.oktay.model.Adminlog;
import com.oktay.model.Book;
import com.oktay.service.AdminService1;
import com.oktay.service.Bookservice;

@Controller
public class Bookcontroller {
	
	@Autowired
	private Bookservice bs;
	@Autowired
	private AdminService1 as;
	@RequestMapping("/list_books")
	public String   getBooks(Model m)
	{
		List  l=(List)bs.getAllBooks();
		m.addAttribute("model", l);
		return "hello";
	}
	
	@RequestMapping("/add_book")
	public String   adding(Model m)
	{
		m.addAttribute("model", new Book());
		   return  "addBook";
	}
		@RequestMapping("/save_book")
	public String   adding( @ModelAttribute("model") Book b, Model m)
	{	
		bs.addBook(b);
		List  l=bs.getAllBooks();
		m.addAttribute("model", l);
		return "redirect:/list_books";
	}

	@RequestMapping(value="/edit_book", method = RequestMethod.GET)
	public String editBook(@RequestParam("code")  int  code , Model m)
	{
	
		Book c=bs.getBook(code);
		bs.deleteBook(code);
		m.addAttribute("model", c);
		return "addBook";
	}
	
	@RequestMapping(value="/delete_book", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("code")  int  code)
	{
		
		bs.deleteBook(code);
		 		 return  "redirect:/list_books";
	}
	@RequestMapping("/lib_login")
	public String   libloin(Model m)
	{
			m.addAttribute("model",new Admin());
		   return  "liblogin";
	}
	@RequestMapping("/lib_logincheck")
	public String   libloincheck(@ModelAttribute("model") Admin a,Model m)
	{	
		List<Admin> l=(List)as.getAlllib();
		Iterator i=l.iterator();
		while(i.hasNext()) {
			Admin ad=(Admin) i.next();
			if(ad.getId()==a.getId() && (ad.getPass()).equals(a.getPass())){
				System.out.println("hello");
				return "redirect:/list_books";
			}
		}
		return "liblogins";
	}
	@RequestMapping("/liblog_out")
	public String   liblogout()
	{
		   return  "admins";
	}
}

