package com.gerenciamento.pessoas.Pessoa.controller;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Dto.pessoa.*;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/pessoa")
@RestController
public interface Controller {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse create(@Valid @RequestBody PessoaRequest request);

    @GetMapping
    List<ListPessoaResponse> getEveryone();

    @GetMapping("/{id}")
    PessoaDetalhadaResponse detail(@PathVariable UUID id);

    @PatchMapping("/{pessoaId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alter(@Valid @RequestBody PessoaAlteraRequest pessoaAlteraRequest, @PathVariable UUID pessoaId);

    @DeleteMapping("/{pessoaId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletar(@PathVariable UUID idPessoa);

    @PostMapping("/endereco/{personId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    List<EnderecoResponse> createAddress(@PathVariable UUID personId,@Valid @RequestBody  EnderecoRequest request);
    @GetMapping("/endereco/{personId}")
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoResponse> listAddressToId(@PathVariable UUID personId);
    @GetMapping("/endereco/{personId}/Principal")
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoResponse> getAddressPrimary(@PathVariable UUID personId);

}
