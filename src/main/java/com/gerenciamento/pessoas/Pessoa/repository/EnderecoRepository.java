package com.gerenciamento.pessoas.Pessoa.repository;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository {

    List<Endereco> listAddressToId(UUID personId);
}
