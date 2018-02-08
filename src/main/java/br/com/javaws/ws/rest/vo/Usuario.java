package br.com.javaws.ws.rest.vo;

public class Usuario {

	private String nome;
	private String password;
	private boolean usuarioValido;
	

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

	public boolean isUsuarioValido() {
		return usuarioValido;
	}

	public void setUsuarioValido(boolean usuarioValido) {
		this.usuarioValido = usuarioValido;
	}

}
