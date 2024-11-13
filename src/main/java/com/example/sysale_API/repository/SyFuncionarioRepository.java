package com.example.sysale_API.repository;

import com.example.sysale_API.model.SyFuncionario;
import com.example.sysale_API.model.SyProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyFuncionarioRepository  extends JpaRepository<SyFuncionario, Integer> {

    @Query(value = "SELECT * FROM SyFuncionario WHERE nome LIKE %?1%", nativeQuery = true)
    List<SyFuncionario> findByNome(String nome);

    @Query(value = "SELECT * FROM SyFuncionario WHERE cpf = ?1", nativeQuery = true)
    List<SyFuncionario> findByCpfEspecifico(String cpf);

    boolean existsByCpf(String cpf);
}
