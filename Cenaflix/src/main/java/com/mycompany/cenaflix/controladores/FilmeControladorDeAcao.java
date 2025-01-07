package com.mycompany.cenaflix.controladores;

//Pacotes do Projeto
import com.mycompany.cenaflix.modelos.ParaFilmeRecord;
import com.mycompany.cenaflix.dao.FilmeDao;
import com.mycompany.cenaflix.validacoes.ValiParaFilme;
//Pacotes awt
    //Pacotes event
        import java.awt.event.ItemEvent;

public class FilmeControladorDeAcao {
    
    ParaFilmeRecord parametroFilme;
    FilmeDao filmeDao;
    ValiParaFilme validarFilme;
    
    public FilmeControladorDeAcao(ParaFilmeRecord parametroFilme){
        this.parametroFilme = parametroFilme;
        this.filmeDao = new FilmeDao(this.parametroFilme);
        this.validarFilme = new ValiParaFilme(this.parametroFilme);
    }
    
    public void inserirFilme(){
        if(this.validarFilme.validarValores()){
            filmeDao.inserirFilme();
        }
    }
    
    public void setTxtGenero(ItemEvent event,String novoGenero){
        
        if(event.getStateChange() == ItemEvent.SELECTED){
            this.adicionarGenero(novoGenero);
        }
        else{
            this.removerGenero(novoGenero);
        }
        
    }
    
    private void adicionarGenero(String novoGenero){
        String estadoAtual = this.parametroFilme.getTxtGenero().getText();
        
        if(!estadoAtual.equalsIgnoreCase("")){
            String novoEstado = String.format("%s%s;", estadoAtual,novoGenero);
            this.parametroFilme.getTxtGenero().setText(novoEstado);
        }
        else{
            String novoEstado = String.format("%s;", novoGenero);
            this.parametroFilme.getTxtGenero().setText(novoEstado);
        }
    }
    
    private void removerGenero(String generoParaRemover){
        String estadoAtual = this.parametroFilme.getTxtGenero().getText();
        String novoEstado = "";
        generoParaRemover = String.format("%s;", generoParaRemover);
        novoEstado = estadoAtual.replace(generoParaRemover, "");
        this.parametroFilme.getTxtGenero().setText(novoEstado);
    }
    
}
