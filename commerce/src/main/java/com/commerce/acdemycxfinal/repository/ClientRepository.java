package com.commerce.acdemycxfinal.repository;


import com.commerce.acdemycxfinal.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    Optional<ClientModel> findByUsername(String username);

    Optional<ClientModel> findByNome(String nome);


}
