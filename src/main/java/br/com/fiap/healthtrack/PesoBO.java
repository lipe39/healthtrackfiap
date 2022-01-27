package br.com.fiap.healthtrack;

import java.util.List;

import br.com.fiap.heathtrack.DAO.PesoDAO;

public class PesoBO {

	private double valor_peso;
	private double data_registro;
	private int idPeso;

	public double getValor_peso() {
		return valor_peso;
	}

	public void setValor_peso(double valor_peso) {
		this.valor_peso = valor_peso;
	}

	public double getData_registro() {
		return data_registro;
	}

	public void setData_registro(double data_registro) {
		this.data_registro = data_registro;
	}

	public void setId_Peso(int idPeso) {
		// TODO Auto-generated method stub
		this.idPeso = idPeso;

	}

	public int getIdPeso() {
		// TODO Auto-generated method stub
		return idPeso;
	}

	public List<PesoBO> ListarPesos() {

		PesoDAO cDao = new PesoDAO();
		return cDao.Getall();
	}
	
	public List<PesoBO> ListarPesos(UsuarioBO usuarioBO) {

		PesoDAO cDao = new PesoDAO();
		return cDao.Getall(usuarioBO);
	}

	public int DeleteValor(int id) {
		PesoDAO cDao = new PesoDAO();
		return cDao.Delete(id);
	}

	@Override
	public String toString() {
		return "PesoBO [valor_peso=" + valor_peso + ", data_registro=" + data_registro + ", idPeso=" + idPeso
				+ ", getValor_peso()=" + getValor_peso() + ", getData_registro()=" + getData_registro()
				+ ", getIdPeso()=" + getIdPeso() + ", ListarPesos()=" + ListarPesos() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void cadastrar() {
		PesoDAO pesoDAO = new PesoDAO();
		pesoDAO.Add(this);
	}
	
	public void cadastrar(UsuarioBO usuarioBO) {
		PesoDAO pesoDAO = new PesoDAO();
		pesoDAO.Add(this, usuarioBO);
	}

}
