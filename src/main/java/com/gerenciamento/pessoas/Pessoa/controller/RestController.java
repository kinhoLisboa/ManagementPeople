package com.gerenciamento.pessoas.Pessoa.controller;

import com.gerenciamento.pessoas.Pessoa.Dto.*;
import com.gerenciamento.pessoas.Pessoa.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@Log4j2
@RequiredArgsConstructor
@RestController
public class RestControllerPeople implements Controller{

    private final PessoaService servicePerson;
    @Override
    public PessoaResponse create (PessoaRequest request) {
        log.info("[Inicia]PessoaController -create");
        PessoaResponse person = servicePerson.register(request);
        log.info("[Finaliza]PessoaController -create");
        return person;
    }

    @Override
    public List<ListPessoaResponse> getEveryone() {
        log.info("[Inicia]PessoaController -getEveryone");
        List<ListPessoaResponse> people = servicePerson.list();
        log.info("[Finaliza]PessoaController -getEveryone");
        return people;
    }

    @Override
    public PessoaDetalhadaResponse detail(UUID id) {
        log.info("[Inicia]PessoaController -detail");
        log.info("PessoaId ()", id);
        var person = servicePerson.quest(id);
        log.info("[Finaliza]PessoaController -detail");
        return person;
    }

    @Override
    public void alter(PessoaAlteraRequest request, UUID id) {
        log.info("[Inicia]PessoaController -alter");
        log.info("PessoaId ()", id);
        servicePerson.update(request, id);
        log.info("[Finaliza]PessoaController -alter");
    }

    @Override
    public void deletar(UUID id) {
        log.info("[Inicia]PessoaController - deletar");
        log.info("PessoaId ()", id);
        servicePerson.delete(id);
        log.info("[Finaliza]PessoaController - deletar");

    }

    @Override
    public List<EnderecoResponse> criaEndereco(UUID pessoaId, EnderecoRequest enderecoRequest) {
        log.info("[Inicia]PessoaController - criaEndereco");
        log.info("PessoaId ()", pessoaId);
        List<EnderecoResponse> endereco =	enderecoService.criaNovoEndereco(pessoaId, enderecoRequest);
        log.info("[Finaliza]PessoaController -criaEndereco");
        return endereco;
    }
}
