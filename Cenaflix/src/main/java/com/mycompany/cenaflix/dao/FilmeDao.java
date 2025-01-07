package com.mycompany.cenaflix.dao;

//Pacotes do Projeto
import com.mycompany.cenaflix.modelos.ParaFilmeRecord;
import com.mycompany.cenaflix.conexao.Conexao;
//Pacotes Swing
import javax.swing.JOptionPane;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
//Pacotes Time
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;


public class FilmeDao {
    
    private final String insertFilme = "INSERT INTO filmes(nome, datalancamento, categoria) "
            + "VALUES(?,?,?)";
    private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private PreparedStatement stmt;
    private ParaFilmeRecord parametroFilme;
    private Connection conexao;
    private LocalDate dataLancamento;

    public FilmeDao(ParaFilmeRecord parametroFilme) {
        this.parametroFilme = parametroFilme;
    }
    
    public void inserirFilme(){
        try{
            this.setStmt(insertFilme);
            this.setStringSql();
            this.stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Filme adicionado com sucesso");
            this.fecharConexao();
        }catch(SQLException erroAoInserirFilme){
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o valor.");
            System.out.println("*****ERRO*****");
            System.out.println(erroAoInserirFilme.getMessage());
        }
    }
    
    private void setStringSql(){
        try{
            this.dataLancamento = LocalDate.parse(this.parametroFilme.getTxtDataLancamento().getText(), formatoData);
            this.stmt.setString(1, this.parametroFilme.getTxtNome().getText());
            this.stmt.setDate(2, Date.valueOf(dataLancamento));
            this.stmt.setString(3, this.parametroFilme.getTxtGenero().getText());
        }catch(SQLException | DateTimeParseException erroAoConfigurarStringSql){
            System.out.println("*****ERRO*****");
            System.out.println(erroAoConfigurarStringSql.getMessage());
        }
    }
    
    private void setStmt(String sql){
        try{
            this.conexao = new Conexao().getConexao();
            this.stmt = this.conexao.prepareStatement(sql);
        }catch(SQLException erroAoCriarQuery){
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o valor. Erro: " + erroAoCriarQuery.getMessage());
        }     
    }
    
    private void fecharConexao(){
        try{
            this.conexao.close();
            this.stmt.close();
        }catch(SQLException erroAoFecharConexao){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão. Erro: " + erroAoFecharConexao.getMessage());
        }
    }
}
