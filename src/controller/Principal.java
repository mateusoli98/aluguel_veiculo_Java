package controller;

import view.JFAutenticacao;
import view.JFMenu;

public class Principal {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            JFAutenticacao frmLogin = new JFAutenticacao();
           //JFMenu frmLogin = new JFMenu();
            frmLogin.setVisible(true);
            frmLogin.setLocationRelativeTo(null);
        });
    }
}
