package com.jeremy.dojosAndNinajs.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeremy.dojosAndNinajs.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
	
	List<Dojo> findAll();
}
