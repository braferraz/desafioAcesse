package com.acesse.desafio.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acesse.desafio.model.DataFile;

@Repository
public interface DataFileRepository extends JpaRepository<DataFile, Long>{

}
