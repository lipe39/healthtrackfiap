package br.com.fiap.heathtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.AguaBO;
import br.com.fiap.healthtrack.UsuarioBO;

public class AguaDAO implements IDataHandler<AguaBO>{
	
	public List<AguaBO> Getall(UsuarioBO usuarioBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<AguaBO> listC = new ArrayList<AguaBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_CONSUMO_AGUA where ID_USUARIO = ?");
			stmt.setInt(1, usuarioBO.getId());
			ResultSet result = null;
			// result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				AguaBO c = new AguaBO();
				c.setConsumoRegistro(result.getDouble("REGISTRO_CONSUMO"));
				c.setIdAgua(result.getInt("ID_CSM_AGUA"));
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
	public List<AguaBO> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<AguaBO> listC = new ArrayList<AguaBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_CONSUMO_AGUA");
			ResultSet result = null;
			// result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				AguaBO c = new AguaBO();
				c.setConsumoRegistro(result.getDouble("REGISTRO_CONSUMO"));
				c.setIdAgua(result.getInt("ID_CSM_AGUA"));
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
	public AguaBO GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_CONSUMO_AGUA WHERE ID_CSM_AGUA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);

			result.next();
			AguaBO c = new AguaBO();
			c.setConsumoRegistro(result.getInt("REGISTRO_CONSUMO"));
			c.setIdAgua(result.getInt("ID_CSM_AGUA"));

			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public int Add(AguaBO obj, UsuarioBO usuarioBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			//java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_CONSUMO_AGUA (ID_CSM_AGUA, REGISTRO_CONSUMO, ID_USUARIO) VALUES (SQ_REGISTRO_CONSUMO.NEXTVAL,?,?)");
			stmt.setDouble(1, obj.getConsumoRegistro());
			stmt.setInt(2, usuarioBO.getId());
			//stmt.setDate(2, data);

			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Add(AguaBO obj) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			//java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_CONSUMO_AGUA (ID_CSM_AGUA, REGISTRO_CONSUMO) VALUES (SQ_REGISTRO_CONSUMO.NEXTVAL,?)");
			stmt.setDouble(1, obj.getConsumoRegistro());
			//stmt.setDate(2, data);

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
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_CONSUMO_AGUA WHERE ID_CSM_AGUA = ?");
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
	public int Update(AguaBO obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_CONSUMO_AGUA SET T_CONSUMO_AGUA= ? WHERE ID_CSM_AGUA = ?");
			stmt.setDouble(1, obj.getConsumoRegistro());
			stmt.setInt(2, obj.getIdAgua());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}

