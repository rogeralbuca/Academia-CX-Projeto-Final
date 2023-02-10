package com.example.cadastro.repository;

import com.example.cadastro.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);

    //Optional<List<UserModel>> findByCepOrNome(String cep, String nome);
}
