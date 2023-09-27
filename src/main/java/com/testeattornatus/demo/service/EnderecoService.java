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
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final PessoaRepository pessoaRepository;

    public Endereco criarEndereco(Long pessoaId, Endereco endereco) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElse(null);
        if (pessoa != null) {
            endereco.setPessoa(pessoa);
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    public List<Endereco> listarEnderecos(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
            .map(Pessoa::getEnderecos)
            .orElse(null);

    }

}
