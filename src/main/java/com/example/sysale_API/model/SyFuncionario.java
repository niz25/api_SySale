package com.example.sysale_API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SyFuncionario")
public class SyFuncionario {

    @Column
    private String nome;

    @Id
    @Column(length = 11)
    private String cpf;

    @Column
    private String email;

    // - EMAIL -----------------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // - NOME -----------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // - CPF -----------------------------
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
