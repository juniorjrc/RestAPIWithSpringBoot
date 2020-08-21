package br.com.jrcsofthouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jrcsofthouse.data.vo.PersonVO;
import br.com.jrcsofthouse.services.PersonService;

@RestController
@RequestMapping("/PersonVO")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping	
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	@GetMapping("/{id}")	
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findbyId(id);
	}
	
	@PostMapping	
	public PersonVO create(@RequestBody PersonVO personVO) {
		return services.create(PersonVO);
	}
	
	@PutMapping	
	public PersonVO update(@RequestBody PersonVO personVO) {
		return services.update(personVO);
	}
	
	@DeleteMapping("/{id}")		
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

}
