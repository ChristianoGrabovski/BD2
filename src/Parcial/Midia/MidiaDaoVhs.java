package Parcial.Midia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MidiaDaoVhs implements lDao <Midia>{

	private Connection connection;

	public MidiaDaoVhs( Connection connection) {
		this.connection = connection;
	}

	@Override
	public void saveVhs(Vhs v) {
		String SQL = "insert into Vhs(idv,tipo)" + "values (?,?)";
		
			try {
				PreparedStatement pstmt = this.connection.prepareCall(SQL);
				pstmt.setInt(1, v.getId());
				pstmt.setString(2, v.getTipo());
				
				
				pstmt.execute(); //vai executar o SQL;
				System.out.println("Vhs Inserido com sucesso!!!");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public Midia getOne(int id) {
		Midia m = null;
		
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("Select * From Vhs" + "Where idv =" + id);
			while (elements.next()) {}
			m = new Midia(id, "Tipo");
			
			m.setId(elements.getInt(id));
			m.setTipo(elements.getString("Tipo"));
		}catch (SQLException ex) {
			ex.printStackTrace();			
		}		
		return m;
		
	}

	@Override
	public List<Midia> list() {
		Midia m = null;
		List<Midia> Midia = new ArrayList<Midia>();
		
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("Select * From Vhs");
			while (elements.next()) {}
			m = new Midia(0, "Tipo");
			
			m.setId(elements.getInt("idv"));
			m.setTipo(elements.getString("Tipo"));
			Midia.add(m);
			
		}catch (SQLException ex) {
			ex.printStackTrace();			
		}		
		return Midia;
	}

	@Override
	public void update(Midia t) {
		 String SQL = "Update Midia set Idv=?,Tipo=?";
		 
		 try {
			 PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			 pstmt.setInt(1, t.getId());
			 pstmt.setString(2, t.getTipo());
			 pstmt.setInt(3, t.getId());
			 
			 pstmt.execute(); //Executa o SQL
			 System.out.println("Vhs Atuaizado Com Sucesso!!!");
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		
	}

	@Override
	public void delete(int id) {
		
		String SQL = "Delete From Vhs Where Idv =?";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			
			pstmt.setInt(1, id);			
			pstmt.execute();
			System.out.println("Vhs deletado com Sucesso!!!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(Midia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCd(Cd c) {
		// TODO Auto-generated method stub
		
	}

	

}
