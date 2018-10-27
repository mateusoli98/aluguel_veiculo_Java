package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControleLocacao {

    public String converteDatas(String dataPadrao) {
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

}
