package com.gerenciamento.pessoas.Pessoa.Dto;

import lombok.Value;

@Value
public class PessoaAlteraRequest {

    private String name;
    private String dateBirth;
    private List<Endereco> address;
}
