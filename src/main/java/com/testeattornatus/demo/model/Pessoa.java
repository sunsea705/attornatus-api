package com.testeattornatus.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
    private List<Endereco> enderecos;
    private Long enderecoPrincipalId;

}
