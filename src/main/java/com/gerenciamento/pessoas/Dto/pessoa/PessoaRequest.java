package com.gerenciamento.pessoas.Dto.pessoa;

import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
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

    public PessoaRequest(Pessoa person) {

        this.name = person.getName();
        this.dateOfBirth = person.getDateOfBirth();
        this.address = person.getAddress();
    }
}
