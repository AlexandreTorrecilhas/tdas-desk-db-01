package com.mycompany.cenaflix.modelos;

//Pacotes SWING
import javax.swing.JTextField;

public class ParaFilmeRecord {
    
    JTextField txtNome;
    JTextField txtDataLancamento;
    JTextField txtGenero;

    public ParaFilmeRecord(JTextField txtNome, JTextField txtDataLancamento, JTextField txtGenero) {
        this.txtNome = txtNome;
        this.txtDataLancamento = txtDataLancamento;
        this.txtGenero = txtGenero;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtDataLancamento() {
        return txtDataLancamento;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }
    
}
