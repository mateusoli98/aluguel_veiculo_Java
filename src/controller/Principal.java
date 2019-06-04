package controller;

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
            System.out.println(ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> {
            JFSplashScreen frmScreenSplash = new JFSplashScreen();
            frmScreenSplash.setVisible(true);

        });

    }
}
