package com.testeattornatus.demo.controller;

import com.testeattornatus.demo.model.Endereco;
import com.testeattornatus.demo.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas/{pessoaId}/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(
            enderecoService.criarEndereco(pessoaId, endereco)
        );
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(
            enderecoService.listarEnderecos(pessoaId)
        );
    }
}

