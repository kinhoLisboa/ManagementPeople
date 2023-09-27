package com.gerenciamento.pessoas.Pessoa.Dto;

import lombok.Value;

import java.util.List;

@Value
public class PessoaDetalhadaResponse {

    private UUID id;
    private String name;
    private String dateOfBirth;
    private List<Endereco> address;

    public PessoaDetalhadaResponse(Pessoa pessoa) {

        this.id = pessoa.getIdPessoa();
        this.name = pessoa.getNome();
        this.dateOfBirth = pessoa.getDataNascimento();
        this.address = new ArrayList<Endereco>(pessoa.getEndereco());

    }
}
