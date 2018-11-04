package view;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Avaliacao;
import model.AvaliacaoDAO;
import model.DAO.ConexaoDAO;
import model.DAO.LocacaoDAO;
import model.HistoricoLocacao;
import model.Locacao;
import model.Veiculo;

public class JFHistoricoLocacao extends javax.swing.JFrame {

    HistoricoLocacao objHL = new HistoricoLocacao();
    Locacao objLocacao = new Locacao();
    Veiculo objVeiculo = new Veiculo();
    Avaliacao objAvaliacao = new Avaliacao();
    AvaliacaoDAO objAvaliacaoDAO = new AvaliacaoDAO();
    LocacaoDAO objLocDAO = new LocacaoDAO();
    DefaultTableModel dtmDefault = new DefaultTableModel();

    public JFHistoricoLocacao() {
        initComponents();
        lblNota.setText(String.valueOf(jsNota.getValue()));
        lblNomeCliente.setText("Deixe sua avaliação " + ConexaoDAO.getCliente().getNome() + ", selecione uam locação para avaliar :)");
        carregaDadosTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jsNota = new javax.swing.JSlider();
        btnEnviar = new javax.swing.JButton();
        lblNota = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtHistoricoLocacao = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Avaliação");
        setResizable(false);

        jLabel2.setText("Deixe seu comentário sobre o serviço:");

        jLabel3.setText("Dê sua nota:");

        jsNota.setMaximum(5);
        jsNota.setValue(2);
        jsNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jsNota.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsNotaStateChanged(evt);
            }
        });

        btnEnviar.setText("Enviar Avaliação");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblNota.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jtHistoricoLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Chassi", "Nome", "Modelo", "Data Termino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtHistoricoLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtHistoricoLocacaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtHistoricoLocacao);
        if (jtHistoricoLocacao.getColumnModel().getColumnCount() > 0) {
            jtHistoricoLocacao.getColumnModel().getColumn(0).setResizable(false);
            jtHistoricoLocacao.getColumnModel().getColumn(1).setResizable(false);
            jtHistoricoLocacao.getColumnModel().getColumn(2).setResizable(false);
            jtHistoricoLocacao.getColumnModel().getColumn(3).setResizable(false);
        }

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        txtComentario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(txtComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jsNota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(94, 94, 94)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNomeCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(lblNota, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jsNota, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnviar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jsNotaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsNotaStateChanged
        lblNota.setText(String.valueOf(jsNota.getValue()));
    }//GEN-LAST:event_jsNotaStateChanged

    private void jtHistoricoLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHistoricoLocacaoMouseClicked
        btnEnviar.setEnabled(true);
        preencheObjeto();
    }//GEN-LAST:event_jtHistoricoLocacaoMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        preencheObjeto();
        objAvaliacao.setComentario(txtComentario.getText());
        objAvaliacao.setNumAvaliacao(jsNota.getValue());
        objAvaliacao.setStatus(1);

        if (objAvaliacaoDAO.resgistarAvaliacao(objAvaliacao, objHL)) {
            JOptionPane.showMessageDialog(null, "Avalação registrada com sucesso!");
            carregaDadosTable();
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    void carregaDadosTable(){
        inicializaModel();

        for (HistoricoLocacao objHL : objLocDAO.historicoLocacao()) {
            dtmDefault.addRow(new Object[]{
                objHL.getVeiculo().getCodigo(),
                objHL.getVeiculo().getNome(),
                objHL.getVeiculo().getModelo(),
//                objHL.getLocacao().getDtTermino()
            });
        }
    }

    void inicializaModel() {
        dtmDefault = (DefaultTableModel) jtHistoricoLocacao.getModel();
        dtmDefault.setNumRows(0);
    }

    void preencheObjeto() {
        objVeiculo.setCodigo((int) jtHistoricoLocacao.getValueAt(jtHistoricoLocacao.getSelectedRow(), 0));
        objVeiculo.setNome("" + jtHistoricoLocacao.getValueAt(jtHistoricoLocacao.getSelectedRow(), 1));
        objVeiculo.setModelo("" + jtHistoricoLocacao.getValueAt(jtHistoricoLocacao.getSelectedRow(), 2));
//        objLocacao.setDtTermino("" + jtHistoricoLocacao.getValueAt(jtHistoricoLocacao.getSelectedRow(), 3));
        objHL.setLocacao(objLocacao);
        objHL.setVeiculo(objVeiculo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jsNota;
    private javax.swing.JTable jtHistoricoLocacao;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNota;
    private javax.swing.JTextArea txtComentario;
    // End of variables declaration//GEN-END:variables
}
