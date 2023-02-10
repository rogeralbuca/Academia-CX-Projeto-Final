package com.academiacx.projetofinal.repository;

import com.academiacx.projetofinal.model.CadastroUsuario;
import com.academiacx.projetofinal.model.LoginUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<CadastroUsuario, Long> {

    Optional<LoginUsuario> findByUsername(String usuario);

    Optional<CadastroUsuario> findByEmail(String email);
}
