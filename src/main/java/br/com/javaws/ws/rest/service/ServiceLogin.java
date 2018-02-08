package br.com.javaws.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.javaws.ws.rest.vo.Usuario;

@Path("/teste")
public class ServiceLogin {

	@POST
	@Path("/usuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario validaUsuario(Usuario usu) {
		usu.setUsuarioValido(false);
		if (usu.getNome().equals("java") && usu.getPassword().equals("java")) {
			usu.setUsuarioValido(true);
		}
		return usu;
	}

}
