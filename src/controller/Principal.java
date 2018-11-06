package controller;

import model.Email;
import view.JFAutenticacao;


public class Principal {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            JFAutenticacao frmLogin = new JFAutenticacao();
            frmLogin.setVisible(true);
            frmLogin.setLocationRelativeTo(null);
        });



//        Email e =  new Email();
//        e.enviar();




    }
}
