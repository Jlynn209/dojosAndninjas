package com.jeremy.dojosAndNinajs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremy.dojosAndNinajs.models.Ninja;
import com.jeremy.dojosAndNinajs.repos.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	NinjaRepo ninjaRepo;
	
//	SHOW ALL
	public List<Ninja> showAllNinjas() {
		return ninjaRepo.findAll();
	}
	
//	CREATE
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
		

}
