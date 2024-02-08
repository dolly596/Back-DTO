package com.atividade.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.dto.entities.AtividadeDTO;

public interface AtividadeDTORepository extends JpaRepository<AtividadeDTO, Long>{

}
