package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.pessoa.*;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import com.gerenciamento.pessoas.Pessoa.dominio.TipoEndereco;
import com.gerenciamento.pessoas.Pessoa.repository.PessoaRepository;
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
        Pessoa person = repositoryPerson.save(new Pessoa(request));
        log.info("[Inicia]PessoaApplicationService - register");
        return new PessoaResponse(person);
    }

    @Override
    public List<ListPessoaResponse> list() {
        log.info("[Inicia]PessoaApplicationService - list");
        List<Pessoa> people = repositoryPerson.getList();
        log.info("[Finaliza]PessoaApplicationService - list");
        return ListPessoaResponse.convert(people);
    }

    @Override
    public PessoaDetalhadaResponse quest(UUID id) {
        log.info("[Inicia]PessoaApplicationService - quest");
        Pessoa person = repositoryPerson.idQuest(id);
        log.info("[Finaliza]PessoaApplicationService - quest");
        return new PessoaDetalhadaResponse(person);

    }

    @Override
    public void update(PessoaAlteraRequest request, UUID id) {
        log.info("[Inicia]PessoaApplicationService - update");
        Pessoa person =	repositoryPerson.idQuest(id);
        person.alter(request);
        repositoryPerson.save(person);
        log.info("[Finaliza]PessoaApplicationService - update");
    }

    @Override
    public void delete(UUID id) {
        log.info("[Inicia]PessoaApplicationService - delete");
        Pessoa person = repositoryPerson.idQuest(id);
        repositoryPerson.deleteId(person);
        log.info("[Finaliza]PessoaApplicationService - delete");

    }
    @Override
    public void validatesAddress(PessoaRequest request) {
        long qtdEnderecoPrincipal = request.getAddress()
                .stream()
                .filter(endereco -> TipoEndereco.PRINCIPAL.equals(endereco.getType())).count();

        if(qtdEnderecoPrincipal>1) {
            throw new QuantidadeEnderecoPrincipalInválida("Não é permitido inserir mais de um endereço principal.");
        }
    }
}
