package com.example.sysale_API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SyProduto")
public class SyProduto {

    @Id
    private int codigo;

    @Column
    private String nome;

    @Column
    private int quantidade;

    @Column
    private double preco;

    /*GETTERS E SETTERS*/

    // - CÓDIGO -----------------------------
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // - NOME -----------------------------
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // - PREÇO -----------------------------
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // - QUANTIDADE -----------------------------
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
