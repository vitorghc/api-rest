package br.com.javaws.ws.rest.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import br.com.javaws.ws.rest.vo.Usuario;

public class RestCliente {

	public static void main(String[] args){
		Usuario usu = new Usuario();
		usu.setNome("Vitor");
		usu.setPassword("Vitor");
		usu.setUsuarioValido(false);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/RestJR/services/teste/validaUsuario");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, usu);
		usu = response.getEntity(Usuario.class);
		System.out.println("######## Response: [Usuário " + usu.getNome() + "]");
		System.out.println("######## Response: [User is valid: " + usu.isUsuarioValido() + "]");

	}
}
