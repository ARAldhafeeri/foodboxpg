package com.org.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.ecommerce.modal.Cusine;
import com.org.ecommerce.repository.CusineRepository;

@Service
public class CusineServiceImpl implements CusineService  {
	
	@Autowired
    CusineRepository CusineRepository;
	
		@Override
		public Cusine getCusineById(long id) {
			return CusineRepository.getCusineById(id);
		}
		
		@Override
		public void deleteCusine(long id) {
			CusineRepository.deleteCusine(id);
			}

		@Override
		public List<Cusine> getAllCusines() {
			return CusineRepository.findAll();
			}
			
		@Override
		public String getCusinesDropDown() {
			StringBuilder sb = new StringBuilder("");
			List<Cusine> list = CusineRepository.findAll();
			for(Cusine cus: list) {
				sb.append("<option value=" + String.valueOf(cus.getID()) + ">" + cus.getName() + "</option>");
			}
			return sb.toString();
			}

		@Override
		@Transactional
		public int updateCusine(Cusine Cusine) {
			return CusineRepository.updCusine(Cusine.getID(), Cusine.getName());
		}

		@Override
		public Cusine createCusine(Cusine Cusine) {
			return CusineRepository.save(Cusine);
		}

}
