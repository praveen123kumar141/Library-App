package com.oktay.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oktay.model.Admin;
import com.oktay.model.Book;
import com.oktay.model.Issuebook;
import com.oktay.service.Bookservice;
import com.oktay.service.IssueBookService;

@Controller
public class IssueBookController {
	@Autowired
	IssueBookService ibs;
	@Autowired
	Bookservice bs;

	@RequestMapping("/list_issuebooks")
	public String   getissuBooks(Model m)
	{
		List<Issuebook>  l=ibs.getAllIssueBooks();
		m.addAttribute("model", l);
		return "dispissuebook";
	}
	
	@RequestMapping("/add_issuebook")
	public String   adding(Model m)
	{
		m.addAttribute("model", new Issuebook());
		   return  "addissuebook";
	}
	@RequestMapping("/save_issuebook")
	public String   savingIssuebook(@ModelAttribute("model") Issuebook b, Model m)
	{
		List<Book> listBooks = bs.getAllBooks();
		Iterator i=listBooks.iterator();
		while(i.hasNext())
		{	int count=0;
			Book b1=(Book) i.next();
			if(b1.getBookid()==b.getBookid()) {
				String s1=b1.getBookname();
				String s2=b1.getAuthorname();
				String s3=b1.getDeportment();
				b.setBookname(s1);b.setAuthorname(s2);b.setDeportment(s3);
				count=1;
				ibs.issueaddbook(b);
				bs.deleteBook(b.getBookid());
				List<Issuebook>  l=ibs.getAllIssueBooks();
				m.addAttribute("model", l);
				return "redirect:/list_issuebooks";

		}
		if(count==1) {
			ibs.issueaddbook(b);
			List<Issuebook>  l=ibs.getAllIssueBooks();
			m.addAttribute("model", l);
			return "redirect:/list_issuebooks";

		}
		else {
			return "addissuebook1";
		}
		}
		return null;
	}
}