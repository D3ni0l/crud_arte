package com.crud_arte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_arte.model.ArteModel;


public interface ArteRepository extends JpaRepository<ArteModel, Long> {

	// extends JpaRepository: faz o ArteRepository herdar metodos prontos para acessar o banco de dados.
	// ArteModel, Long: diz que o repositório vai trabalhar com a entidade ArteModel e que a chave primária dessa entidade será do tipo Long.
	
}

