package com.acesse.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acesse.desafio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
