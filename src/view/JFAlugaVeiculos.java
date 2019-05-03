package view;

import controller.Validacoes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cartao;
import model.DAO.CartaoDAO;
import model.Locacao;
import model.Veiculo;
import model.DAO.ConexaoDAO;
import model.DAO.VeiculoDAO;

public class JFAlugaVeiculos extends javax.swing.JFrame {

    Veiculo objVeiculo = new Veiculo();
    VeiculoDAO objVeiculoDAO = new VeiculoDAO();
    Locacao objLoc = new Locacao();
    CartaoDAO cartao = new CartaoDAO();
    Cartao c = new Cartao();
    String operacao = "", tipoVeiculo = "", nomeVeiculo, dtInicio, dtTermino;
    DefaultTableModel dtmDefault = new DefaultTableModel();
    int diaInicio, diaFim, anoVeiculo;
    Validacoes objValidacao = new Validacoes();
    Random numberRandom = new Random();

    public JFAlugaVeiculos() {
        initComponents();
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        tableVeiculos.setRowSorter(new TableRowSorter(dtmDefault));
        carregaDadosTable();
        desabilitaCamposCotacao();
        desabilitaCamposContratacao();
        lblVerFotos.setVisible(false);
        preencheCartoes();
        camposCartao(false);
        consisteRadios(false);
        panDetalhesPedido.setBorder(tituloPanel("Detalhes Pedido"));
        panFormaPagamentio.setBorder(tituloPanel(""));
        habilitaPanels(false);
        radNovo.setSelected(true);
         radExistente.setSelected(false);

    }

    void habilitaPanels(boolean flag) {
        panDetalhesPedido.setVisible(flag);
        panFormaPagamentio.setVisible(flag);
    }

    void insereInfoPanels() {
        lblNomeVeiculo.setText(objLoc.getNomeVeiculo());
        lblValorDataLocacao.setText(objValidacao.converteDatasTable(objLoc.getDtInicio()) + " - " + objValidacao.converteDatasTable(objLoc.getDtTermino()) + " - " + retornaDias() + " dias.");
        lblValorPedido.setText(calcAluguel() + " reais.");
    }

    void removeInfoPanels() {
        lblNomeVeiculo.setText("");
        lblValorDataLocacao.setText("");
        lblValorAluguel.setText("");
    }

    TitledBorder tituloPanel(String titulo) {
        TitledBorder border = new TitledBorder(titulo);
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);

        return border;
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

    void consisteRadios(boolean te) {
        radBoleto.setSelected(!te);
        radCartao.setSelected(te);
        radNovo.setEnabled(te);
        radExistente.setEnabled(te);
        cmbCartoes.setEnabled(te);
        txtNumero.setEnabled(te);
        txtCVV.setEnabled(te);
        txtDataVencimento.setEnabled(te);
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
        btnConfirmarPedido.setVisible(true);
        btnCancelar.setVisible(true);
    }

    void desabilitaCamposContratacao() {
        lblMoeda.setVisible(false);
        lblValorAluguel.setVisible(false);
        btnConfirmarPedido.setVisible(false);
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

    void camposCartao(boolean flag) {
        txtNumero.setEnabled(flag);
        txtCVV.setEnabled(flag);
        txtDataVencimento.setEnabled(flag);
    }

    String calcAluguel() {
        String valor = "";
        anoVeiculo = (int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 5);
        if (anoVeiculo <= 2005) {
            valor = "" + retornaDias() * 50.00;
        }

        if (anoVeiculo > 2005) {
            valor = "" + retornaDias() * 100.00;

        }
        return valor;
    }

    void setaVezes() {
        int i;
        double result;
        cmbVezes.removeAllItems();
        cmbVezes.addItem("**Selecione um cartao**");

        for (i = 1; i <= 5; i++) {
            c.setNmrParcela(cmbVezes.getSelectedIndex());
            result = Double.parseDouble(calcAluguel()) / i;
            cmbVezes.addItem("(" + i + ") " + Math.round(result));

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

    void preencheCartao() {
        c.setNumero(Integer.parseInt(txtNumero.getText()));
        c.setBandeira("" + cmbCartoes.getSelectedItem());
        c.setCvv(Integer.parseInt(txtCVV.getText()));
        c.setDataVencimento(txtDataVencimento.getText());
        c.setCodPessoa(ConexaoDAO.getCliente().getCodigo());
        
    }

    void preencheCartoes() {
        cmbCartoes.removeAllItems();
        cmbCartoes.addItem("**Selecione um cartao**");
        cartao.exibeCartoes().forEach((c) -> {
            cmbCartoes.addItem(c.getCodigo() + " - " + c.getBandeira());
        });
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
        btnConfirmarPedido = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblMoeda = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataTermino = new javax.swing.JFormattedTextField();
        lblValorAluguel = new javax.swing.JLabel();
        lblVerFotos = new javax.swing.JLabel();
        panDetalhesPedido = new javax.swing.JPanel();
        lblNomeVeiculo = new javax.swing.JLabel();
        lblValorDataLocacao = new javax.swing.JLabel();
        lblValorPedido = new javax.swing.JLabel();
        lblVeiculo = new javax.swing.JLabel();
        lblDataLocacao = new javax.swing.JLabel();
        lblPedido = new javax.swing.JLabel();
        lblSemPedidos = new javax.swing.JLabel();
        panFormaPagamentio = new javax.swing.JPanel();
        radBoleto = new javax.swing.JRadioButton();
        radCartao = new javax.swing.JRadioButton();
        btnConfirmarPagamento = new javax.swing.JButton();
        radExistente = new javax.swing.JRadioButton();
        radNovo = new javax.swing.JRadioButton();
        txtNumero = new javax.swing.JTextField();
        lblVeiculo1 = new javax.swing.JLabel();
        txtCVV = new javax.swing.JTextField();
        lblVeiculo2 = new javax.swing.JLabel();
        lblVeiculo3 = new javax.swing.JLabel();
        cmbCartoes = new javax.swing.JComboBox<>();
        lblVeiculo4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelarCadastoCartao = new javax.swing.JButton();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        lblVeiculo5 = new javax.swing.JLabel();
        cmbVezes = new javax.swing.JComboBox<>();
        lblValorTotal = new javax.swing.JLabel();
        lblTaxas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locação Veiculo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 80, 706, 156));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de Veiculo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 42, -1, -1));

        cmbTipoVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**", "Carro", "Moto" }));
        cmbTipoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVeiculoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 39, 138, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nome Veiculo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 42, -1, -1));

        txtNomeVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNomeVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeVeiculoKeyReleased(evt);
            }
        });
        getContentPane().add(txtNomeVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 39, 185, -1));

        lblDataInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataInicio.setText("Data Inicio");
        getContentPane().add(lblDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 299, -1, -1));

        lblDataFim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataFim.setText("Data Terminio");
        getContentPane().add(lblDataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 299, -1, -1));

        btnConfirmarPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirmarPedido.setText("Confirmar Pedido");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 439, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 475, -1, -1));

        lblMoeda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMoeda.setForeground(new java.awt.Color(0, 153, 0));
        lblMoeda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMoeda.setText("R$");
        getContentPane().add(lblMoeda, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 396, 28, 42));

        btnCalcular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 363, -1, 27));

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
        getContentPane().add(txtDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 322, 91, -1));

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
        getContentPane().add(txtDataTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 322, 89, -1));

        lblValorAluguel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblValorAluguel.setForeground(new java.awt.Color(0, 153, 0));
        lblValorAluguel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lblValorAluguel, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 396, 93, 42));

        lblVerFotos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblVerFotos.setText("Foto do Veiculo");
        lblVerFotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerFotosMouseClicked(evt);
            }
        });
        getContentPane().add(lblVerFotos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 254, -1, -1));

        panDetalhesPedido.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNomeVeiculo.setText("...");

        lblValorDataLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblValorDataLocacao.setText("...");

        lblValorPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblValorPedido.setText("...");

        lblVeiculo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo.setText("Veiculo:");

        lblDataLocacao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDataLocacao.setText("Data locação:");

        lblPedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPedido.setText("Valor pedido");

        javax.swing.GroupLayout panDetalhesPedidoLayout = new javax.swing.GroupLayout(panDetalhesPedido);
        panDetalhesPedido.setLayout(panDetalhesPedidoLayout);
        panDetalhesPedidoLayout.setHorizontalGroup(
            panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetalhesPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPedido)
                    .addComponent(lblDataLocacao)
                    .addComponent(lblVeiculo))
                .addGap(10, 10, 10)
                .addGroup(panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomeVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(lblValorDataLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblValorPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        panDetalhesPedidoLayout.setVerticalGroup(
            panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetalhesPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeVeiculo)
                    .addComponent(lblVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorDataLocacao)
                    .addComponent(lblDataLocacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDetalhesPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorPedido)
                    .addComponent(lblPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panDetalhesPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 39, 741, -1));

        lblSemPedidos.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblSemPedidos.setText("Sem pedidos");
        getContentPane().add(lblSemPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, -1, -1));

        panFormaPagamentio.setBackground(new java.awt.Color(255, 255, 255));

        radBoleto.setBackground(new java.awt.Color(255, 255, 255));
        radBoleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radBoleto.setSelected(true);
        radBoleto.setText("Boleto");
        radBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBoletoActionPerformed(evt);
            }
        });

        radCartao.setBackground(new java.awt.Color(255, 255, 255));
        radCartao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radCartao.setText("Cartão crédito");
        radCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCartaoActionPerformed(evt);
            }
        });

        btnConfirmarPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirmarPagamento.setText("Confirmar Pagamento");
        btnConfirmarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPagamentoActionPerformed(evt);
            }
        });

        radExistente.setBackground(new java.awt.Color(255, 255, 255));
        radExistente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radExistente.setSelected(true);
        radExistente.setText("Existente");
        radExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radExistenteActionPerformed(evt);
            }
        });

        radNovo.setBackground(new java.awt.Color(255, 255, 255));
        radNovo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radNovo.setText("Novo");
        radNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNovoActionPerformed(evt);
            }
        });

        txtNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });

        lblVeiculo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo1.setText("Numero");

        txtCVV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCVV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCVVKeyReleased(evt);
            }
        });

        lblVeiculo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo2.setText("CVV");

        lblVeiculo3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo3.setText("Vencimento");

        cmbCartoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*Selecione um cartao*", " " }));
        cmbCartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCartoesActionPerformed(evt);
            }
        });

        lblVeiculo4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo4.setText("Cartao");

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelarCadastoCartao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarCadastoCartao.setText("Cancelar");
        btnCancelarCadastoCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastoCartaoActionPerformed(evt);
            }
        });

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblVeiculo5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo5.setText("Numero de Parcelas");

        cmbVezes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*Selecione*", "1", "2", "3", "4", "5" }));
        cmbVezes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVezesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFormaPagamentioLayout = new javax.swing.GroupLayout(panFormaPagamentio);
        panFormaPagamentio.setLayout(panFormaPagamentioLayout);
        panFormaPagamentioLayout.setHorizontalGroup(
            panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVeiculo5)
                            .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbVezes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblVeiculo1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(cmbCartoes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblVeiculo4))
                                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lblVeiculo3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblVeiculo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarCadastoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                                .addComponent(radExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(radNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(radBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormaPagamentioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmarPagamento)
                .addGap(272, 272, 272))
        );
        panFormaPagamentioLayout.setVerticalGroup(
            panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radBoleto)
                    .addComponent(radCartao))
                .addGap(28, 28, 28)
                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radExistente)
                    .addComponent(radNovo))
                .addGap(10, 10, 10)
                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                        .addComponent(lblVeiculo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCartoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVeiculo3)
                                    .addComponent(lblVeiculo2))
                                .addGap(26, 26, 26))))
                    .addGroup(panFormaPagamentioLayout.createSequentialGroup()
                        .addComponent(lblVeiculo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblVeiculo5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFormaPagamentioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelarCadastoCartao))
                .addGap(75, 75, 75)
                .addComponent(btnConfirmarPagamento)
                .addGap(24, 24, 24))
        );

        getContentPane().add(panFormaPagamentio, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 750, 410));

        lblValorTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblValorTotal.setText("...");
        getContentPane().add(lblValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 262, 73, -1));

        lblTaxas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTaxas.setText("Total + Taxas:  ");
        getContentPane().add(lblTaxas, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 299, -1, -1));

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
        lblVerFotos.setVisible(true);
        lblVerFotos.setText("<html><u>Ver foto do veiculo</u></html>");
        habilitaCamposCotacao();
    }//GEN-LAST:event_tableVeiculosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        lblSemPedidos.setVisible(false);
        habilitaPanels(false);
        btnConfirmarPedido.setEnabled(true);
        removeInfoPanels();
        panFormaPagamentio.setBorder(tituloPanel(""));;


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (objValidacao.validaData(txtDataInicio.getText(), txtDataTermino.getText())) {;
            habilitaCamposContratacao();
            lblValorAluguel.setText(calcAluguel());
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
        lblSemPedidos.setVisible(false);
        preencheObjeto();
        btnConfirmarPedido.setEnabled(false);
        habilitaPanels(true);
        insereInfoPanels();
        panFormaPagamentio.setBorder(tituloPanel("Forma de pagamento"));

        panFormaPagamentio.setVisible(true);
        lblSemPedidos.setVisible(false);
//        if (objVeiculoDAO.realizaLocacao(objLoc)) {
//            desabilitaCamposContratacao();
//            desabilitaCamposCotacao();
//            carregaDadosTable();
//            JFNotaPedido frmPedidoConfirmado = new JFNotaPedido(objLoc);
//            frmPedidoConfirmado.setVisible(true);
//            frmPedidoConfirmado.setLocationRelativeTo(null);
//        } else {
//            JOptionPane.showMessageDialog(null, "Locação não finalizada, tente novamente!");
//        }

    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    boolean verificaCampos() {
        if (txtCVV.getText().isEmpty() || txtDataVencimento.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    private void txtDataInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataInicioMouseClicked
        //Posiciona cursor no inicio do campo, evitando escrever no meio da data
        txtDataInicio.setCaretPosition(0);
    }//GEN-LAST:event_txtDataInicioMouseClicked

    private void txtDataTerminoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataTerminoMouseClicked
        //Posiciona cursor no inicio do campo, evitando escrever no meio da data
        txtDataTermino.setCaretPosition(0);
    }//GEN-LAST:event_txtDataTerminoMouseClicked

    private void lblVerFotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerFotosMouseClicked
        int idVeiculo = (int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 0);
        JFFotos fotos = new JFFotos(idVeiculo);
        fotos.setVisible(true);
    }//GEN-LAST:event_lblVerFotosMouseClicked

    private void btnConfirmarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPagamentoActionPerformed
        if (radBoleto.isSelected()) {

        } else {
            if (cmbCartoes.getSelectedItem().equals("*Selecione um cartao*") && cmbVezes.getSelectedItem().equals("*Selecione*")) {
                
            }else{
                JOptionPane.showMessageDialog(null, numberRandom.hashCode()+"  "+c.getNmrParcela());
            }
            
        }

    }//GEN-LAST:event_btnConfirmarPagamentoActionPerformed

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtCVVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCVVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCVVKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificaCampos()) {
            preencheCartao();
            if (cartao.cadastroCartao(c)) {
                JOptionPane.showMessageDialog(null, "Deu certo");
                preencheCartoes();
                radNovo.setSelected(false);
                radExistente.setSelected(true);
                cmbCartoes.setSelectedItem(cartao.exibeUltimoCartao() + " - " + c.getBandeira());

            } else {
                JOptionPane.showMessageDialog(null, "Deu errado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta faltando campos");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarCadastoCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastoCartaoActionPerformed

    }//GEN-LAST:event_btnCancelarCadastoCartaoActionPerformed

    private void radNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNovoActionPerformed
        cmbCartoes.removeAllItems();
        cmbCartoes.addItem("**Selcione**");
        cmbCartoes.addItem("MASTERCARD");
        cmbCartoes.addItem("VISA");
        cmbCartoes.addItem("ELO");
        radExistente.setSelected(false);
        txtNumero.setText("");
        txtCVV.setText("");
        txtDataVencimento.setText("");
        camposCartao(true);
        btnSalvar.setEnabled(true);
        btnCancelarCadastoCartao.setEnabled(true);


    }//GEN-LAST:event_radNovoActionPerformed

    private void radExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radExistenteActionPerformed
        cmbCartoes.removeAllItems();
        radNovo.setSelected(false);
        camposCartao(false);
        preencheCartoes();
        setaVezes();
        btnSalvar.setEnabled(false);
        btnCancelarCadastoCartao.setEnabled(false);

    }//GEN-LAST:event_radExistenteActionPerformed

    private void radBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBoletoActionPerformed
        consisteRadios(false);
    }//GEN-LAST:event_radBoletoActionPerformed

    private void radCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCartaoActionPerformed
        consisteRadios(true);
        radExistente.enable();
        radNovo.enable();
    }//GEN-LAST:event_radCartaoActionPerformed

    private void cmbCartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCartoesActionPerformed
        cartao.exibeCartaoId(cmbCartoes.getSelectedIndex()).forEach((c) -> {
            txtNumero.setText("" + c.getNumero());
            txtDataVencimento.setText(c.getDataVencimento());
            txtCVV.setText("" + c.getCvv());

        });

    }//GEN-LAST:event_cmbCartoesActionPerformed

    private void cmbVezesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVezesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVezesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarCadastoCartao;
    private javax.swing.JButton btnConfirmarPagamento;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCartoes;
    private javax.swing.JComboBox<String> cmbTipoVeiculo;
    private javax.swing.JComboBox<String> cmbVezes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataLocacao;
    private javax.swing.JLabel lblMoeda;
    private javax.swing.JLabel lblNomeVeiculo;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblSemPedidos;
    private javax.swing.JLabel lblTaxas;
    private javax.swing.JLabel lblValorAluguel;
    private javax.swing.JLabel lblValorDataLocacao;
    private javax.swing.JLabel lblValorPedido;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblVeiculo;
    private javax.swing.JLabel lblVeiculo1;
    private javax.swing.JLabel lblVeiculo2;
    private javax.swing.JLabel lblVeiculo3;
    private javax.swing.JLabel lblVeiculo4;
    private javax.swing.JLabel lblVeiculo5;
    private javax.swing.JLabel lblVerFotos;
    private javax.swing.JPanel panDetalhesPedido;
    private javax.swing.JPanel panFormaPagamentio;
    private javax.swing.JRadioButton radBoleto;
    private javax.swing.JRadioButton radCartao;
    private javax.swing.JRadioButton radExistente;
    private javax.swing.JRadioButton radNovo;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JTextField txtCVV;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JFormattedTextField txtDataTermino;
    private javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtNomeVeiculo;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
