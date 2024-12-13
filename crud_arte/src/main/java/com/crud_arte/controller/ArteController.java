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

@RestController // avisa que essa classe vai cuidar das requisições e respostas da api
@RequestMapping("arte") // (endpoint) todas as rotas aqui começam com /arte
public class ArteController {

	@Autowired // cuida de criar e conectar o repository automaticamente
	ArteRepository repository;
	
	@GetMapping("/listar") // essa função responde requisições pra /arte/listar
	public List<ArteModel> listar(){ 
		// busca todas as artes no banco e devolve
		return repository.findAll();
	}
	
	@PostMapping("/cadastrar") // responde pra /arte/cadastrar com uma requisição post
	public void cadastrar(@RequestBody ArteDTO art){ 
		// pega o json que mandaram na requisição e transforma em um objeto java
		ArteModel arte = new ArteModel(art);
		// passa os dados do dto pro model
		repository.save(arte); // salva o model no banco
	}

	@PutMapping("/atualizar/{id}") // responde pra /arte/atualizar/algum-id
	public List<ArteModel> atualizar(@PathVariable Long id, @RequestBody ArteModel art) {
	    // procura a arte pelo id no banco 
	    repository.findById(id);
	    art.setId(id); // coloca o id no objeto que veio da requisição
	    repository.save(art); // salva no banco com os dados atualizados
	    return repository.findAll(); // devolve tudo do banco (isso nem é tão útil aqui)
	}
	
	@DeleteMapping("/deletar/{id}") // responde pra /arte/deletar/algum-id
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id); // apaga a arte com o id que veio na url
	}
}