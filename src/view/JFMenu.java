package view;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.lang.System.exit;
import javax.swing.JOptionPane;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.DAO.PessoaDAO;
import model.Pessoa;
import model.DAO.ConexaoDAO;
import model.DAO.LocacaoDAO;
import model.DAO.VeiculoDAO;

import model.Veiculo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.w3c.dom.css.RGBColor;

public class JFMenu extends javax.swing.JFrame {

    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    LocacaoDAO locDAO = new LocacaoDAO();
    String escolhaGrafico = "", escolhaNota = "";
    PessoaDAO clienteDAO = new PessoaDAO();
    Avaliacao a = new Avaliacao();

    public JFMenu() {
        initComponents();
        int i = 0;
        while (i <= locDAO.qntLocacoesVencidas()) {
            locDAO.verificaDisponibilidadeVeiculo();
            i++;
        }
        lblUsuario.setText("Bem vindo: " + ConexaoDAO.getCliente().getNome());
        apresentarGrafico("" + cmbTipo.getSelectedItem());
        jspComentarios.getVerticalScrollBar().setUnitIncrement(10);
        apresentarVeiculos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        panGrafico = new javax.swing.JPanel();
        cmbTipo = new javax.swing.JComboBox<>();
        cmbNota = new javax.swing.JComboBox<>();
        lblParametroGrafico1 = new javax.swing.JLabel();
        lblParametroGrafico2 = new javax.swing.JLabel();
        lblParametroGrafico = new javax.swing.JLabel();
        jspComentarios = new javax.swing.JScrollPane();
        lblComentario = new javax.swing.JLabel();
        menuMain = new javax.swing.JMenuBar();
        menAlugar = new javax.swing.JMenu();
        itemVeiculos = new javax.swing.JMenuItem();
        itemMinhasLocacoes = new javax.swing.JMenuItem();
        jmHistoricoLocacoes = new javax.swing.JMenuItem();
        menCadastrar = new javax.swing.JMenu();
        itemVeiculo = new javax.swing.JMenuItem();
        jmPerfl = new javax.swing.JMenu();
        itemEditar = new javax.swing.JMenuItem();
        itemExcluir = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        itemSairConta = new javax.swing.JMenuItem();
        itemSairPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMain.setBackground(new java.awt.Color(217, 217, 217));
        panelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setBackground(new java.awt.Color(0, 153, 153));
        lblUsuario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(102, 102, 102));
        panelMain.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 870, 27));

        javax.swing.GroupLayout panGraficoLayout = new javax.swing.GroupLayout(panGrafico);
        panGrafico.setLayout(panGraficoLayout);
        panGraficoLayout.setHorizontalGroup(
            panGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        panGraficoLayout.setVerticalGroup(
            panGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        panelMain.add(panGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 870, 580));

        cmbTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(102, 102, 102));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        panelMain.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 160, 30));

        cmbNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbNota.setForeground(new java.awt.Color(102, 102, 102));
        cmbNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Maior Nota", "Menor Nota" }));
        cmbNota.setPreferredSize(new java.awt.Dimension(63, 23));
        cmbNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNotaActionPerformed(evt);
            }
        });
        panelMain.add(cmbNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 110, 150, 30));

        lblParametroGrafico1.setBackground(new java.awt.Color(255, 255, 255));
        lblParametroGrafico1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblParametroGrafico1.setForeground(new java.awt.Color(102, 102, 102));
        lblParametroGrafico1.setText("Exibir por:");
        panelMain.add(lblParametroGrafico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, -1, -1));

        lblParametroGrafico2.setBackground(new java.awt.Color(255, 255, 255));
        lblParametroGrafico2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblParametroGrafico2.setForeground(new java.awt.Color(102, 102, 102));
        lblParametroGrafico2.setText("Ordenar por:");
        panelMain.add(lblParametroGrafico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 90, 90, -1));

        lblParametroGrafico.setBackground(new java.awt.Color(255, 255, 255));
        lblParametroGrafico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblParametroGrafico.setForeground(new java.awt.Color(102, 102, 102));
        lblParametroGrafico.setText("Filtros");
        panelMain.add(lblParametroGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 60, -1, -1));
        lblParametroGrafico.getAccessibleContext().setAccessibleName("");

        jspComentarios.setBackground(new java.awt.Color(255, 255, 255));
        jspComentarios.setBorder(null);
        jspComentarios.setForeground(new java.awt.Color(255, 255, 255));

        lblComentario.setBackground(new java.awt.Color(217, 217, 217));
        lblComentario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblComentario.setForeground(new java.awt.Color(102, 102, 102));
        lblComentario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblComentario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblComentario.setOpaque(true);
        jspComentarios.setViewportView(lblComentario);

        panelMain.add(jspComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, 450, 490));

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 1, 1370, 660));

        menAlugar.setText("Locação");
        menAlugar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemVeiculos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemVeiculos.setText("Veiculos");
        itemVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVeiculosActionPerformed(evt);
            }
        });
        menAlugar.add(itemVeiculos);

        itemMinhasLocacoes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemMinhasLocacoes.setText("Minhas Locações");
        itemMinhasLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMinhasLocacoesActionPerformed(evt);
            }
        });
        menAlugar.add(itemMinhasLocacoes);

        jmHistoricoLocacoes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        menCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jmPerfl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemEditar.setText("Alterar");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        jmPerfl.add(itemEditar);

        itemExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemExcluir.setText("Excluir");
        itemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExcluirActionPerformed(evt);
            }
        });
        jmPerfl.add(itemExcluir);

        if(ConexaoDAO.getCliente().getAcesso() == 0){

            menuMain.add(jmPerfl);
        }

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemSairConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemSairConta.setText("Conta");
        itemSairConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairContaActionPerformed(evt);
            }
        });
        menuSair.add(itemSairConta);

        itemSairPrograma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemSairPrograma.setText("Programa");
        itemSairPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairProgramaActionPerformed(evt);
            }
        });
        menuSair.add(itemSairPrograma);

        menuMain.add(menuSair);

        setJMenuBar(menuMain);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemSairProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairProgramaActionPerformed
        exit(0);
    }//GEN-LAST:event_itemSairProgramaActionPerformed

    private void itemSairContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairContaActionPerformed
        dispose();
        Pessoa cliente = new Pessoa();
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

    private void jmHistoricoLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHistoricoLocacoesActionPerformed
        JFHistoricoLocacao jfHL = new JFHistoricoLocacao();
        jfHL.setVisible(true);
    }//GEN-LAST:event_jmHistoricoLocacoesActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        escolhaGrafico = (String) cmbTipo.getSelectedItem();
        apresentarGrafico(escolhaGrafico);
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        JFCadastroPessoa cliente = new JFCadastroPessoa();
        cliente.setVisible(true);
    }//GEN-LAST:event_itemEditarActionPerformed

    private void itemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExcluirActionPerformed
        int dialogConfirmar = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir sua conta?", "Excluir conta", JOptionPane.YES_NO_OPTION);
        if (dialogConfirmar == JOptionPane.YES_OPTION) {
            if (clienteDAO.deletar(ConexaoDAO.getCliente())) {
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                dispose();
                JFAutenticacao jfAutenticacao = new JFAutenticacao();
                jfAutenticacao.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão sem sucesso!");
            }
        }
    }//GEN-LAST:event_itemExcluirActionPerformed

    private void cmbNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNotaActionPerformed
        escolhaNota = (String) cmbNota.getSelectedItem();
        if (escolhaNota.equals("Selecione")) {
            apresentarGrafico("Geral");
        } else {
            apresentarNota(escolhaNota);
        }
    }//GEN-LAST:event_cmbNotaActionPerformed

    public void apresentarNota(String escolha) {
        panGrafico.removeAll();
        panGrafico.revalidate();
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();

        if (escolha.equals("Menor Nota")) {
            avaliacaoDAO.menorNota().forEach((a) -> {
                dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
            });
        } else if (escolha.equals("Maior Nota")) {
            avaliacaoDAO.maiorNota().forEach((a) -> {
                dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
            });
        }
        gerarGrafico(dpd, escolha);
        lblComentario.setText("<html>" + avaliacaoDAO.comentariosMenorNota() + "</html>");
    }

    public void apresentarGrafico(String escolha) {
        panGrafico.removeAll();
        panGrafico.revalidate();
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();

        if (escolha.equals("Geral")) {
            avaliacaoDAO.notas().forEach((a) -> {
                dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
            });

        } else {
            avaliacaoDAO.notasVeiculo(escolha).forEach((a) -> {
                dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
            });
        }
        gerarGrafico(dpd, escolha);
        lblComentario.setText("<html>" + avaliacaoDAO.comentarios(escolha) + "</html>");
    }

    public void gerarGrafico(DefaultCategoryDataset dpd, String escolha) {
        JFreeChart grafico = ChartFactory.createBarChart3D(
                "Todas as avaliações de " + escolha,
                "Notas",
                "Avaliações",
                dpd,
                PlotOrientation.VERTICAL, true, true, false);
        grafico.setBackgroundPaint(new Color(217,217,217));
        ChartPanel chartpanel = new ChartPanel(grafico);
        panGrafico.setLayout(new BorderLayout(0, 0));
        panGrafico.add(chartpanel);
    }

    public void apresentarVeiculos() {
        veiculoDAO.exibeNomeVeiculos().forEach((c) -> {
            cmbTipo.addItem(c.getNome());
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbNota;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemExcluir;
    private javax.swing.JMenuItem itemMinhasLocacoes;
    private javax.swing.JMenuItem itemSairConta;
    private javax.swing.JMenuItem itemSairPrograma;
    private javax.swing.JMenuItem itemVeiculo;
    private javax.swing.JMenuItem itemVeiculos;
    private javax.swing.JMenuItem jmHistoricoLocacoes;
    private javax.swing.JMenu jmPerfl;
    private javax.swing.JScrollPane jspComentarios;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblParametroGrafico;
    private javax.swing.JLabel lblParametroGrafico1;
    private javax.swing.JLabel lblParametroGrafico2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAlugar;
    private javax.swing.JMenu menCadastrar;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JMenu menuSair;
    private javax.swing.JPanel panGrafico;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
