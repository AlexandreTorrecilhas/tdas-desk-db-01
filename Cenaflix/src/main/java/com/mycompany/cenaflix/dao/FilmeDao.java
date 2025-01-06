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
    private String nome;
    private LocalDate dataLancamento;
    private Date dataSql;
    private String genero;

    public FilmeDao(ParaFilmeRecord parametroFilme) {
        this.parametroFilme = parametroFilme;
    }
    
    public void inserirFilme(){
        this.limparValores();
        try{
            this.setStmt(insertFilme);
            this.setParametros();
            this.stmt.setString(1, nome);
            this.stmt.setDate(2, dataSql);
            this.stmt.setString(3, this.genero);
            this.stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Filme adicionado com sucesso");
            this.fecharConexao();
        }catch(SQLException erroAoInserirFilme){
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o valor. Erro: " + erroAoInserirFilme.getMessage());
        }
    }
    
    private void setParametros(){
        try{
            this.nome = this.parametroFilme.getTxtNome().getText();
            this.dataLancamento = LocalDate.parse(this.parametroFilme.getTxtDataLancamento().getText(), formatoData);
            this.dataSql = Date.valueOf(dataLancamento);
            this.genero = parametroFilme.getTxtGenero().getText();
        }catch(DateTimeParseException erroNoFormatoDaData){
            JOptionPane.showMessageDialog(null, "Por favor, informe a data no seguinte formato dd/mm/aaaa");
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
    
    private void limparValores(){
        this.nome = null;
        this.dataLancamento = null;
        this.dataSql = null;
        this.genero = null;
    }
}
