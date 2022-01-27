package br.com.fiap.heathtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.AlturaBO;
import br.com.fiap.healthtrack.UsuarioBO;

public class AlturaDAO implements IDataHandler<AlturaBO>{
	
	public List<AlturaBO> Getall(UsuarioBO usuarioBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<AlturaBO> listC = new ArrayList<AlturaBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ALTURA_REG where ID_USUARIO = ?");
			stmt.setInt(1, usuarioBO.getId());
			ResultSet result = null;
			// result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				AlturaBO c = new AlturaBO();
				c.setVlr_altura(result.getDouble("VLR_ALTURA"));
				c.setIdAltura(result.getInt("ID_ALTURA"));
				listC.add(c);
			}
			return listC;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public List<AlturaBO> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<AlturaBO> listC = new ArrayList<AlturaBO>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ALTURA_REG");
			ResultSet result = null;
			// result = stmt.executeQuery();
			result = dao.GetData(stmt);
			while (result.next()) {
				AlturaBO c = new AlturaBO();
				c.setVlr_altura(result.getDouble("VLR_ALTURA"));
				c.setIdAltura(result.getInt("ID_ALTURA"));
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
	public AlturaBO GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ALTURA_REG WHERE ID_ALTURA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);

			result.next();
			AlturaBO c = new AlturaBO();
			c.setVlr_altura(result.getDouble("VLR_ALTURA"));
			c.setIdAltura(result.getInt("ID_ALTURA"));

			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public int Add(AlturaBO alturaBO, UsuarioBO usuarioBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			//java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_ALTURA_REG (ID_ALTURA, VLR_ALTURA, ID_USUARIO) VALUES (SQ_ALTURA.NEXTVAL,?,?)");
			stmt.setDouble(1, alturaBO.getVlr_altura());
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
	public int Add(AlturaBO alturaBO) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			//java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_ALTURA_REG (ID_ALTURA, VLR_ALTURA) VALUES (SQ_ALTURA.NEXTVAL,?)");
			stmt.setDouble(1, alturaBO.getVlr_altura());
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
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_ALTURA_REG WHERE ID_ALTURA = ?");
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
	public int Update(AlturaBO obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_ALTURA_REG SET T_ALTURA_REG= ? WHERE ID_ALTURA = ?");
			stmt.setDouble(1, obj.getVlr_altura());
			stmt.setInt(2, obj.getIdAltura());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
