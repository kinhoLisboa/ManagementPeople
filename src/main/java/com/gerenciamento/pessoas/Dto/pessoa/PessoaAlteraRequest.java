package com.gerenciamento.pessoas.Dto.pessoa;

import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import lombok.Value;

import java.util.List;

@Value
public class PessoaAlteraRequest {

    private String name;
    private String dateBirth;
    private List<Endereco> address;
}
