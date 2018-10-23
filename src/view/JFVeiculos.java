package view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Veiculo;
import modelDAO.VeiculoDAO;

public class JFVeiculos extends javax.swing.JFrame {

    Veiculo objVeiculo = new Veiculo();
    VeiculoDAO objVeiculoDAO = new VeiculoDAO();
    String operacao = "";

    public JFVeiculos() {
        initComponents();
        DefaultTableModel modelVeiculo = (DefaultTableModel) tableVeiculos.getModel();
        tableVeiculos.setRowSorter(new TableRowSorter(modelVeiculo));
        carregaDadosTable();
        
    }

    void carregaDadosTable() {
        DefaultTableModel modelCliente = (DefaultTableModel) tableVeiculos.getModel();
        modelCliente.setNumRows(0);
        for (Veiculo objVeiculo : objVeiculoDAO.exibeVeiculos()) {

            modelCliente.addRow(new Object[]{
                objVeiculo.getNome(),
                objVeiculo.getModelo(),
                objVeiculo.getMarca(),
                objVeiculo.getCombustivel(),
                objVeiculo.getAno(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();
        txtDataInicio = new javax.swing.JFormattedTextField();

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
        jScrollPane1.setViewportView(tableVeiculos);

        txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JFormattedTextField txtDataInicio;
    // End of variables declaration//GEN-END:variables
}
