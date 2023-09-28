package com.gerenciamento.pessoas.Pessoa.repository;

import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaJpaRepository extends JpaRepository<Pessoa, UUID> {
}
