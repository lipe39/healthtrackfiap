package br.com.fiap.heathtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.UsuarioBO;

public class UsuarioDAO implements IDataHandler<UsuarioBO> {

	public boolean autenticar(UsuarioBO usuarioBO) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_USUARIO0 WHERE LOGIN = ? and SENHA = ?");
			stmt.setString(1, usuarioBO.getLogin());
			stmt.setString(2, usuarioBO.getSenha());
			ResultSet result = null;
			result = dao.GetData(stmt);

			if (result.next()) {

				usuarioBO.setId(result.getInt("ID_USUARIO"));

				return true;
			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UsuarioBO> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<UsuarioBO> listC = new ArrayList<UsuarioBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_USUARIO0");
			ResultSet result = null;
			// result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				UsuarioBO c = new UsuarioBO();
				c.setId(result.getInt("id"));

				listC.add(c);
			}
			return listC;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UsuarioBO GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_USUARIO0 WHERE ID_USUARIO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);

			result.next();
			UsuarioBO c = new UsuarioBO();
			c.setId(result.getInt("ID"));

			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Add(UsuarioBO obj) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			// java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			// FALTA CRIAR A SEQUENCIA DO ID_USUARIO
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_USUARIO0 (ID_USUARIO) VALUES (SQ_PESO_VALOR.NEXTVAL)");
			stmt.setInt(1, (int) obj.getId());
			// stmt.setDate(2, data);

			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Delete(int id) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("DELETE FROM T_USUARIO0 WHERE ID_USUARIO = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(UsuarioBO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * @Override public int Update(UsuarioBO obj) { try { DAO dao = new DAO();
	 * PreparedStatement stmt = dao.GetConnection()
	 * .prepareStatement("UPDATE T_PESO_REG SET T_PESO_REG= ? WHERE ID_PESO = ?");
	 * stmt.setInt(1, (int) obj.getValor_peso()); stmt.setInt(2, obj.getIdPeso());
	 * return dao.ExecuteCommand(stmt); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } // TODO Auto-generated
	 * method stub return 0; }
	 * 
	 */
}
