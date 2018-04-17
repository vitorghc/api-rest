package br.com.javaws.w.rest.service;

import java.util.List;

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
	public void nãoDeveExcluirPessoasSemCodigo() throws NullPointerException {
		// cenario
		Integer code = null;

		// acao
		try {
			repository.excluir(code);
			Assert.fail();
		} catch (NullPointerException e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Código Vazio"));
		}

	}

	@Test
	public void cadastroUsuario() throws NullPointerException{
		// cenario
		Usuario usu = new Usuario(1, "Vitor", "123");

		try {
			//acao
			repository.salvar(usu);
			Assert.fail();			
		} catch (Exception e) {
			// verificacao
			Assert.assertTrue(usu != null);
		}
		
	}

}
