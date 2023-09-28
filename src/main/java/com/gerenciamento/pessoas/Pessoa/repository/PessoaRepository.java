package com.gerenciamento.pessoas.Pessoa.repository;

import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa save(Pessoa pessoa);

    List<Pessoa> getList();

    Pessoa idQuest(UUID id);

    void deleteId(Pessoa person);
}
