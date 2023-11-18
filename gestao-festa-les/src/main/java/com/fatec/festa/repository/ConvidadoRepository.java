package com.fatec.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.festa.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Integer>  {

}
