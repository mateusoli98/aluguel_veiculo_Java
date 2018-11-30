package view;

import controller.Validacoes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Locacao;
import model.Veiculo;
import model.DAO.ConexaoDAO;
import model.DAO.VeiculoDAO;

public class JFAlugaVeiculos extends javax.swing.JFrame {

    Veiculo objVeiculo = new Veiculo();
    VeiculoDAO objVeiculoDAO = new VeiculoDAO();
    Locacao objLoc = new Locacao();
    String operacao = "", tipoVeiculo = "", nomeVeiculo, dtInicio, dtTermino;
    DefaultTableModel dtmDefault = new DefaultTableModel();
    int diaInicio, diaFim, anoVeiculo;
    Validacoes objValidacao = new Validacoes();

    public JFAlugaVeiculos() {
        initComponents();
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        tableVeiculos.setRowSorter(new TableRowSorter(dtmDefault));
        carregaDadosTable();
        desabilitaCamposCotacao();
        desabilitaCamposContratacao();

    }

    void carregaDadosTable() {
        inicializaModel();
        for (Veiculo objVeiculo : objVeiculoDAO.exibeVeiculos()) {
            dtmDefault.addRow(new Object[]{
                objVeiculo.getCodigo(),
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
                objVeiculo.getCodigo(),
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
                objVeiculo.getCodigo(),
                objVeiculo.getNome(),
                objVeiculo.getModelo(),
                objVeiculo.getMarca(),
                objVeiculo.getCombustivel(),
                objVeiculo.getAno(),});
        }
    }

    void habilitaCamposCotacao() {
        txtDataInicio.setVisible(true);
        txtDataTermino.setVisible(true);
        txtDataTermino.setVisible(true);
        lblDataFim.setVisible(true);
        lblDataInicio.setVisible(true);
        btnCalcular.setVisible(true);
    }

    void desabilitaCamposCotacao() {
        txtDataInicio.setVisible(false);
        txtDataTermino.setVisible(false);
        txtDataInicio.setText("");
        txtDataTermino.setText("");
        lblDataFim.setVisible(false);
        lblDataInicio.setVisible(false);
        btnCalcular.setVisible(false);
    }

    void habilitaCamposContratacao() {
        lblMoeda.setVisible(true);
        lblValorAluguel.setVisible(true);
        btnConfirmar.setVisible(true);
        btnCancelar.setVisible(true);
    }

    void desabilitaCamposContratacao() {
        lblMoeda.setVisible(false);
        lblValorAluguel.setVisible(false);
        btnConfirmar.setVisible(false);
        btnCancelar.setVisible(false);
    }

    void inicializaModel() {
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        dtmDefault.setNumRows(0);
    }

    int retornaDias() {
        dtInicio = txtDataInicio.getText();
        dtTermino = txtDataTermino.getText();
        int i = 0;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1, dt2;
        try {
            dt1 = df.parse(dtInicio);
            dt2 = df.parse(dtTermino);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt1);
            for (Date dt = dt1; dt.compareTo(dt2) <= 0;) {
                cal.add(Calendar.DATE, +1);
                dt = cal.getTime();
                i++;
            }
        } catch (ParseException ex) {
            Logger.getLogger(JFAlugaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    void calcAluguel() {
        anoVeiculo = (int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 5);
        if (anoVeiculo <= 2005) {
            lblValorAluguel.setText("" + retornaDias() * 50.00);
        }

        if (anoVeiculo > 2005) {
            lblValorAluguel.setText("" + retornaDias() * 100.00);
        }
    }

    void preencheObjeto() {
        objLoc.setCodCliente(ConexaoDAO.getCliente().getCodigo());
        objLoc.setCodVeiculo((int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 0));
        objLoc.setDtInicio(objValidacao.converteDatasBanco(dtInicio));
        objLoc.setDtTermino(objValidacao.converteDatasBanco(dtTermino));
        objLoc.setTotal(Double.parseDouble(lblValorAluguel.getText()));
        objLoc.setNomeVeiculo("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 1));
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
        lblDataInicio = new javax.swing.JLabel();
        lblDataFim = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblMoeda = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataTermino = new javax.swing.JFormattedTextField();
        lblValorAluguel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locação Veiculo");
        setResizable(false);

        tableVeiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chassi", "Nome", "Modelo", "Marca", "Combustivel", "Ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        if (tableVeiculos.getColumnModel().getColumnCount() > 0) {
            tableVeiculos.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de Veiculo");

        cmbTipoVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**", "Carro", "Moto" }));
        cmbTipoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVeiculoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nome Veiculo");

        txtNomeVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNomeVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeVeiculoKeyReleased(evt);
            }
        });

        lblDataInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataInicio.setText("Data Inicio");

        lblDataFim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataFim.setText("Data Terminio");

        btnConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblMoeda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMoeda.setForeground(new java.awt.Color(0, 153, 0));
        lblMoeda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMoeda.setText("R$");

        btnCalcular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDataInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataInicioMouseClicked(evt);
            }
        });

        try {
            txtDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataTermino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDataTermino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataTerminoMouseClicked(evt);
            }
        });

        lblValorAluguel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblValorAluguel.setForeground(new java.awt.Color(0, 153, 0));
        lblValorAluguel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
                        .addGap(218, 218, 218)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataInicio)
                            .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDataTermino)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCalcular))))
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirmar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(221, 221, 221))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicio)
                    .addComponent(lblDataFim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(34, 34, 34))
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

    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVeiculosMouseClicked
        habilitaCamposCotacao();
    }//GEN-LAST:event_tableVeiculosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desabilitaCamposContratacao();
        desabilitaCamposCotacao();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (objValidacao.validaData(txtDataInicio.getText(), txtDataTermino.getText())) {;
            habilitaCamposContratacao();
            calcAluguel();
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        preencheObjeto();
        if (objVeiculoDAO.realizaLocacao(objLoc)) {
            desabilitaCamposContratacao();
            desabilitaCamposCotacao();
            carregaDadosTable();
            JFNotaPedido frmPedidoConfirmado = new JFNotaPedido(objLoc);
            frmPedidoConfirmado.setVisible(true);
            frmPedidoConfirmado.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Locação não finalizada, tente novamente!");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtDataInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataInicioMouseClicked
        //Posiciona cursor no inicio do campo, evitando escrever no meio da data
        txtDataInicio.setCaretPosition(0);
    }//GEN-LAST:event_txtDataInicioMouseClicked

    private void txtDataTerminoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataTerminoMouseClicked
        //Posiciona cursor no inicio do campo, evitando escrever no meio da data
        txtDataTermino.setCaretPosition(0);
    }//GEN-LAST:event_txtDataTerminoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbTipoVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblMoeda;
    private javax.swing.JLabel lblValorAluguel;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JFormattedTextField txtDataTermino;
    private javax.swing.JTextField txtNomeVeiculo;
    // End of variables declaration//GEN-END:variables
}
