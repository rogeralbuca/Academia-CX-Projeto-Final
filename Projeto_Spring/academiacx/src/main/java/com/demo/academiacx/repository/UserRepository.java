package com.demo.academiacx.repository;

import com.demo.academiacx.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    Optional<UserModel> findByUsername(String username);

    @Query("SELECT userModel FROM UserModel AS userModel WHERE userModel.id = ?1")
    Optional<UserModel> buscaPorId(Long id);

    @Query("select u from UserModel u where u.id = ?1 or u.nome = ?2 or u.email = ?3 or u.username = ?4")
    Optional<UserModel> findByNomeOrEmailOrIdOrUsername(Long id, String name, String email, String username);
    @Query("select u from UserModel u where u.username = ?1 and u.password = ?2")
    UserModel findByUsernameAndPassword(String username, String password);


}