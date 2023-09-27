package com.testeattornatus.demo;

import com.testeattornatus.demo.model.Pessoa;
import com.testeattornatus.demo.repository.PessoaRepository;
import com.testeattornatus.demo.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTests {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    // teste projetado para verificar falhas
    @Test
    public void testandoCriacaoPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carolina");
        pessoa.setDataNascimento("1999-09-02");

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);

        assertNotNull(novaPessoa);
        assertEquals("Karolina", novaPessoa.getNome());
        assertEquals("1999-02-09", novaPessoa.getDataNascimento());

        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    // teste projetado para passar
    @Test
    public void testarEdicaoPessoa() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("Dayanne");
        pessoa.setDataNascimento("1985-02-15");

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);
        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        Pessoa pessoaEditada = pessoaService.editarPessoa(id, pessoa);

        assertNotNull(pessoaEditada);
        assertEquals("Dayanne", pessoaEditada.getNome());
        assertEquals("1985-02-15", pessoaEditada.getDataNascimento());

        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

}

