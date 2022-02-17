package com.jeremy.dojosAndNinajs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremy.dojosAndNinajs.models.Dojo;
import com.jeremy.dojosAndNinajs.repos.DojoRepo;


@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;
	
//	SHOW ALL
	public List<Dojo> showAllDojos() {
		return dojoRepo.findAll();
	}
	
//	SHOW ONE
	public Dojo showOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
//	CREATE
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
}
