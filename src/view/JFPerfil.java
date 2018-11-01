
package view;

import model.DAO.ClienteDAO;
import model.DAO.ConexaoDAO;
import javax.swing.JOptionPane;


public class JFPerfil extends javax.swing.JFrame {

    ClienteDAO clienteDAO = new ClienteDAO();
    public JFPerfil() {
        initComponents();
        lblRecepcaoCliente.setText("Olá "+ConexaoDAO.getCliente().getNome()+", o que deseja fazer?");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRecepcaoCliente = new javax.swing.JLabel();
        btnAlterarConta = new javax.swing.JButton();
        btnExluirConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil");

        lblRecepcaoCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblRecepcaoCliente.setText("...");

        btnAlterarConta.setText("Alterar dados da conta");
        btnAlterarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarContaActionPerformed(evt);
            }
        });

        btnExluirConta.setText("Excuir conta");
        btnExluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExluirContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblRecepcaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnAlterarConta)
                        .addGap(64, 64, 64)
                        .addComponent(btnExluirConta)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblRecepcaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarConta)
                    .addComponent(btnExluirConta))
                .addGap(69, 69, 69))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarContaActionPerformed
        JFCadastroCliente jfCadastroCliente =  new JFCadastroCliente();;;
        jfCadastroCliente.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnAlterarContaActionPerformed

    private void btnExluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExluirContaActionPerformed
        int dialogConfirmar =  JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir sua conta?","Excluir conta",JOptionPane.YES_NO_OPTION);
        if(dialogConfirmar == JOptionPane.YES_OPTION){
            clienteDAO.deletarCliente(ConexaoDAO.getCliente());
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
            JFAutenticacao jfAutenticacao = new JFAutenticacao();
            jfAutenticacao.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnExluirContaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarConta;
    private javax.swing.JButton btnExluirConta;
    private javax.swing.JLabel lblRecepcaoCliente;
    // End of variables declaration//GEN-END:variables
}
