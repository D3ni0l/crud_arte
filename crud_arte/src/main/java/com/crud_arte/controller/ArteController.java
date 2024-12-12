package com.crud_arte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud_arte.dto.ArteDTO;
import com.crud_arte.model.ArteModel;
import com.crud_arte.repository.ArteRepository;

@RestController
@RequestMapping("arte")
public class ArteController {

	@Autowired
	ArteRepository repository;
	
	@GetMapping("/listar")
	public List<ArteModel> listar(){
		return repository.findAll();
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody ArteDTO art){
		ArteModel arte = new ArteModel();
		repository.save(arte);
	}

	@PutMapping("/atualizar/{id}")
	public List<ArteModel> atualizar(@PathVariable Long id, @RequestBody ArteModel art) {
	    repository.findById(id);
	    art.setId(id);
	    repository.save(art);
	    return repository.findAll();
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
		
}

}