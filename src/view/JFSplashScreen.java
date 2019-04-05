package view;

public class JFSplashScreen extends javax.swing.JFrame {

    public JFSplashScreen() {
        initComponents();
        lblTitulo.setText("<html><center>Aluguel<br>de<br>Veículos</center></html>");
        new ProgressBar().start();
    }

    public class ProgressBar extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i <= 100; i++) {
                    sleep(10);
                    lblPregresso.setText(i + " %");
                    jpbProgresso.setValue(i);
                    if (i == 100) {
                        JFAutenticacao frmAutenticacao = new JFAutenticacao();
                        frmAutenticacao.setVisible(true);
                        dispose();
                    }
                }
            } catch (InterruptedException e) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSplash = new javax.swing.JPanel();
        jpbProgresso = new javax.swing.JProgressBar();
        lblPregresso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panSplash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panSplash.add(jpbProgresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 770, 20));

        lblPregresso.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 24)); // NOI18N
        lblPregresso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panSplash.add(lblPregresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 770, 30));

        lblTitulo.setFont(new java.awt.Font("Adobe Arabic", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panSplash.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 750, 160));

        getContentPane().add(panSplash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jpbProgresso;
    private javax.swing.JLabel lblPregresso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panSplash;
    // End of variables declaration//GEN-END:variables
}
