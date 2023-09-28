package com.gerenciamento.pessoas.Dto.pessoa;

import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import lombok.Value;

import java.util.List;

@Value
public class ListPessoaResponse {

    private String name;
    private String dateOfBirth;

    public static List<ListPessoaResponse> convert(List<Pessoa> people) {

        return people.stream().map(ListPessoaResponse::new).toList();
    }
    public ListPessoaResponse(Pessoa pessoa) {
        super();
        this.name = pessoa.getName();
        this.dateOfBirth = pessoa.getDateOfBirth();
    }
}
