
package controller;

import view.JFLogin;

public class Principal {

    public static void main(String[] args) {
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFLogin frmLogin = new JFLogin();
               frmLogin.setVisible(true);
               frmLogin.setLocationRelativeTo(null);
                
            }
        });
    }
    
}
