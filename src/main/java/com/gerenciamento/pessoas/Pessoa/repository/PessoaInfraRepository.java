package com.gerenciamento.pessoas.Pessoa.repository;

import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository{

    private final PessoaJpaRepository repository;
    @Override
    public Pessoa save(Pessoa person) {
        log.info("[Inicia]PessoaInfraRepository - save");
        repository.save(person);
        log.info("[Inicia]PessoaInfraRepository - save");
        return person;
    }

    @Override
    public List<Pessoa> getList() {
        log.info("[Inicia]PessoaInfraRepository - getList");
        var people = repository.findAll();
        log.info("[Finaliza]PessoaInfraRepository - getList");
        return people;
    }

    @Override
    public Pessoa idQuest(UUID id) {
        log.info("[Inicia]PessoaInfraRepository - idQuest");
        var person = repository.getReferenceById(id);
        log.info("[Finaliza]PessoaInfraRepository - idQuest");
        return person;
    }

    @Override
    public void deleteId(Pessoa person) {
        log.info("[Inicia]PessoaApplicationService - deleteId");
        repository.delete(person);
        log.info("[Finaliaza]PessoaApplicationService - deleteId");

    }
}
