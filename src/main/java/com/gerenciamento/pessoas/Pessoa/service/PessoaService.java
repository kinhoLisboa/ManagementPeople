package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Pessoa.Dto.ListPessoaResponse;
import com.gerenciamento.pessoas.Pessoa.Dto.PessoaAlteraRequest;
import com.gerenciamento.pessoas.Pessoa.Dto.PessoaRequest;
import com.gerenciamento.pessoas.Pessoa.Dto.PessoaResponse;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse register(PessoaRequest request);

    List<ListPessoaResponse> list();

    void quest(UUID id);

    void update(PessoaAlteraRequest request, UUID id);

    void delete(UUID id);
}
