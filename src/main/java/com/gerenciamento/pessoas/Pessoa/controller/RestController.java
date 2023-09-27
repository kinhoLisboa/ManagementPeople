package com.gerenciamento.pessoas.Pessoa.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerPeople implements Controller{
    @Override
    public ResponsePerson create (RequestPerson request) {
        return null;
    }

    @Override
    public List<ListPessoaResponse> getEveryone() {
        return null;
    }

    @Override
    public PessoaDetalhadaResponse detalhar(UUID pessoaId) {
        return null;
    }

    @Override
    public void alterar(PessoaAlteraRequest pessoaAlteraRequest, UUID pessoaId) {

    }

    @Override
    public void deletar(UUID idPessoa) {

    }

    @Override
    public List<EnderecoResponse> criaEndereco(UUID pessoaId, EnderecoRequest enderecoRequest) {
        return null;
    }
}
