package br.com.fiap.healthtrack;
import java.util.List;

import br.com.fiap.heathtrack.DAO.AguaDAO;
public class AguaBO {

	private int idAgua;
	private double consumoRegistro;
	
	
	public int getIdAgua() {
		return idAgua;
	}


	public void setIdAgua(int idAgua) {
		this.idAgua = idAgua;
	}


	public double getConsumoRegistro() {
		return consumoRegistro;
	}


	public void setConsumoRegistro(double consumoRegistro) {
		this.consumoRegistro = consumoRegistro;
	}

	public List<AguaBO> ListarAgua() {

		AguaDAO cDao = new AguaDAO();
		return cDao.Getall();
	}
	
	public List<AguaBO> ListarAgua(UsuarioBO usuarioBO) {

		AguaDAO cDao = new AguaDAO();
		return cDao.Getall(usuarioBO);
	}

	public int DeleteValor(int id) {
		AguaDAO cDao = new AguaDAO();
		return cDao.Delete(id);
	}
	
	public void cadastrar() {
		AguaDAO aguaDAO = new AguaDAO();
		aguaDAO.Add(this);
	}
	
	public void cadastrar(UsuarioBO usuarioBO) {
		AguaDAO aguaDAO = new AguaDAO();
		aguaDAO.Add(this, usuarioBO);
	}

	@Override
	public String toString() {
		return "AguaBO [idAgua=" + idAgua + ", consumoRegistro=" + consumoRegistro + "]";
	}
}
