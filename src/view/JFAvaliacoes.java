
package view;

import model.AvaliacaoDAO;

public class JFAvaliacoes extends javax.swing.JFrame {
    AvaliacaoDAO objAvaliacaoDAO =  new AvaliacaoDAO();
    
    public JFAvaliacoes() {
        initComponents();
        lblComentario.setText("<html>"+objAvaliacaoDAO.comentarios()+"</html>");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspComentarios = new javax.swing.JScrollPane();
        lblComentario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblComentario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblComentario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jspComentarios.setViewportView(lblComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(jspComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new JFAvaliacoes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jspComentarios;
    private javax.swing.JLabel lblComentario;
    // End of variables declaration//GEN-END:variables
}
