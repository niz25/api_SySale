package com.example.sysale_API.controller;

import com.example.sysale_API.model.SyProduto;
import com.example.sysale_API.repository.SyProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/apiProdutos")
public class SyProdutoController {

    @Autowired
    SyProdutoRepository produtosRepository;

    @GetMapping(value = "/produtos")
    public List<SyProduto> listarProdutos() {
        return produtosRepository.findAll();
    }

    // BUSCA PRODUTOS POR NOME
    @GetMapping("/produtos/nome/{nome}")
    public List<SyProduto> buscarProdutosporNome(@PathVariable(value = "nome") String nome) {
        return produtosRepository.findByNome(nome);
    }

    // BUSCA PRODUTOS POR CÓDIGO
    @GetMapping("/produtos/codigo/{codigo}")
    public List<SyProduto> listarProdutosporCodigo(@PathVariable(value = "codigo") int codigo) {
        return produtosRepository.findByCodigo(codigo);  // Busca exata por código inteiro
    }


    // CADASTRO DE PRODUTOS
    @PostMapping("/inserirProdutos")
    public ResponseEntity<String> inserirProdutos(@RequestBody SyProduto produtos)
    {
        if(produtosRepository.existsByCodigo(produtos.getCodigo()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto já cadastrado com este código!");
        }
        if(produtosRepository.existsByNome(produtos.getNome()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto já cadastrado com este Nome!");
        }

        produtosRepository.save(produtos);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com SUCESSO!");
    }

    // ATUALIZA PRODUTOS
    @PutMapping("/atualizarProdutos")
    public void atualizarProdutos(@RequestBody SyProduto produtos) {
        produtosRepository.save(produtos);
    }

    //DELETA PRODUTOS
    @DeleteMapping("/removerProduto/{codigo}")
    public ResponseEntity<String> removerProduto(@PathVariable int codigo) {
        if(produtosRepository.existsById(codigo))
        {
            produtosRepository.deleteById(codigo);
            return ResponseEntity.ok("Produto excluído com sucesso!");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
    }


}
