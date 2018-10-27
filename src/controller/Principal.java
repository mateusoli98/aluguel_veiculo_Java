package controller;

import view.JFLogin;
import view.JFMenu;

public class Principal {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                JFMenu frmMenu = new JFMenu();
//                frmMenu.setVisible(true);
//                frmMenu.setLocationRelativeTo(null);
                JFLogin frmLogin = new JFLogin();
                frmLogin.setVisible(true);
                frmLogin.setLocationRelativeTo(null);
            }
        });
    }

}
