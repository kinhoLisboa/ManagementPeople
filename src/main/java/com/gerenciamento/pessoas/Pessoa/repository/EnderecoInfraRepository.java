package com.gerenciamento.pessoas.Pessoa.repository;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
@RequiredArgsConstructor
@Log4j2
public class EnderecoInfraRepository implements  EnderecoRepository{

    private final EnderecoJPARepository repository;

    @Override
    public List<Endereco> listAddressToId (UUID personId) {
        log.info("[Inicia]EnderecoApplicationervice - listAddressToId");
        List<Endereco> addressList = repository.findAllByIdPerson(personId);
        log.info("[Finaliza]EnderecoApplicationervice - listAddressToId");
        return addressList;
    }

}
