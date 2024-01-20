package com.org.ecommerce.service;

import java.util.List;

import com.org.ecommerce.modal.Cusine;

public interface CusineService  {

	public Cusine getCusineById(long id);
		
	public int updateCusine(Cusine cusine);
		
	public void deleteCusine(long id);

	public List<Cusine> getAllCusines();
	
	public String getCusinesDropDown();

	public Cusine createCusine(Cusine cusine);

}
