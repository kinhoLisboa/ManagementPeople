package com.gerenciamento.pessoas.Pessoa.dominio;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String street;

    private String cep;

    private String number;

    private String city;


    private TipoEndereco type;

    public Endereco(UUID personId, EnderecoRequest request) {
        this.street = request.getStreet();
        this.cep = request.getCep();
        this.number = request.getNumber();
        this.city = request.getCity();
        this.type = request.getType();
    }
    public Endereco(EnderecoRequest request) {
        this.street = request.getStreet();
        this.cep = request.getCep();
        this.number = request.getNumber();
        this.city= request.getCity();
        this.type = request.getType();
    }

    public Endereco(TipoEndereco tipoEndereco) {
        this.type = tipoEndereco;
    }
}
