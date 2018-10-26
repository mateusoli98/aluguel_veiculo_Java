package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Veiculo;
import modelDAO.VeiculoDAO;

public class JFVeiculos extends javax.swing.JFrame {

    Veiculo objVeiculo = new Veiculo();
    VeiculoDAO objVeiculoDAO = new VeiculoDAO();
    String operacao = "", tipoVeiculo = "", nomeVeiculo;
    DefaultTableModel dtmDefault = new DefaultTableModel();

    public JFVeiculos() {
        initComponents();
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        tableVeiculos.setRowSorter(new TableRowSorter(dtmDefault));
        carregaDadosTable();
        desabilitaCampos();

    }

    void carregaDadosTable() {
        inicializaModel();
        for (Veiculo objVeiculo : objVeiculoDAO.exibeVeiculos()) {
            dtmDefault.addRow(new Object[]{
                objVeiculo.getNome(),
                objVeiculo.getModelo(),
                objVeiculo.getMarca(),
                objVeiculo.getCombustivel(),
                objVeiculo.getAno(),});
        }
    }

    void dadosTableTipoVeiculo(String tipo) {
        inicializaModel();
        for (Veiculo objVeiculo : objVeiculoDAO.exibeTipoVeiculos(tipo)) {
            dtmDefault.addRow(new Object[]{
                objVeiculo.getNome(),
                objVeiculo.getModelo(),
                objVeiculo.getMarca(),
                objVeiculo.getCombustivel(),
                objVeiculo.getAno(),});
        }
    }

    void dadosTabelNomeVeiculo(String nome) {
        inicializaModel();
        for (Veiculo objVeiculo : objVeiculoDAO.exibeVeiculoNome(nome)) {
            dtmDefault.addRow(new Object[]{
                objVeiculo.getNome(),
                objVeiculo.getModelo(),
                objVeiculo.getMarca(),
                objVeiculo.getCombustivel(),
                objVeiculo.getAno(),});
        }
    }

    void habilitaCampos() {
        lblValorAluguel.setVisible(true);
        txtDataInicio.setVisible(true);
        txtDataFim.setVisible(true);
        btnConfirmar.setVisible(true);
        btnCancelar.setVisible(true);
        lblDataFim.setVisible(true);
        lblDataInicio.setVisible(true);
    }

    void desabilitaCampos() {
        lblValorAluguel.setVisible(false);
        txtDataInicio.setVisible(false);
        txtDataFim.setVisible(false);
        btnConfirmar.setVisible(false);
        btnCancelar.setVisible(false);
        lblDataFim.setVisible(false);
        lblDataInicio.setVisible(false);
    }

    void inicializaModel() {
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        dtmDefault.setNumRows(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoVeiculo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNomeVeiculo = new javax.swing.JTextField();
        txtDataInicio = new javax.swing.JTextField();
        txtDataFim = new javax.swing.JTextField();
        lblDataInicio = new javax.swing.JLabel();
        lblDataFim = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblValorAluguel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Modelo", "Marca", "Combustivel", "Ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVeiculos);

        jLabel1.setText("Tipo de Veiculo");

        cmbTipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**", "Carro", "Moto" }));
        cmbTipoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVeiculoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Veiculo");

        txtNomeVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeVeiculoKeyReleased(evt);
            }
        });

        txtDataInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataInicioKeyReleased(evt);
            }
        });

        txtDataFim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataFimKeyReleased(evt);
            }
        });

        lblDataInicio.setText("Data Inicio");

        lblDataFim.setText("Data Terminio");

        btnConfirmar.setText("Confirmar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblValorAluguel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblValorAluguel.setForeground(new java.awt.Color(0, 153, 0));
        lblValorAluguel.setText("12.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(lblDataInicio)
                        .addGap(96, 96, 96)
                        .addComponent(lblDataFim))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnConfirmar)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(lblValorAluguel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblDataFim))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataInicio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValorAluguel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoVeiculoActionPerformed
        tipoVeiculo = (String) cmbTipoVeiculo.getSelectedItem();
        if (tipoVeiculo.equals("Carro")) {
            dadosTableTipoVeiculo(tipoVeiculo);
        }
        if (tipoVeiculo.equals("Moto")) {
            dadosTableTipoVeiculo(tipoVeiculo);
        }
        if (tipoVeiculo.equals("**Selecione**")) {
            carregaDadosTable();
        }
    }//GEN-LAST:event_cmbTipoVeiculoActionPerformed

    private void txtNomeVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeVeiculoKeyReleased
        nomeVeiculo = txtNomeVeiculo.getText();
        if (!nomeVeiculo.equals("")) {
            dadosTabelNomeVeiculo(nomeVeiculo);
        } else {
            carregaDadosTable();
        }

    }//GEN-LAST:event_txtNomeVeiculoKeyReleased

    private void txtDataInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataInicioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInicioKeyReleased

    private void txtDataFimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataFimKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataFimKeyReleased

    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVeiculosMouseClicked
        habilitaCampos();
    }//GEN-LAST:event_tableVeiculosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desabilitaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbTipoVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblValorAluguel;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JTextField txtDataFim;
    private javax.swing.JTextField txtDataInicio;
    private javax.swing.JTextField txtNomeVeiculo;
    // End of variables declaration//GEN-END:variables
}
