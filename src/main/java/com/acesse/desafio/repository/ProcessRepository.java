package com.acesse.desafio.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acesse.desafio.model.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long>{

	@Query("SELECT a FROM Process a WHERE active = true") // Efetua a busca no banco apenas por processos ativos
	public Page<Process> findActiveProcess(Pageable pageable);


}
