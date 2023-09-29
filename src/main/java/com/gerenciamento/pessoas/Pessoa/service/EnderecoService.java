package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    List<EnderecoResponse> createNewAddress(UUID personId, EnderecoRequest request);

    List<EnderecoResponse> listAddressToId(UUID personId);

    List<EnderecoResponse>  getPrimaryAddress(UUID personId);

}
