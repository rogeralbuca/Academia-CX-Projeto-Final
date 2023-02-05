package com.commerce.acdemycxfinal.repository;

import com.commerce.acdemycxfinal.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {

}
