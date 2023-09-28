package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import com.gerenciamento.pessoas.Pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
       // pessoaService.validaEndereco(new PessoaRequest(pessoa));
        pessoaRepository.save(person);
        log.info("[Finaliza]EnderecoApplicationervice - createNewAddress");
        return person.getAddress().stream().map(address -> new EnderecoResponse(address))
                .collect(Collectors.toList());
    }
}
