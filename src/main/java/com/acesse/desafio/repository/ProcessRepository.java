package com.acesse.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acesse.desafio.model.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long>{

}
