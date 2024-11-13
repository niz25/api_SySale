package com.example.sysale_API.controller;

import com.example.sysale_API.model.SyFuncionario;
import com.example.sysale_API.repository.SyFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/apiFuncionario")
public class SyFuncionarioController {

    @Autowired
    SyFuncionarioRepository funcionarioRepository;

    @GetMapping(value = "/funcionarios")
    public List<SyFuncionario> listarFuncionarios()
    {
        return funcionarioRepository.findAll();
    }

    // BUSCA DE FUNCIONÁRIOS POR NOME
    @GetMapping("/funcionarios/nome/{nome}")
    public List<SyFuncionario> buscaFuncionarioporNome(@PathVariable(value = "nome")String nome)
    {
        return funcionarioRepository.findByNome(nome);
    }

    // BUSCA DE FUNCIONÁRIOS POR CPF
    @GetMapping("/funcionarios/cpf/{cpf}")
    public List<SyFuncionario> buscaFuncionarioporCpf(@PathVariable(value = "cpf")String cpf)
    {
        return funcionarioRepository.findByCpfEspecifico(cpf);
    }

    // CADASTRO DE FUNCIONÁRIOS
    @PostMapping("/inserirFuncionarios")
    public ResponseEntity<String> inserirFuncionarios(@RequestBody SyFuncionario funcionario)
    {
        if(funcionarioRepository.existsByCpf(funcionario.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Funcionário já cadastrado com esse CPF!");
        }

        funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário cadastrado com SUCESSO!");
    }

    // ATUALIZAÇÃO DE FUNCIONÁRIOS
    @PutMapping("/atualizarFuncionarios")
    public void atualizarFuncionarios(@RequestBody SyFuncionario funcionario)
    {
        funcionarioRepository.save(funcionario);
    }

}
