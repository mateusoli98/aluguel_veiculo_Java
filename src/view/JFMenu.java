package view;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.lang.System.exit;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.Cliente;
import model.DAO.ConexaoDAO;
import model.DAO.VeiculoDAO;
import model.Veiculo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFMenu extends javax.swing.JFrame {

    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    VeiculoDAO veiculoDAO = new VeiculoDAO();

    public JFMenu() {
        initComponents();
        lblUsuario.setText("Seja bem vindo   " + ConexaoDAO.getCliente().getNome());
        apresentarGraficoGeral();
        lblComentario.setText("<html>" + avaliacaoDAO.comentarios(cmbTipo.getSelectedItem().toString()) + "</html>");
        jspComentarios.getVerticalScrollBar().setUnitIncrement(10);
        apresentarVeiculos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        panGrafico = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jspComentarios = new javax.swing.JScrollPane();
        lblComentario = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        menuMain = new javax.swing.JMenuBar();
        menAlugar = new javax.swing.JMenu();
        itemVeiculos = new javax.swing.JMenuItem();
        itemMinhasLocacoes = new javax.swing.JMenuItem();
        jmHistoricoLocacoes = new javax.swing.JMenuItem();
        menCadastrar = new javax.swing.JMenu();
        itemVeiculo = new javax.swing.JMenuItem();
        jmPerfl = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();
        itemSairConta = new javax.swing.JMenuItem();
        itemSairPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu principal");

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panGraficoLayout = new javax.swing.GroupLayout(panGrafico);
        panGrafico.setLayout(panGraficoLayout);
        panGraficoLayout.setHorizontalGroup(
            panGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        panGraficoLayout.setVerticalGroup(
            panGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Comentários");

        jspComentarios.setViewportView(lblComentario);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        menAlugar.setText("Locação");
        menAlugar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        itemVeiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        itemVeiculos.setText("Veiculos");
        itemVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVeiculosActionPerformed(evt);
            }
        });
        menAlugar.add(itemVeiculos);

        itemMinhasLocacoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        itemMinhasLocacoes.setText("Minhas Locações");
        itemMinhasLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMinhasLocacoesActionPerformed(evt);
            }
        });
        menAlugar.add(itemMinhasLocacoes);

        jmHistoricoLocacoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jmHistoricoLocacoes.setText("Histórico");
        jmHistoricoLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHistoricoLocacoesActionPerformed(evt);
            }
        });
        menAlugar.add(jmHistoricoLocacoes);

        if(ConexaoDAO.getCliente().getAcesso() == 0){

            menuMain.add(menAlugar);
        }

        menCadastrar.setText("Cadastro");
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

        if(ConexaoDAO.getCliente().getAcesso() == 1){
            menuMain.add(menCadastrar);
        }

        jmPerfl.setText("Meu Perfil");
        jmPerfl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jmPerfl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmPerflMouseClicked(evt);
            }
        });

        if(ConexaoDAO.getCliente().getAcesso() == 0){

            menuMain.add(jmPerfl);
        }

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspComentarios)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemSairProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairProgramaActionPerformed
        exit(0);
    }//GEN-LAST:event_itemSairProgramaActionPerformed

    private void itemSairContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairContaActionPerformed
        dispose();
        Cliente cliente = new Cliente();
        ConexaoDAO.setCliente(cliente);
        JFAutenticacao frmLogin = new JFAutenticacao();
        frmLogin.setVisible(true);
        frmLogin.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemSairContaActionPerformed

    private void itemVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVeiculoActionPerformed
        JFCadastroVeiculo frmCadVeiculos = new JFCadastroVeiculo();
        frmCadVeiculos.setVisible(true);
        frmCadVeiculos.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemVeiculoActionPerformed

    private void itemMinhasLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMinhasLocacoesActionPerformed
        JFLocacoes frmLocacoes = new JFLocacoes();
        frmLocacoes.setVisible(true);
        frmLocacoes.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemMinhasLocacoesActionPerformed

    private void itemVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVeiculosActionPerformed
        JFAlugaVeiculos frmVeiculos = new JFAlugaVeiculos();
        frmVeiculos.setVisible(true);
        frmVeiculos.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemVeiculosActionPerformed

    private void jmPerflMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmPerflMouseClicked
        JFPerfil jfPerfil = new JFPerfil();
        jfPerfil.setVisible(true);


    }//GEN-LAST:event_jmPerflMouseClicked

    private void jmHistoricoLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHistoricoLocacoesActionPerformed
        JFHistoricoLocacao jfHL = new JFHistoricoLocacao();
        jfHL.setVisible(true);

    }//GEN-LAST:event_jmHistoricoLocacoesActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if(cmbTipo.getSelectedItem().equals("Geral")){
            apresentarGraficoGeral();
        }else{
            apresentarGraficoVeiculo(cmbTipo.getSelectedItem().toString());
        }

    }//GEN-LAST:event_cmbTipoActionPerformed
    public void apresentarGraficoGeral() {
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();
        for (Avaliacao a : avaliacaoDAO.notas()) {
            dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
        }

        JFreeChart grafico = ChartFactory.createBarChart3D("Todas as avaliações de nossos clientes", "Notas", "Avaliações", dpd, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(grafico);
        chartpanel.setBackground(Color.BLACK);
        panGrafico.setLayout(new BorderLayout(0, 0));
        panGrafico.add(chartpanel);
        panGrafico.validate();

    }

    public void apresentarGraficoVeiculo(String veiculo) {
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();
        for (Avaliacao a : avaliacaoDAO.notasVeiculo(veiculo)) {
            dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
        }

        JFreeChart grafico = ChartFactory.createBarChart3D("Todas as avaliações de " + veiculo, "Notas", "Avaliações", dpd, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(grafico);
        chartpanel.setBackground(Color.BLACK);
        panGrafico.setLayout(new BorderLayout(0, 0));
        panGrafico.add(chartpanel);
        panGrafico.validate();

    }

    public void apresentarVeiculos() {
        for (Veiculo c : veiculoDAO.exibeNomeVeiculos()) {
            cmbTipo.addItem(c.getNome());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JMenuItem itemMinhasLocacoes;
    private javax.swing.JMenuItem itemSairConta;
    private javax.swing.JMenuItem itemSairPrograma;
    private javax.swing.JMenuItem itemVeiculo;
    private javax.swing.JMenuItem itemVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jmHistoricoLocacoes;
    private javax.swing.JMenu jmPerfl;
    private javax.swing.JScrollPane jspComentarios;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAlugar;
    private javax.swing.JMenu menCadastrar;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JMenu menuSair;
    private javax.swing.JPanel panGrafico;
    // End of variables declaration//GEN-END:variables
}
