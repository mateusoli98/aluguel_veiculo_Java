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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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
        apresentarGraficoGeral("" + cmbTipo.getSelectedItem());
        jspComentarios.getVerticalScrollBar().setUnitIncrement(10);
        apresentarVeiculos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        panGrafico = new javax.swing.JPanel();
        jspComentarios = new javax.swing.JScrollPane();
        lblComentario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblParametroGrafico = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblParametroGrafico1 = new javax.swing.JLabel();
        lblParametroGrafico2 = new javax.swing.JLabel();
        cmbNota = new javax.swing.JComboBox<>();
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

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panGraficoLayout = new javax.swing.GroupLayout(panGrafico);
        panGrafico.setLayout(panGraficoLayout);
        panGraficoLayout.setHorizontalGroup(
            panGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        panGraficoLayout.setVerticalGroup(
            panGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        lblComentario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jspComentarios.setViewportView(lblComentario);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Av. Brasil, 366 - Jardim Amanda - Hortolândia/SP - Locacões de Veiculos A&M - (19) 3897-3105 - Todos direitos reservados 2018");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblParametroGrafico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblParametroGrafico.setText("Filtros");

        cmbTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        lblParametroGrafico1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblParametroGrafico1.setText("Exibição por:");

        lblParametroGrafico2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblParametroGrafico2.setText("Notas:");

        cmbNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Melhor Nota", "Pior Nota" }));
        cmbNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblParametroGrafico)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblParametroGrafico1)
                            .addComponent(lblParametroGrafico2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblParametroGrafico)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParametroGrafico1)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblParametroGrafico2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblParametroGrafico.getAccessibleContext().setAccessibleName("");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jspComentarios)
                    .addComponent(panGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
        );

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
        if (escolhaGrafico.equals("Geral")) {
            apresentarGraficoGeral(escolhaGrafico);
        } else {
            apresentarGraficoVeiculo(escolhaGrafico);
        }
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
            apresentarGraficoGeral("Geral");
        } else if (escolhaNota.equals("Melhor Nota")) {
            apresentarMelhorNota(escolhaNota);
        } else if (escolhaGrafico.equals("Pior Nota")) {

        }
    }//GEN-LAST:event_cmbNotaActionPerformed

    public void apresentarMelhorNota(String escolha) {
        panGrafico.removeAll();
        panGrafico.revalidate();
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();
        for (Avaliacao a : avaliacaoDAO.melhorNota()) {
            dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");

        }

        JFreeChart grafico = ChartFactory.createBarChart3D("Todas as avaliações de nossos clientes", "Notas", "Quantidade de Avaliações", dpd, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(grafico);
        chartpanel.setBackground(Color.BLACK);
        panGrafico.setLayout(new BorderLayout(0, 0));
        panGrafico.add(chartpanel);

        lblComentario.setText("<html>" + avaliacaoDAO.comentariosMelhorNota() + "</html>");
    }

    public void apresentarGraficoGeral(String escolha) {
        panGrafico.removeAll();
        panGrafico.revalidate();
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();
        for (Avaliacao a : avaliacaoDAO.notas()) {
            dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
        }

        JFreeChart grafico = ChartFactory.createBarChart3D("Todas as avaliações de nossos clientes", "Notas", "Quantidade de Avaliações", dpd, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(grafico);
        chartpanel.setBackground(Color.BLACK);
        panGrafico.setLayout(new BorderLayout(0, 0));
        panGrafico.add(chartpanel);

        lblComentario.setText("<html>" + avaliacaoDAO.comentarios(escolha) + "</html>");
    }

    public void apresentarGraficoVeiculo(String escolha) {
        panGrafico.removeAll();
        panGrafico.revalidate();
        DefaultCategoryDataset dpd = new DefaultCategoryDataset();
        for (Avaliacao a : avaliacaoDAO.notasVeiculo(escolha)) {
            dpd.setValue(a.getQtdAvaliacao(), "     " + a.getNumAvaliacao(), "");
        }
        JFreeChart grafico = ChartFactory.createBarChart3D("Todas as avaliações de " + escolha, "Notas", "Avaliações", dpd, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(grafico);
        chartpanel.setBackground(Color.BLACK);
        panGrafico.setLayout(new BorderLayout(0, 0));
        panGrafico.add(chartpanel);
        lblComentario.setText("<html>" + avaliacaoDAO.comentarios(escolha) + "</html>");
    }

    public void apresentarVeiculos() {
        for (Veiculo c : veiculoDAO.exibeNomeVeiculos()) {
            cmbTipo.addItem(c.getNome());
        }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
    // End of variables declaration//GEN-END:variables
}
