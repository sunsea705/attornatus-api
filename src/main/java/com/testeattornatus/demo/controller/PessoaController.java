package com.testeattornatus.demo.controller;

import com.testeattornatus.demo.model.Pessoa;
import com.testeattornatus.demo.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(
            pessoaService.criarPessoa(pessoa)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(
            pessoaService.editarPessoa(id, pessoa)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id) {
        return ResponseEntity.ok(
            pessoaService.consultarPessoa(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return ResponseEntity.ok(
            pessoaService.listarPessoas()
        );
    }

    @PutMapping("/{pessoaId}/definir-endereco-principal/{enderecoId}")
    public ResponseEntity<Pessoa> definirEnderecoPrincipal(@PathVariable Long pessoaId,
                                                           @PathVariable Long enderecoId) {
        try {
            Pessoa pessoa = pessoaService.definirEnderecoPrincipal(pessoaId, enderecoId);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
