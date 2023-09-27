package com.gerenciamento.pessoas.Pessoa.Dto;

import lombok.Value;

import java.util.UUID;

@Value
public class PessoaResponse {

    private UUID id;
    private String name;
}
