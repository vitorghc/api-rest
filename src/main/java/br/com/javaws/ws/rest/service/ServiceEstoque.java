package br.com.javaws.ws.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.javaws.ws.rest.entity.Estoque;
import br.com.javaws.ws.rest.repository.EstoqueRepository;

@Path("/serviceEstoque")
public class ServiceEstoque {

	private final EstoqueRepository repository = new EstoqueRepository();

	/**
	 * Cadastrar produto no estoque se tiver bebida alcoolica no estoque com
	 * capacidade de 500 items estoque, não entra bebida nãó alcoolica e
	 * vice-versa
	 * 
	 **/
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/cadastrar")
	public Response cadastrar(Estoque estoque) {

		Estoque entity = new Estoque();

		try {

			entity.setLabel(estoque.getLabel());
			entity.setDescription(estoque.getDescription());
			entity.setAlcoolic(estoque.isAlcoolic());

			List<Estoque> qtdEstoque = repository.getAllItens();
			if (qtdEstoque.size() < 10) {
				if (estoque.isAlcoolic() && repository.getIsAlcoolicItens()
						|| !estoque.isAlcoolic()
						&& !repository.getIsAlcoolicItens()) {
					repository.salvar(entity);
					return Response.ok(
							"Registro cadastrado com sucesso" + "Item: "
									+ estoque.getDescription()).build();
				} else {
					return Response
							.status(Status.BAD_REQUEST)
							.entity("Armazém pode contér somente um tipo de bebida Alcoolica/Não Alcoolica")
							.build();
				}
			} else {
				return Response.status(Status.BAD_REQUEST)
						.entity("Armzém está cheio").build();
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Excluindo um item pelo código
	 * */
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/excluir/{id}")
	public Response excluir(@PathParam("codigo") Integer id) {

		try {

			repository.excluir(id);

			return Response
					.ok("Registro excluido com sucesso! " + "Código do item: "
							+ id).build();

		} catch (Exception e) {

			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	/**
	 * Esse método lista todos os items cadastradas na base
	 * */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/todosItens")
	public List<Estoque> todosItens() {

		List<Estoque> estoque = new ArrayList<Estoque>();

		List<Estoque> listaEntityEstoque = repository.getAllItens();

		for (Estoque entity : listaEntityEstoque) {

			estoque.add(new Estoque(entity.getId(), entity.getLabel(), entity
					.getDescription(), entity.isAlcoolic()));
		}

		return estoque;
	}

}
