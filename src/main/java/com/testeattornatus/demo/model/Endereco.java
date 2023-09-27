package com.testeattornatus.demo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    @ManyToOne
    private Pessoa pessoa;
}
