package com.example.sysale_API.repository;

import com.example.sysale_API.model.SyLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SyLoginRepository extends JpaRepository<SyLogin, String> {

    Optional<SyLogin> findByNomeAndSenha(String nome, String senha);  // Correct method for login validation

    Optional<SyLogin> findBySenha(String senha);

}
