package controller;

import view.JFAutenticacao;

public class Principal {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFAutenticacao frmLogin = new JFAutenticacao();
            frmLogin.setVisible(true);
            frmLogin.setLocationRelativeTo(null);
        });
    }
}
