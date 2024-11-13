package com.example.sysale_API.controller;

import com.example.sysale_API.model.SyLogin;
import com.example.sysale_API.repository.SyLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/apiLogin")
public class SyLoginController {

    @Autowired
    SyLoginRepository loginRepository;

    @GetMapping(value = "/login")
    public List<SyLogin> listarLogins()
    {
        return loginRepository.findAll();
    }

    // BUSCA DE LOGIN POR SENHA
    @GetMapping("/login/{senha}")
    public ResponseEntity<Object> buscarLoginPorSenha(@PathVariable(value = "senha") String senha) {
        Optional<SyLogin> usuario = loginRepository.findBySenha(senha);

        if(usuario.isPresent()) {
            // traz o nome e tipo do usuário encontrado
            String nome = usuario.get().getNome();
            String tipo = usuario.get().getTipo();

            // retorna os dados como um mapa (Map)
            return ResponseEntity.ok(Map.of("nome", nome, "tipo", tipo));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": \"error\", \"message\": \"Usuário não encontrado!\"}");
    }

    // VALIDAÇÃO DE LOGIN
    @PostMapping(value = "/validar")
    public ResponseEntity<String> autenticarLogin(@RequestBody SyLogin nome)
    {
        Optional<SyLogin> usuario = loginRepository.findByNomeAndSenha(nome.getNome(), nome.getSenha());

        if(usuario.isPresent())
        {

            String nomeUsuario = usuario.get().getNome();
            String tipoUsuario = usuario.get().getTipo();

            return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"Login bem-sucedido!\", \"nome\": \"" + nomeUsuario + "\", \"tipo\": \"" + tipoUsuario + "\"}");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"status\": \"error\", \"message\": \"Login ou senha incorretos!\"}");
    }

}
