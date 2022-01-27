package br.com.fiap.heathtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.PesoBO;
import br.com.fiap.healthtrack.UsuarioBO;

public class PesoDAO implements IDataHandler<PesoBO> {

	public List<PesoBO> Getall(UsuarioBO usuarioBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<PesoBO> listC = new ArrayList<PesoBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_PESO_REG where ID_USUARIO = ? ");
			stmt.setInt(1, usuarioBO.getId());
			ResultSet result = null;
			result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				PesoBO c = new PesoBO();
				c.setValor_peso(result.getDouble("VALOR_PESO"));
				c.setId_Peso(result.getInt("ID_PESO"));
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
	public List<PesoBO> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<PesoBO> listC = new ArrayList<PesoBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_PESO_REG ");
			ResultSet result = null;
			result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				PesoBO c = new PesoBO();
				c.setValor_peso(result.getDouble("VALOR_PESO"));
				c.setId_Peso(result.getInt("ID_PESO"));
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
	public PesoBO GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_PESO_REG WHERE ID_PESO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);

			result.next();
			PesoBO c = new PesoBO();
			c.setValor_peso(result.getDouble("VALOR_PESO"));
			c.setId_Peso(result.getInt("ID_PESO"));

			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public int Add(PesoBO obj, UsuarioBO usuarioBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			// java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.GetConnection().prepareStatement(
					"INSERT INTO T_PESO_REG (ID_PESO, VALOR_PESO, ID_USUARIO) VALUES (SQ_PESO_VALOR.NEXTVAL,?,?)");
			stmt.setDouble(1, obj.getValor_peso());
			// stmt.setDate(2, data);
			stmt.setInt(2, usuarioBO.getId());

			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Add(PesoBO obj) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			// java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_PESO_REG (ID_PESO, VALOR_PESO) VALUES (SQ_PESO_VALOR.NEXTVAL,?)");
			stmt.setDouble(1, obj.getValor_peso());
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
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_PESO_REG WHERE ID_PESO = ?");
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
	public int Update(PesoBO obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_PESO_REG SET T_PESO_REG= ? WHERE ID_PESO = ?");
			stmt.setDouble(1, obj.getValor_peso());
			stmt.setInt(2, obj.getIdPeso());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
