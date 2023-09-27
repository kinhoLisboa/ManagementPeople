package com.gerenciamento.pessoas.Pessoa.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.util.UUID;

@Value
@NoArgsConstructor
public class PessoaRequest {

    private UUID id;
    @NotBlank
    private String name;

    @NotBlank
    private String dateOfBirth;
    @Valid
    @NotEmpty
    private List<Endereco> address;

    public PessoaRequest(Pessoa pessoa) {

        this.nome = pessoa.getNome();
        this.dateBirth = pessoa.getDataNascimento();
        this.endereco = pessoa.getEndereco();
    }
}
