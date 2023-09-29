package com.gerenciamento.pessoas.Pessoa.service;

import com.gerenciamento.pessoas.Dto.endereco.EnderecoRequest;
import com.gerenciamento.pessoas.Dto.pessoa.*;
import com.gerenciamento.pessoas.Pessoa.dominio.Endereco;
import com.gerenciamento.pessoas.Pessoa.dominio.Pessoa;
import com.gerenciamento.pessoas.Pessoa.dominio.TipoEndereco;
import com.gerenciamento.pessoas.Pessoa.repository.PessoaRepository;
import com.gerenciamento.pessoas.handler.APIException;
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
class PessoaApplicationServiceTest {

    @Autowired
    private PessoaApplicationService service;
    @MockBean
    private PessoaRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verificaSeEstaCadastrando() {

        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        PessoaRequest request = new PessoaRequest();
        Pessoa pessoa = new Pessoa();

        request.setId(UUID.randomUUID());
        request.setAddress(endereco);

        when(repository.save(any(Pessoa.class))).thenReturn(pessoa);
        PessoaResponse responseResultado = service.register(request);

        verify(repository, times(1)).save(any(Pessoa.class));
        assertNotNull(responseResultado);
    }

    @Test
    public void testCadastra_Falha() {

        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        PessoaRequest request = new PessoaRequest();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(UUID.randomUUID());
        request.setId(pessoa.getId());
        request.setAddress(endereco);

        when(repository.save(any(Pessoa.class))).thenThrow(new UnsupportedOperationException("Não suportado"));

        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            service.register(request);
        });
        assertEquals("Não suportado", exception.getMessage());
        verify(repository, times(1)).save(any(Pessoa.class));
    }

    @Test
    public void verificarSeEstaListando() {

        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(new Pessoa());

        when(repository.getList()).thenReturn(pessoaList);
        List<ListPessoaResponse> responseList = service.list();

        assertEquals(1, responseList.size());
        verify(repository, times(1)).getList();

    }

    @Test
    public void verificarSeEstaListando_Falha() {

        List<Pessoa> pessoaList = new ArrayList<>();
        when(repository.getList()).thenReturn(pessoaList);
        List<ListPessoaResponse> responseList = service.list();

        assertTrue(responseList.isEmpty());
        verify(repository, times(1)).getList();
    }

    @Test
    public void vericifaSeEstaDetalhando() {

        UUID uuid = UUID.randomUUID();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(uuid);

        when(repository.idQuest(uuid)).thenReturn(pessoa);
        PessoaDetalhadaResponse response = service.quest(uuid);

        assertEquals(uuid, response.getId());
        verify(repository, times(1)).idQuest(uuid);
    }

    @Test
    public void vericifaSeNaoEstaDetalhando() {

        UUID uuid = UUID.randomUUID();

        when(repository.getList()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            service.quest(uuid);
        });

        verify(repository, times(1)).idQuest(uuid);
    }

    @Test
    public void verificarSeEstaAtualizando() {

        UUID uuid = UUID.randomUUID();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(uuid);
        PessoaAlteraRequest request = new PessoaAlteraRequest("kinho", "24/02/1994", pessoa.getAddress());

        when(repository.idQuest(uuid)).thenReturn(pessoa);
        service.update(request, uuid);

        assertEquals(uuid, pessoa.getId());
        assertEquals("kinho", pessoa.getName());
        assertEquals("24/02/1994", pessoa.getDateOfBirth());
        assertEquals(request.getAddress(), pessoa.getAddress());
        verify(repository, times(1)).idQuest(uuid);
    }

    @Test
    public void verificarSeNaoEstaAtualizando() {

        UUID uuid = UUID.randomUUID();
        Pessoa pessoa = new Pessoa();
        PessoaAlteraRequest request = new PessoaAlteraRequest("kinho", "24/02/1994", pessoa.getAddress());

        when(repository.idQuest(uuid)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            service.update(request, uuid);
        });
        verify(repository, times(1)).idQuest(uuid);
    }

    @Test
    public void verificaSeEstaExcluindo() {

        UUID uuid = UUID.randomUUID();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(uuid);

        when(repository.idQuest(uuid)).thenReturn(pessoa);
        service.delete(uuid);

        verify(repository, times(1)).idQuest(uuid);
        verify(repository, times(1)).idQuest(uuid);
    }

    @Test
    public void verificaSeNaoEstaExcluindo() {

        UUID uuid = UUID.randomUUID();

        when(repository.idQuest(uuid)).thenReturn(null);
        service.delete(uuid);

        verify(repository, times(1)).idQuest(uuid);
        verify(repository, never()).deleteId(any(Pessoa.class));
    }

    @Test
    public void verificaSeEstaValidandoComUmEnderecoPrincipal() {

        PessoaRequest request = new PessoaRequest();
        List<Endereco> listEndereco = new ArrayList<>();
        EnderecoRequest enderecoRequest = new EnderecoRequest("rua", "cep", "numero", "cidade", TipoEndereco.PRINCIPAL);

        listEndereco.add(new Endereco(enderecoRequest));
        request.setAddress(listEndereco);

        assertDoesNotThrow(() -> {
            service.validatesAddress(request);
        });
    }

    @Test
    public void verificaSeEstaRetornandoExceptionPassandoMaisDeUmEnderecoPrincipal() {

        PessoaRequest request = new PessoaRequest();
        List<Endereco> listEndereco = new ArrayList<>();
        EnderecoRequest enderecoRequest = new EnderecoRequest("rua1", "cep1", "numero1", "cidade1",
                TipoEndereco.PRINCIPAL);
        EnderecoRequest enderecoRequest1 = new EnderecoRequest("rua2", "cep2", "numero2", "cidade2",
                TipoEndereco.PRINCIPAL);

        listEndereco.add(new Endereco(enderecoRequest));
        listEndereco.add(new Endereco(enderecoRequest1));
        request.setAddress(listEndereco);

        assertThrows(APIException.class, () -> {
            service.validatesAddress(request);
        });
    }

}