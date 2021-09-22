package com.oktay.service;

import java.util.List;

import com.oktay.model.Book;
import com.oktay.model.Issuebook;

public interface IssueBookService {
	public void issueaddbook(Issuebook book);
	public List<Issuebook> getAllIssueBooks();
	public Issuebook getIssueBook(Integer bookId);
	
	public Issuebook updateIssueBook(Integer bokid,Issuebook ib);

	public void deleteIssueBook(Integer bookId);

}
