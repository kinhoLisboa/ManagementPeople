package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.pessoa.*;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse register(PessoaRequest request);

    List<ListPessoaResponse> list();

    PessoaDetalhadaResponse quest(UUID id);

    void update(PessoaAlteraRequest request, UUID id);

    void delete(UUID id);
}
