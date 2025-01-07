package com.mycompany.cenaflix.controladores;

//Pacotes do Projeto
import com.mycompany.cenaflix.modelos.ParaFilmeRecord;
import com.mycompany.cenaflix.dao.FilmeDao;
import com.mycompany.cenaflix.validacoes.ValiParaFilme;

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
    
}
