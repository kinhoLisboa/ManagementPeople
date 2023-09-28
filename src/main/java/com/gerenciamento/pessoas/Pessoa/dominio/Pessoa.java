package com.gerenciamento.pessoas.Pessoa.dominio;

import com.gerenciamento.pessoas.Dto.pessoa.PessoaAlteraRequest;
import com.gerenciamento.pessoas.Dto.pessoa.PessoaRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String dateOfBirth;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> address  = new ArrayList<>() ;

    public Pessoa(PessoaRequest requestPerson) {
        this.name = requestPerson.getName();
        this.dateOfBirth = requestPerson.getDateOfBirth();
        this.address = new ArrayList<Endereco>(requestPerson.getAddress());

    }
    public void alter(PessoaAlteraRequest request) {
        this.name = request.getName();
        this.dateOfBirth = request.getDateBirth();
        this.address = new ArrayList<Endereco>(request.getAddress());
    }
}
