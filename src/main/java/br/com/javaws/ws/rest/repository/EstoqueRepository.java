package br.com.javaws.ws.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.javaws.ws.rest.entity.Estoque;
import br.com.javaws.ws.rest.entity.Usuario;

public class EstoqueRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public EstoqueRepository() {

		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("minha-persistence-unit");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	// salva itens no estoque
	public void salvar(Estoque estoque) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(estoque);
		this.entityManager.getTransaction().commit();
	}

	// altera os dados do estoque
	public void alterar(Estoque estoque) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(estoque);
		this.entityManager.getTransaction().commit();
	}

	// consulta um item cadastrado pelo codigo
	public Estoque getItem(Integer codigo) {
		return this.entityManager.find(Estoque.class, codigo);
	}

	// exclui um item do estoque
	public void excluir(Integer codigo) {
		Estoque estoque = this.getItem(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(estoque);
		this.entityManager.getTransaction().commit();
	}
	
	//Retorna todos os itens do estoque
		@SuppressWarnings("unchecked")
		public List<Estoque> getAllItens(){
	 
			return this.entityManager.createQuery("SELECT u FROM Estoque u ORDER BY u.label").getResultList();
		}
		
}
