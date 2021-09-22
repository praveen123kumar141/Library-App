package com.oktay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oktay.model.Book;
import com.oktay.model.Issuebook;
import com.oktay.repositary.Bookrepositary;
import com.oktay.repositary.IssueBookRepositary;
@Service
public class IssueBookServiceimp implements IssueBookService {
	@Autowired
	private IssueBookRepositary ibr;
	public List<Issuebook> getAllIssueBooks() {
		List<Issuebook> ib=new ArrayList<>();
		ibr.findAll().forEach(ib::add);
		return ib;
	}
	public void issueaddbook(Issuebook ib) {
		// TODO Auto-generated method stub
		ibr.save(ib);
	}
	public Issuebook getIssueBook(Integer bookId) {
		return ibr.findById(bookId).get();
	}
	public Issuebook updateIssueBook(Integer bookid, Issuebook ib) {
		return ibr.save(ib);
	}
	public void deleteIssueBook(Integer bookId) {
		ibr.delete(getIssueBook(bookId));
	}
	
	
}
