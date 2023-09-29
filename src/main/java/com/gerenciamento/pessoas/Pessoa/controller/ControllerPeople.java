package com.gerenciamento.pessoas.Pessoa.controller;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Dto.pessoa.*;

import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.service.EnderecoService;
import com.gerenciamento.pessoas.Pessoa.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@Log4j2
@RequiredArgsConstructor
@RestController
public class ControllerPeople implements Controller{

    private final PessoaService servicePerson;
    private final EnderecoService addressService;
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
        PessoaDetalhadaResponse person = servicePerson.quest(id);
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
    public List<EnderecoResponse> createAddress(UUID personId, EnderecoRequest request) {
        log.info("[Inicia]PessoaController - criaEndereco");
        List<EnderecoResponse> address = addressService.createNewAddress(personId, request);
        log.info("[Finaliza]PessoaController -criaEndereco");
        return address;
    }

    @Override
    public List<EnderecoResponse> listAddressToId(UUID personId) {
        log.info("[Inicia]PessoaController - listAddressToId");
        List<EnderecoResponse> list = addressService.listAddressToId(personId);
        log.info("[Finaliza]PessoaController -listAddressToId");
        return list;
    }

    @Override
    public  List<EnderecoResponse> getAddressPrimary(UUID personId) {
        log.info("[Inicia]PessoaController - getAddressPrinciple");
        List<EnderecoResponse> address = addressService.getPrimaryAddress(personId);
        log.info("[Finaliza]PessoaController - getAddressPrinciple");
        return address;
    }

}
