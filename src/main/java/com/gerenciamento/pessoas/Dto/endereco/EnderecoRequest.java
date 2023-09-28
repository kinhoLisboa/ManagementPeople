package com.gerenciamento.pessoas.Dto.endereco;

import com.gerenciamento.pessoas.Pessoa.dominio.TipoEndereco;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EnderecoRequest {

    @NotBlank
    private String logradouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
    @Enumerated(EnumType.STRING)
    private TipoEndereco type;
}
