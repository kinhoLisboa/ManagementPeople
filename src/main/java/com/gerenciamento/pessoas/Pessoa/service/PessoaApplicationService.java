package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Pessoa.Dto.ListPessoaResponse;
import com.gerenciamento.pessoas.Pessoa.Dto.PessoaAlteraRequest;
import com.gerenciamento.pessoas.Pessoa.Dto.PessoaRequest;
import com.gerenciamento.pessoas.Pessoa.Dto.PessoaResponse;
import com.gerenciamento.pessoas.Pessoa.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Log4j2
@Service
@RequiredArgsConstructor
public class PessoaApplicationService implements  PessoaService{

    private  final PessoaRepository repositoryPerson;

    @Override
    public PessoaResponse register(PessoaRequest request) {
        log.info("[Inicia]PessoaApplicationService - register");
       // validaEndereco(pessoaRequest);
        var person = repositoryPerson.save(new Pessoa(request));
        log.info("[Inicia]PessoaApplicationService - register");
        return new PessoaResponse(person);
    }

    @Override
    public List<ListPessoaResponse> list() {
        return null;
    }

    @Override
    public void quest(UUID id) {

    }

    @Override
    public void update(PessoaAlteraRequest request, UUID id) {

    }

    @Override
    public void delete(UUID id) {

    }
}
