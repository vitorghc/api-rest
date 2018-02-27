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

import br.com.javaws.ws.rest.entity.Usuario;
import br.com.javaws.ws.rest.repository.UsuarioRepository;

@Path("/serviceUsuario")
public class ServiceUsuario {

	private final UsuarioRepository repository = new UsuarioRepository();

	/**
	 * @param usuario
	 * @return String
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/cadastrar")
	public Response cadastrar(Usuario usuario) {

		Usuario entity = new Usuario();

		try {

			entity.setNome(usuario.getNome());
			entity.setPassword(usuario.getPassword());

			repository.salvar(entity);

			return Response.ok("Registro cadastrado com sucesso" + "usuario: " + usuario.getNome()).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Esse método lista todas pessoas cadastradas na base
	 * */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/todasPessoas")
	public List<Usuario> todasPessoas() {

		List<Usuario> pessoas = new ArrayList<Usuario>();

		List<Usuario> listaEntityPessoas = repository.getAllPeople();

		for (Usuario entity : listaEntityPessoas) {

			pessoas.add(new Usuario(entity.getCodigo(), entity.getNome(),
					entity.getPassword()));
		}

		return pessoas;
	}

	/**
	 * Excluindo uma pessoa pelo código
	 * */
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/excluir/{codigo}")
	public Response excluir(@PathParam("codigo") Integer codigo) {

		try {

			repository.excluir(codigo);

			return Response.ok("Registro excluido com sucesso! " + "Código do usuario: " + codigo).build();

		} catch (Exception e) {

			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

}
