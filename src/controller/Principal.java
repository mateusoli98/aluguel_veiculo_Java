package controller;

import view.JFLogin;
import view.JFVeiculos;

public class Principal {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFLogin frmLogin = new JFLogin();
               frmLogin.setVisible(true);
               frmLogin.setLocationRelativeTo(null);
//                JFVeiculos frmV = new JFVeiculos();
//                frmV.setVisible(true);
//                frmV.setLocationRelativeTo(null);

            }
        });
    }

}
