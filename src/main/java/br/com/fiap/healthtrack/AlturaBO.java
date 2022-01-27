package br.com.fiap.healthtrack;

import java.util.List;
import br.com.fiap.heathtrack.DAO.AlturaDAO;

public class AlturaBO {
	private int idAltura;
	private double vlr_altura;

	public int getIdAltura() {
		return idAltura;
	}

	public void setIdAltura(int idAltura) {
		this.idAltura = idAltura;
	}

	public double getVlr_altura() {
		return vlr_altura;
	}

	public void setVlr_altura(double vlr_altura) {
		this.vlr_altura = vlr_altura;
	}

	public List<AlturaBO> ListarAltura() {

		AlturaDAO cDao = new AlturaDAO();
		return cDao.Getall();
	}
	
	public List<AlturaBO> ListarAltura(UsuarioBO usuarioBO) {

		AlturaDAO cDao = new AlturaDAO();
		return cDao.Getall(usuarioBO);
	}

	public int DeleteAltura(int id) {
		AlturaDAO cDao = new AlturaDAO();
		return cDao.Delete(id);
	}

	public void cadastrarAltura() {
		AlturaDAO alturaDAO = new AlturaDAO();
		alturaDAO.Add(this);
	}
	
	public void cadastrarAltura(UsuarioBO usuarioBO) {
		AlturaDAO alturaDAO = new AlturaDAO();
		alturaDAO.Add(this, usuarioBO);
	}

	@Override
	public String toString() {
		return "AlturaBO [idAltura=" + idAltura + ", vlr_altura=" + vlr_altura + ", getIdAltura()=" + getIdAltura()
				+ ", getVlr_altura()=" + getVlr_altura() + ", ListarAltura()=" + ListarAltura() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
