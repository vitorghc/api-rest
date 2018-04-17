package br.com.javaws.w.rest.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;




import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.javaws.ws.rest.entity.Usuario;
import br.com.javaws.ws.rest.repository.UsuarioRepository;

public class ServiceUsuarioTest {

	private UsuarioRepository repository;

	@Before
	public void setup() {
		repository = new UsuarioRepository();
	}

	@Test
	public void retornarPessoas() {
		List<Usuario> listaEntityPessoas = repository.getAllPeople();
		Assert.assertTrue(listaEntityPessoas.size() > 0);
	}

	@Test
	public void nãoDeveExcluirPessoasSemCodigo() {
		// cenario
		Integer code = null;

		// acao
		repository.excluir(code);

		Assert.assertThat(code, CoreMatchers.is("Código Vazio"));
	}

}

