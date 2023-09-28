package com.gerenciamento.pessoas.Dto.pessoa;

import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import lombok.Value;

import java.util.UUID;

@Value
public class PessoaResponse {

    private UUID id;
    private String name;

    public PessoaResponse(Pessoa person) {

        this.id = person.getId();
        this.name = person.getName();
    }
}
