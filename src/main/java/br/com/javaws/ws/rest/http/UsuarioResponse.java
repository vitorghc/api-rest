package br.com.javaws.ws.rest.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioResponse {

	private int codigo;
	private String nome;
	private String password;

	public UsuarioResponse() {
	}

	public UsuarioResponse(int codigo, String nome, String password) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.password = password;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
