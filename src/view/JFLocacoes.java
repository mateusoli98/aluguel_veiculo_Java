package view;

import model.DAO.LocacaoDAO;
import controller.Validacoes;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Locacao;

public class JFLocacoes extends javax.swing.JFrame {

    Locacao objLoc = new Locacao();
    LocacaoDAO objLocDAO = new LocacaoDAO();
    DefaultTableModel dtmDefault = new DefaultTableModel();
    Validacoes objValidacao = new Validacoes();

    public JFLocacoes() {
        initComponents();
        dtmDefault = (DefaultTableModel) tableLocacoes.getModel();
        tableLocacoes.setRowSorter(new TableRowSorter(dtmDefault));
        carregaDadosTable();
        if (dtmDefault.getRowCount() == 0) {
            lblAvaliarVeiculo.setVisible(false);
            btnAvaliarVeiculo.setVisible(false);
        }
    }

    void carregaDadosTable() {
        inicializaModel();
        for (Locacao objLoc : objLocDAO.exibeVeiculos()) {
            dtmDefault.addRow(new Object[]{
                objLoc.getCodLocacao(),
                objLoc.getNomeVeiculo(),
                objValidacao.converteDatasTable(objLoc.getDtInicio()),
                objValidacao.converteDatasTable(objLoc.getDtTermino()),
                objLoc.getTotal(),});
        }
    }

    void inicializaModel() {
        dtmDefault = (DefaultTableModel) tableLocacoes.getModel();
        dtmDefault.setNumRows(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableLocacoes = new javax.swing.JTable();
        lblAvaliarVeiculo = new javax.swing.JLabel();
        btnAvaliarVeiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Minhas Locações");
        setResizable(false);

        tableLocacoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableLocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Locação", "Veiculo", "Data Inicio", "Data Termino", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLocacoes);
        if (tableLocacoes.getColumnModel().getColumnCount() > 0) {
            tableLocacoes.getColumnModel().getColumn(0).setResizable(false);
        }

        lblAvaliarVeiculo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvaliarVeiculo.setText("Que tal avaliar algum veiculo desta lista, para melhorar nossa qualidade de serviço?");

        btnAvaliarVeiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAvaliarVeiculo.setText("Opa, vamos lá");
        btnAvaliarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAvaliarVeiculo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnAvaliarVeiculo)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAvaliarVeiculo)
                .addGap(18, 18, 18)
                .addComponent(btnAvaliarVeiculo)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvaliarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarVeiculoActionPerformed
        dispose();
        JFHistoricoLocacao frmHistorico = new JFHistoricoLocacao();
        frmHistorico.setVisible(true);
    }//GEN-LAST:event_btnAvaliarVeiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvaliarVeiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvaliarVeiculo;
    private javax.swing.JTable tableLocacoes;
    // End of variables declaration//GEN-END:variables
}
