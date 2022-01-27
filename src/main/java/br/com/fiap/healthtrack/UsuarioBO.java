package br.com.fiap.healthtrack;

import br.com.fiap.heathtrack.DAO.UsuarioDAO;

public class UsuarioBO {

	private int id;

	private String login;
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void autenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.autenticar(this);
	}

}
