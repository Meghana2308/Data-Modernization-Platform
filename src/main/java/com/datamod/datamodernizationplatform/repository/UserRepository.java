package com.datamod.datamodernizationplatform.repository;

import com.datamod.datamodernizationplatform.model.Customer;
import com.datamod.datamodernizationplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}