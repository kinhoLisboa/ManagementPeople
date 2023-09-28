package com.gerenciamento.pessoas.Pessoa.repository;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoJPARepository extends JpaRepository<Endereco, UUID> {

    List<Endereco> findAllByIdPerson(UUID personId);
}
