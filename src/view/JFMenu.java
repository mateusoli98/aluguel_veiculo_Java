package view;

import static java.lang.System.exit;
import modelDAO.ConexaoDAO;

public class JFMenu extends javax.swing.JFrame {

    public JFMenu() {
        initComponents();
        lblUsuario.setText(""+ConexaoDAO.getCliente().getCodigo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblApresentaUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        menuMain = new javax.swing.JMenuBar();
        menAlugar = new javax.swing.JMenu();
        itemVeiculos = new javax.swing.JMenuItem();
        menCadastrar = new javax.swing.JMenu();
        itemVeiculo = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        itemSairConta = new javax.swing.JMenuItem();
        itemSairPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblApresentaUsuario.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblApresentaUsuario.setForeground(new java.awt.Color(0, 102, 255));
        lblApresentaUsuario.setText("Seja bem vindo:");

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        menAlugar.setText("Alugar");
        menAlugar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        itemVeiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        itemVeiculos.setText("Veiculos");
        itemVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVeiculosActionPerformed(evt);
            }
        });
        menAlugar.add(itemVeiculos);

        menuMain.add(menAlugar);

        menCadastrar.setText("Cadastrar");
        menCadastrar.setFocusable(false);
        menCadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        itemVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        itemVeiculo.setText("Veiculos");
        itemVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVeiculoActionPerformed(evt);
            }
        });
        menCadastrar.add(itemVeiculo);

        menuMain.add(menCadastrar);

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        itemSairConta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        itemSairConta.setText("Conta");
        itemSairConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairContaActionPerformed(evt);
            }
        });
        menuSair.add(itemSairConta);

        itemSairPrograma.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblApresentaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApresentaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(394, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSairProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairProgramaActionPerformed
        exit(0);
    }//GEN-LAST:event_itemSairProgramaActionPerformed

    private void itemSairContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairContaActionPerformed
        dispose();
        JFAutenticacao frmLogin = new JFAutenticacao();
        frmLogin.setVisible(true);
        frmLogin.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemSairContaActionPerformed

    private void itemVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVeiculosActionPerformed
        JFAlugaVeiculos frmVeiculos = new JFAlugaVeiculos();
        frmVeiculos.setVisible(true);
        frmVeiculos.setLocationRelativeTo(null);

    }//GEN-LAST:event_itemVeiculosActionPerformed

    private void itemVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVeiculoActionPerformed
        JFCadastroVeiculo frmCadVeiculos = new JFCadastroVeiculo();
        frmCadVeiculos.setVisible(true);
        frmCadVeiculos.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemVeiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemSairConta;
    private javax.swing.JMenuItem itemSairPrograma;
    private javax.swing.JMenuItem itemVeiculo;
    private javax.swing.JMenuItem itemVeiculos;
    private javax.swing.JLabel lblApresentaUsuario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAlugar;
    private javax.swing.JMenu menCadastrar;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
