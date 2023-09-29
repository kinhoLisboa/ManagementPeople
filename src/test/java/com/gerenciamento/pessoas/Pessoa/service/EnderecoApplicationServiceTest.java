package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.endereco.EnderecoResponse;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import com.gerenciamento.pessoas.Pessoa.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EnderecoApplicationServiceTest {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoApplicationService enderecoApplicationService;
    @MockBean
    private PessoaRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verificaSeEstaCadastrandoNovoEndereco() {

        UUID personId = UUID.randomUUID();
        EnderecoRequest request = new EnderecoRequest();
        Pessoa pessoa = new Pessoa();

        when(repository.idQuest(personId)).thenReturn(pessoa);
        List<EnderecoResponse> result = enderecoApplicationService.createNewAddress(personId, request);

        verify(repository, times(1)).save(any(Pessoa.class));

    }
    @Test
    public void verificaSenaoEstaCriandoNovoEndereco(){

        UUID personId = UUID.randomUUID();
        EnderecoRequest enderecoRequest = new EnderecoRequest();
        Pessoa person = new Pessoa();
        when(repository.idQuest(personId)).thenThrow(new UnsupportedOperationException("Não suportado"));

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            List<EnderecoResponse> result = enderecoApplicationService.createNewAddress(personId, enderecoRequest);
        });

        verify(repository, never()).save(any(Pessoa.class));
    }
    @Test
    public void testListAddressToId() {

        UUID personId = UUID.randomUUID();
        Pessoa person = new Pessoa();
        List<Endereco> expectedAddressList = new ArrayList<>();
        expectedAddressList.add( new Endereco());
        person.setAddress(expectedAddressList);



        when(repository.idQuest(personId)).thenReturn(person);
        List<EnderecoResponse> result = enderecoApplicationService.listAddressToId(personId);

        verify(repository).idQuest(personId);
        assertEquals(expectedAddressList.size(), result.size());

    }
    @Test
    public void testListAddressToIdWhenPersonNotFound() {

        UUID personId = UUID.randomUUID();

        when(repository.idQuest(personId)).thenReturn(null);

        List<EnderecoResponse> result = enderecoApplicationService.listAddressToId(personId);

        verify(repository).idQuest(personId);
        assertTrue(result.isEmpty());
    }




}