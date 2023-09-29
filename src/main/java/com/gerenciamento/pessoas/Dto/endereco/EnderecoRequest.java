package com.gerenciamento.pessoas.Dto.endereco;

import com.gerenciamento.pessoas.Pessoa.dominio.TipoEndereco;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoRequest {

    @NotBlank
    private String street;
    @NotBlank
    private String cep;
    @NotBlank
    private String number;
    @NotBlank
    private String city;
    @Enumerated(EnumType.STRING)
    private TipoEndereco type;



}
