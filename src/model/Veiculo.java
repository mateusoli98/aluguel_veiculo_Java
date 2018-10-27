package model;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Veiculo {

    private String nome, marca, modelo, tipo, combustivel;
    private int ano, id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public MaskFormatter Mascara(String Mascara) {
//        MaskFormatter F_Mascara = new MaskFormatter();
//        try {
//            F_Mascara.setMask(Mascara); //Atribui a mascara
//            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
//        } catch (Exception excecao) {
//            excecao.printStackTrace();
//        }
//        return F_Mascara;
//    }
}
