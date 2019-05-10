package controller;

import view.JFAlugaVeiculos;
import view.JFAutenticacao;
import view.JFSplashScreen;

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
            JFAutenticacao frmScreenSplash = new JFAutenticacao();
            frmScreenSplash.setVisible(true);

        });

    }
}
