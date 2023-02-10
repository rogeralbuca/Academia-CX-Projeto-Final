package com.cepmanager.igorfilgueira.repository;
import com.cepmanager.igorfilgueira.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório JPA que implementa o acesso aos dados do EnderecoModel no banco de dados.
@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

}