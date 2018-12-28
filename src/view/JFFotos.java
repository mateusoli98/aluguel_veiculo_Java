package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.DAO.VeiculoDAO;

public class JFFotos extends javax.swing.JFrame {

    VeiculoDAO veiculoDAO = new VeiculoDAO();
    BufferedImage imagemBuffer;
    ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
    byte[] byteArray;
    int idVeiculoAtual;

    public JFFotos(int idVeiculoAnterior) {
        initComponents();
        idVeiculoAtual = idVeiculoAnterior;
        System.out.println(idVeiculoAtual);
        buscaFotoVeiculo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoto = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Foto do Veiculo");
        setResizable(false);

        lblFoto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("...");

        btnVoltar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    void buscaFotoVeiculo() {
        imagemBuffer = null;
        try {
            imagemBuffer = ImageIO.read(new ByteArrayInputStream(veiculoDAO.retornaFotoVeiculo(idVeiculoAtual)));
            Image imgRezise = imagemBuffer.getScaledInstance(400, 400, 0);
            lblFoto.setText("");
            lblFoto.setIcon(new ImageIcon(imgRezise));

        } catch (IOException ex) {
            ex.printStackTrace();

        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblFoto;
    // End of variables declaration//GEN-END:variables
}
