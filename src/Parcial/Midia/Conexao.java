package Parcial.Midia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection conexao;
    //local do meu BD
    private final String URL = "jdbc:mysql://localhost:3306/bd2?useTimezone=true&serverTimezone=UTC";
    
    private final String USER = "root";
    private final String PASSWORD = "heroi10";
    private final String TP_CONEXAO = "com.mysql.cj.jdbc.Driver";
    
    
    public Connection abrirConexao(){
        try{
            Class.forName(TP_CONEXAO);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Started Connection");
        } catch (ClassNotFoundException ex){;
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return conexao;   
    }
    
    public void fechaConexao(){
        if(conexao != null){
        try {
            this.conexao.close();
            System.out.println("Closed Connection");
        }catch (SQLException e){
            e.printStackTrace();
            }
        }
    }

}
