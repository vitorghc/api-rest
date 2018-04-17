package br.com.javaws.w.rest.service;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.javaws.ws.rest.entity.Estoque;
import br.com.javaws.ws.rest.entity.Usuario;
import br.com.javaws.ws.rest.repository.EstoqueRepository;

public class ServiceEstoqueTest {

		private EstoqueRepository repository;

		@Before
		public void setup() {
			repository = new EstoqueRepository();
		}

		@Test
		public void retornarPessoas() {
			List<Estoque> listaEntityEstoque = repository.getAllItens();
			Assert.assertTrue(listaEntityEstoque.size() > 0);
		}

		@Test
		public void nãoDeveExcluirEstoqueSemCodigo() throws NullPointerException {
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

	}
