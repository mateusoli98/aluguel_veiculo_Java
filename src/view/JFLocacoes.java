package view;

import model.DAO.ConexaoDAO;
import model.DAO.LocacaoDAO;
import model.DAO.VeiculoDAO;
import controller.ControleLocacao;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Locacao;

public class JFLocacoes extends javax.swing.JFrame {

    Locacao objLoc = new Locacao();
    LocacaoDAO objLocDAO = new LocacaoDAO();
    DefaultTableModel dtmDefault = new DefaultTableModel();
    ControleLocacao conLoc = new ControleLocacao();

    public JFLocacoes() {
        initComponents();
        dtmDefault = (DefaultTableModel) tableLocacoes.getModel();
        tableLocacoes.setRowSorter(new TableRowSorter(dtmDefault));
        carregaDadosTable();
    }

    void carregaDadosTable() {
        inicializaModel();
        for (Locacao objLoc : objLocDAO.exibeVeiculos(ConexaoDAO.getCliente().getCodigo())) {
            dtmDefault.addRow(new Object[]{
                objLoc.getCodLocacao(),
                objLoc.getNomeVeiculo(),
                conLoc.converteDatasTable(objLoc.getDtInicio()),
                conLoc.converteDatasTable(objLoc.getDtTermino()),
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLocacoes;
    // End of variables declaration//GEN-END:variables
}
