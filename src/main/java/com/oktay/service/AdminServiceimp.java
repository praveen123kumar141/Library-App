package com.oktay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oktay.model.Admin;
import com.oktay.repositary.Adminrepository;

@Service
public class AdminServiceimp implements AdminService1 {
	@Autowired
	Adminrepository ar;
	
	public void addlib(Admin ad) {
		// TODO Auto-generated method stub
		ar.save(ad);
	}
	public Admin getlib(Integer id) {
		return ar.findById(id).get();
	}
	public Admin updatelib(Integer id, Admin ad) {
		return ar.save(ad);
	}
	public void deleteBook(Integer id) {
		ar.delete(getlib(id));
	}
	public List<Admin> getAlllib() {
		List<Admin> books=new ArrayList<>();
		ar.findAll().forEach(books::add);
		return books;
	}
	@Override
	public void deletelib(Integer id) {
		ar.delete(getlib(id));
		
	}

}
