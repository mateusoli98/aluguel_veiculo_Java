package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControleLocacao {

    public String converteDatasBanco(String dataPadrao) {
        Date data = null;
        String dataBanco;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dataPadrao);
        } catch (java.text.ParseException e) {
            System.out.println("Ocorreu um erro\n " + e);
        }
        dataBanco = new SimpleDateFormat("yyyy-MM-dd").format(data);
        return dataBanco;
    }

    public String converteDatasTable(String dataPadrao) {
        Date data = null;
        String dataBanco;
        try {

            data = new SimpleDateFormat("yyyy-MM-dd").parse(dataPadrao);
        } catch (java.text.ParseException e) {
            System.out.println("Ocorreu um erro\n " + e);
        }
        dataBanco = new SimpleDateFormat("dd/MM/yyyy").format(data);
        return dataBanco;
    }

    public int anoAtual() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String ano = formatador.format(data);
        return Integer.parseInt(ano.substring(ano.lastIndexOf("/") + 1));
    }

}
