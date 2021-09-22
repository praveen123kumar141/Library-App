package com.oktay.service;

import java.util.List;

import com.oktay.model.Admin;

public interface AdminService1 {
public void addlib(Admin ad);
	
	public Admin getlib(Integer id);
	
	public Admin updatelib(Integer id,Admin ad);

	public void deletelib(Integer id);

	public List<Admin> getAlllib();


}
