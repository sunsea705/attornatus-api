package com.testeattornatus.demo.service;

import com.testeattornatus.demo.model.Endereco;
import com.testeattornatus.demo.model.Pessoa;
import com.testeattornatus.demo.repository.EnderecoRepository;
import com.testeattornatus.demo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa editarPessoa(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarPessoa(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa definirEnderecoPrincipal(Long pessoaId, Long enderecoId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElse(null);
        if (pessoa != null) {
            Endereco endereco = enderecoRepository.findById(enderecoId).orElse(null);
            if (endereco != null) {
                if (pessoa.getEnderecos().contains(endereco)) {
                    pessoa.setEnderecoPrincipalId(enderecoId);
                    pessoaRepository.save(pessoa);
                } else {
                    throw new IllegalArgumentException("O endereço não pertence à pessoa.");
                }
            } else {
                throw new IllegalArgumentException("Endereço não encontrado.");
            }
        } else {
            throw new IllegalArgumentException("Pessoa não encontrada.");
        }
        return pessoa;
    }

}

