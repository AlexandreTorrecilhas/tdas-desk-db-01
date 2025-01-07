package com.mycompany.cenaflix.validacoes;

//Pacotes JAVA util
import java.util.Map;
import java.util.LinkedHashMap;

public class ValiParaFilme {
    
    LinkedHashMap<String, String> validacao = new LinkedHashMap();
    
    public ValiParaFilme(){
        this.setValiParaFilme();
    }
    
    public boolean validarValores(LinkedHashMap<String, String> valoresParaValidar){
        for(Map.Entry<String, String> entry: valoresParaValidar.entrySet()){
            String chave = entry.getKey();
            String valorParaValidar = entry.getValue();
            
            if(validacao.containsKey(chave)){
                String validador = validacao.get(chave);
                if(!valorParaValidar.matches(validador)){
                    return false;
                }
                else{
                    return false;
                }
            }
            
        }
        
        return true;
    }
    
    private void setValiParaFilme(){
        this.validacao.put("nomeFilme","^[\\w]+[\\s\\w]*$");
        this.validacao.put("dataLancamento", "^0[0-9]|[12][0-9]|3[01]/0[01-9]|1[0-2]/\\d{4}$");
        this.validacao.put("generoFilme", "^[\\w]+[;][\\w]*$");
    }
}
