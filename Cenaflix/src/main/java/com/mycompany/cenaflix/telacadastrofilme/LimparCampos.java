package com.mycompany.cenaflix.telacadastrofilme;

//Pacotes do Projeto
import com.mycompany.cenaflix.modelos.ParaFilmeRecord;

public class LimparCampos {
    
    private ParaFilmeRecord parametroFilme;
    
    public LimparCampos(ParaFilmeRecord parametroFilme){
        this.parametroFilme = parametroFilme;
    }
    
    public void limparCamps(){
        this.parametroFilme.getTxtNome().setText("");
        this.parametroFilme.getTxtDataLancamento().setText("");
        this.parametroFilme.getTxtGenero().setText("");
    }
    
}
