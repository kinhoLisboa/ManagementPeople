package com.gerenciamento.pessoas.Dto.pessoa;

import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
public class PessoaDetalhadaResponse {

    private UUID id;
    private String name;
    private String dateOfBirth;
    private List<Endereco> address;

    public PessoaDetalhadaResponse(Pessoa person) {

        this.id = person.getId();
        this.name = person.getName();
        this.dateOfBirth = person.getDateOfBirth();
        this.address = new ArrayList<Endereco>(person.getAddress());

    }

}
