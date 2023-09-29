package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Dto.pessoa.PessoaRequest;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import com.gerenciamento.pessoas.Pessoa.dominio.TipoEndereco;
import com.gerenciamento.pessoas.Pessoa.repository.PessoaRepository;
import com.gerenciamento.pessoas.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Log4j2
public class EnderecoApplicationService implements  EnderecoService{

    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;
    @Override
    public List<EnderecoResponse> createNewAddress(UUID personId, EnderecoRequest request) {
        log.info("[Inicia]EnderecoApplicationervice - createNewAddress");
        Pessoa person = pessoaRepository.idQuest(personId);
        person.getAddress().add(new Endereco( personId ,request));
        pessoaService.validatesAddress(new PessoaRequest(person));
        pessoaRepository.save(person);
        log.info("[Finaliza]EnderecoApplicationervice - createNewAddress");
        return person.getAddress().stream().map(address -> new EnderecoResponse(address))
                .collect(Collectors.toList());
    }

    @Override
    public List<EnderecoResponse> listAddressToId(UUID personId) {
        log.info("[Inicia]EnderecoApplicationervice - listAddressToId");
        Pessoa person = pessoaRepository.idQuest(personId);
        List<Endereco> list = person.getAddress();
        log.info("[Finaliza]EnderecoApplicationervice - listAddressToId");
        return EnderecoResponse.parseToList(list);
    }

    @Override
    public List<EnderecoResponse> getPrimaryAddress(UUID personId) {
        log.info("[Inicia]EnderecoApplicationervice - getPrincipleAddress");
        Pessoa person = pessoaRepository.idQuest(personId);
        List<Endereco> addressPerson = person.getAddress()
                .stream()
                .filter(address -> address.getType()== TipoEndereco.PRINCIPAL)
                .collect(Collectors.toList());
        if(addressPerson.isEmpty()){
            throw APIException.build(HttpStatus.NOT_FOUND, "Não ha endereço principal registrado");
        }
        log.info("[Finaliza]EnderecoApplicationervice - getPrincipleAddress");
        return EnderecoResponse.parseToList(addressPerson);
    }




}
