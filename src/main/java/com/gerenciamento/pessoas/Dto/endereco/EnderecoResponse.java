package com.gerenciamento.pessoas.Dto.endereco;

import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EnderecoResponse {

    UUID id;
    private String cep;
    private String number;

    public EnderecoResponse(Endereco address) {
        this.id = address.getId();
        this.cep = address.getCep();
        this.number = address.getNumber();
    }

    public static List<EnderecoResponse> parseToList(List<Endereco> list) {
        return  list.stream().map(EnderecoResponse:: new).collect(Collectors.toList());

    }
}
