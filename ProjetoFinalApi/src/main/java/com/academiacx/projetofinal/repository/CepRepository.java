package com.academiacx.projetofinal.repository;


import com.academiacx.projetofinal.model.ViaCepModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository  extends JpaRepository<ViaCepModel, Long> {
}
