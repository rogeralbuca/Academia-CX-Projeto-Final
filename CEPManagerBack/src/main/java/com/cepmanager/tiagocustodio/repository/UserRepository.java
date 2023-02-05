package com.cepmanager.tiagocustodio.repository;

import com.cepmanager.tiagocustodio.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
