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

import br.com.javaws.ws.rest.entity.Usuario;
import br.com.javaws.ws.rest.http.UsuarioResponse;
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
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/cadastrar")
	public String cadastrar(UsuarioResponse usuario) {

		Usuario entity = new Usuario();

		try {

			entity.setNome(usuario.getNome());
			entity.setPassword(usuario.getPassword());

			repository.salvar(entity);

			return "Registro cadastrado com sucesso";
		} catch (Exception e) {
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	
	/**
	 * Esse método lista todas pessoas cadastradas na base
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasPessoas")
	public List<UsuarioResponse> todasPessoas(){
 
		List<UsuarioResponse> pessoas =  new ArrayList<UsuarioResponse>();
 
		List<Usuario> listaEntityPessoas = repository.TodasPessoas();
 
		for (Usuario entity : listaEntityPessoas) {
 
			pessoas.add(new UsuarioResponse(entity.getCodigo(), entity.getNome(),entity.getPassword()));
		}
 
		return pessoas;
	}
	
	
	/**
	 * Excluindo uma pessoa pelo código
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")	
	public String excluir(@PathParam("codigo") Integer codigo){
 
		try {
 
			repository.excluir(codigo);
 
			return "Registro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o registro! " + e.getMessage();
		}
 
	}
 

}
