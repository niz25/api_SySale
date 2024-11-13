package com.example.sysale_API.repository;

import com.example.sysale_API.model.SyProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyProdutoRepository extends JpaRepository<SyProduto, Integer> {

    @Query(value = "SELECT * FROM SyProduto WHERE nome LIKE %?1%", nativeQuery = true)
    List<SyProduto> findByNome(String nome);

    @Query(value = "SELECT * FROM SyProduto WHERE codigo LIKE %?1%", nativeQuery = true)
    List<SyProduto> findByCodigo(int codigo);

    boolean existsByCodigo(int codigo);

    boolean existsByNome(String nome);
}
