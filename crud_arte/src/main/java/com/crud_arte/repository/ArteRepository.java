package com.crud_arte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_arte.model.ArteModel;

	public interface ArteRepository  extends JpaRepository<ArteModel, Long>{
	}


	