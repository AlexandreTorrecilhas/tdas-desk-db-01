package com.mycompany.cenaflix.validacoes;

//Pacotes do Projeto
import com.mycompany.cenaflix.modelos.ParaFilmeRecord;
//Pacotes Swing
import javax.swing.JOptionPane;
//Pacotes JAVA util
import java.util.Map;
import java.util.LinkedHashMap;
    //Pacotes Regex
    import java.util.regex.Pattern;

public class ValiParaFilme {
    
    private LinkedHashMap<String, String> validacao = new LinkedHashMap();
    private LinkedHashMap<String, String> valoresParaValidar = new LinkedHashMap();
    private final String[] mensagemErro = {"Por favor, inserir o nome do filme.", "Por favor verificar se a data segue esse modelo "
            + "dd/mm/aaaa", "Por favor, é necessário selecione um genero"};
    private ParaFilmeRecord parametroFilme;
    private int contator = 0;
    
    public ValiParaFilme(ParaFilmeRecord parametroFilme){
        this.parametroFilme = parametroFilme;
        this.setValiParaFilme();
    }
    
    public boolean validarValores(){
        this.setValoresParaValidar();
        for(Map.Entry<String, String> entry: this.valoresParaValidar.entrySet()){
            String chave = entry.getKey();
            String valorParaValidar = entry.getValue();
            
            if(this.validacao.containsKey(chave)){
                String validador = validacao.get(chave);
                System.out.println("Genero:" + valorParaValidar);
                if(!Pattern.matches(validador, valorParaValidar)){
                    JOptionPane.showMessageDialog(null, this.mensagemErro[this.contator]);
                    return false;
                }
                this.contator++;
            }
        }
        this.contator = 0;
        return true;
    }
    
    private void setValiParaFilme(){
        this.validacao.put("nomeFilme","^[\\w]+[\\s\\w]$");
        this.validacao.put("dataLancamento", "^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[0-2])[/]\\d{4}$");
        this.validacao.put("generoFilme", "^([\\w]+[;])+$");
    }
    
    private void setValoresParaValidar(){
        this.valoresParaValidar.put("nomeFilme", this.parametroFilme.getTxtNome().getText());
        this.valoresParaValidar.put("dataLancamento", this.parametroFilme.getTxtDataLancamento().getText());
        this.valoresParaValidar.put("generoFilme", this.parametroFilme.getTxtGenero().getText());
    }
}
