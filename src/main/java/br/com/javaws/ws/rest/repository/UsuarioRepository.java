package br.com.javaws.ws.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.javaws.ws.rest.entity.Usuario;

public class UsuarioRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public UsuarioRepository() {

		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("minha-persistence-unit");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	// CRIANDO NOVO REGISTRO NO BANCO
	public void salvar(Usuario usuario) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(usuario);
		this.entityManager.getTransaction().commit();
	}

	// ALTERANDO UM REGISTRO EXISTENTE
	public void alterar(Usuario usuario) {

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuario);
		this.entityManager.getTransaction().commit();
	}

	// RETORNA TODAS AS PESSOAS CADASTRADAS NO BANCO DE DADOS
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllPeople() {
	
		return this.entityManager.createQuery(
				"SELECT u FROM Usuario u ORDER BY u.nome").getResultList();
	}

	// CONSULTA UMA PESSOA CADASTRA PELO CÓDIGO
	public Usuario GetPessoa(Integer codigo) {

		return this.entityManager.find(Usuario.class, codigo);
	}

	public void excluir(Integer codigo) {
		if (codigo != null) {
			Usuario usuario = this.GetPessoa(codigo);

			this.entityManager.getTransaction().begin();
			this.entityManager.remove(usuario);
			this.entityManager.getTransaction().commit();
		}
		throw new NullPointerException("Código Vazio");

	}

}
