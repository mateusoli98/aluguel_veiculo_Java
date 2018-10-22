package view;

import static java.lang.System.exit;
import model.Cliente;

public class JFMenu extends javax.swing.JFrame {

    public JFMenu(Cliente cliente) {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuMain = new javax.swing.JMenuBar();
        menAlugar = new javax.swing.JMenu();
        itemVeiculos = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        itemSairConta = new javax.swing.JMenuItem();
        itemSairPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menAlugar.setText("Alugar");

        itemVeiculos.setText("Veiculos");
        itemVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVeiculosActionPerformed(evt);
            }
        });
        menAlugar.add(itemVeiculos);

        menuMain.add(menAlugar);

        menuSair.setText("Sair");

        itemSairConta.setText("Conta");
        itemSairConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairContaActionPerformed(evt);
            }
        });
        menuSair.add(itemSairConta);

        itemSairPrograma.setText("Programa");
        itemSairPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairProgramaActionPerformed(evt);
            }
        });
        menuSair.add(itemSairPrograma);

        menuMain.add(menuSair);

        setJMenuBar(menuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSairProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairProgramaActionPerformed
        exit(0);
    }//GEN-LAST:event_itemSairProgramaActionPerformed

    private void itemSairContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairContaActionPerformed
        dispose();
        JFLogin frmLogin = new JFLogin();
        frmLogin.setVisible(true);
        frmLogin.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemSairContaActionPerformed

    private void itemVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVeiculosActionPerformed
       JFVeiculos frmVeiculos =  new JFVeiculos();
       frmVeiculos.setVisible(true);
       frmVeiculos.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_itemVeiculosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemSairConta;
    private javax.swing.JMenuItem itemSairPrograma;
    private javax.swing.JMenuItem itemVeiculos;
    private javax.swing.JMenu menAlugar;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
