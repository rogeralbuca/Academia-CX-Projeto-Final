package com.academiacx.repository;

import com.academiacx.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByUsername(String username);

    Optional<UsuarioModel> findByUsernameAndPassword(String username, String password);


}
