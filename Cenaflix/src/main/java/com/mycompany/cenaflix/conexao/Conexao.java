package com.mycompany.cenaflix.conexao;

//Pacotes Swing
import javax.swing.JOptionPane;
//Pacotes SQL
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
    
    private final String url = "jdbc:mysql://localhost:3306/cenaflix";
    private final String user = "mestre";
    private final String password = "mudar@123";
    private Connection conexao;
    
    public Conexao(){}
    
    public Connection getConexao(){
        try{
            this.conexao = DriverManager.getConnection(this.url, this.user, this.password);
            return this.conexao;
        }catch(SQLException erroAoConectarAoBanco){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. Erro: " + erroAoConectarAoBanco.getMessage());
            return null;
        }
    }
    
}
