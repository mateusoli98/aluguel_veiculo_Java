package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Validacoes {

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

    public int mesInserido(String data) {
        int i = Integer.parseInt(data.substring(data.indexOf("/") + 1, data.lastIndexOf("/")));
        return i;
    }

    public int diaInserido(String data) {
        int i = Integer.parseInt(data.substring(0, 2));
        return i;
    }

    public boolean validaData(String dataInicio, String dataTermino) {
        boolean retorno = false;
        int anoInicio = Integer.parseInt(dataInicio.substring(dataInicio.lastIndexOf("/") + 1));
        int anoTermino = Integer.parseInt(dataTermino.substring(dataTermino.lastIndexOf("/") + 1));
        if (!dataInicio.contains(" /  /    ") && !dataTermino.contains(" /  /    ")) {
            if (!(anoInicio < anoAtual()) && !(anoTermino < anoAtual())) {
                if (!(mesInserido(dataInicio) > 12) && !(mesInserido(dataTermino) > 12)) {
                    if (!(diaInserido(dataInicio) > 31) && !(diaInserido(dataTermino) > 31)) {
                        if (!dataInicio.equals(dataTermino)) {
                            retorno = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Datas de Inicio e Termino não devem ser iguais!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dia de Inicio e/ou Termino invalidos!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mês de Inicio e/ou Termino invalidos!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Anos invalido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira as Datas de Inicio e/ou Termino!");
        }
        return retorno;
    }
}
