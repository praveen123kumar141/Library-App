package com.oktay.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oktay.model.Book;
import com.oktay.model.Issuebook;
import com.oktay.model.returnbook;
import com.oktay.service.Bookservice;
import com.oktay.service.IssueBookService;

@Controller
public class returnbookcon {
	@Autowired
	IssueBookService ibs;
	@Autowired
	Bookservice bs;
	@RequestMapping("/return_book")
	public String   returing(Model m)
	{
		m.addAttribute("model", new returnbook());
		   return  "returnbook";
	}
	@RequestMapping("/savereturn_book")
	public String   returingbook(@ModelAttribute("model") returnbook b, Model m) {
		Book bk=new Book();
		List<Issuebook>  l=ibs.getAllIssueBooks();
		Iterator i=l.iterator();
		int count = 0;
		while(i.hasNext())
		{	
			Issuebook ib=(Issuebook)i.next();
			if(b.getId()==ib.getBookid()) {
				int ik=ib.getBookid();
				String s1=ib.getBookname();
				String s2=ib.getAuthorname();
				String s3=ib.getDeportment();
				bk.setBookid(ik);bk.setBookname(s1);bk.setAuthorname(s2);bk.setDeportment(s3);
				count=1;
			}
		}
		if(count==1) {
			bs.addBook(bk);
			ibs.deleteIssueBook(b.getId());
			List  l1=bs.getAllBooks();
			m.addAttribute("model", l1);
			return "redirect:/list_books";
		}
		else {
			return "returnbooks";
		}
		

}}

