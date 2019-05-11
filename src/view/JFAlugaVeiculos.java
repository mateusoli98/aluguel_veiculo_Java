package view;

import controller.Validacoes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Boleto;
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
    int diaInicio, diaFim;
    double valorVeiculo;
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
        panDetalhesPedido.setBorder(tituloPanel("Detalhes Pedido"));
        panFormaPagamentio.setBorder(tituloPanel("Formas de Pagamento"));
        habilitaPanels(false);
        mudaEstadoCampos(false);

        btnSalvar.setEnabled(false);
        btnCancelarCadastoCartao.setEnabled(false);
    }

    void novoCartao() {
        cmbCartoes.removeAllItems();
        cmbCartoes.addItem("**Selcione**");
        cmbCartoes.addItem("MASTERCARD");
        cmbCartoes.addItem("VISA");
        cmbCartoes.addItem("ELO");
        txtNumero.setText("");
        txtCVV.setText("");
        txtDataVencimento.setText("");
        radBoleto.setSelected(false);
        btnConfirmarPagamento.setEnabled(false);
        cmbVezes.setEnabled(false);

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
                objVeiculo.getAno(),
                objVeiculo.getValor(),});
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
        chkDataAtual.setVisible(true);
    }

    void mudaEstadoCampos(boolean flag) {
        radNovo.setEnabled(flag);
        radExistente.setEnabled(flag);
        cmbCartoes.setEnabled(flag);
        txtNumero.setEnabled(flag);
        txtCVV.setEnabled(flag);
        txtDataVencimento.setEnabled(flag);

        cmbVezes.setEnabled(flag);
    }

    void desabilitaCamposCotacao() {
        txtDataInicio.setVisible(false);
        txtDataTermino.setVisible(false);
        txtDataInicio.setText("");
        txtDataTermino.setText("");
        lblDataFim.setVisible(false);
        lblDataInicio.setVisible(false);
        chkDataAtual.setVisible(false);
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

    String calcAluguel() {
        String valor = "";
        valorVeiculo = (Double) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 6);
        valor = "" + valorVeiculo * retornaDias();
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
            cmbVezes.addItem(i + " x " + Math.round(result));

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

    int dialogoConfirmacao(String texto) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        return JOptionPane.showConfirmDialog(null, texto, "Confirmação", dialogButton);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNomeVeiculo = new javax.swing.JTextField();
        lblSemPedidos = new javax.swing.JLabel();
        panDetalhesPedido = new javax.swing.JPanel();
        lblNomeVeiculo = new javax.swing.JLabel();
        lblValorDataLocacao = new javax.swing.JLabel();
        lblValorPedido = new javax.swing.JLabel();
        lblVeiculo = new javax.swing.JLabel();
        lblDataLocacao = new javax.swing.JLabel();
        lblPedido = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JFormattedTextField();
        chkDataAtual = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();
        txtDataTermino = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        lblVerFotos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDataInicio = new javax.swing.JLabel();
        lblDataFim = new javax.swing.JLabel();
        btnConfirmarPedido = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        lblValorAluguel = new javax.swing.JLabel();
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
        cmbTipoVeiculo = new javax.swing.JComboBox<>();
        lblMoeda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locação Veiculo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomeVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNomeVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeVeiculoKeyReleased(evt);
            }
        });
        jPanel1.add(txtNomeVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 37, 185, -1));

        lblSemPedidos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSemPedidos.setForeground(new java.awt.Color(102, 102, 102));
        lblSemPedidos.setText("Nenhum pedido confirmado");
        jPanel1.add(lblSemPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 150, -1, -1));

        panDetalhesPedido.setBackground(new java.awt.Color(255, 255, 255));
        panDetalhesPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomeVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNomeVeiculo.setText("...");
        panDetalhesPedido.add(lblNomeVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 11, 280, -1));

        lblValorDataLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblValorDataLocacao.setText("...");
        panDetalhesPedido.add(lblValorDataLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 39, 280, -1));

        lblValorPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblValorPedido.setText("...");
        panDetalhesPedido.add(lblValorPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 67, 270, -1));

        lblVeiculo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo.setText("Veiculo:");
        panDetalhesPedido.add(lblVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblDataLocacao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDataLocacao.setText("Data locação:");
        panDetalhesPedido.add(lblDataLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, -1, -1));

        lblPedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPedido.setText("Valor pedido");
        panDetalhesPedido.add(lblPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));

        jPanel1.add(panDetalhesPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 37, 600, 100));

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
        jPanel1.add(txtDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 130, -1));

        chkDataAtual.setBackground(new java.awt.Color(217, 217, 217));
        chkDataAtual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkDataAtual.setText("Usar Data Atual");
        chkDataAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDataAtualActionPerformed(evt);
            }
        });
        jPanel1.add(chkDataAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(197, 36, 39));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 130, 40));

        tableVeiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableVeiculos.setForeground(new java.awt.Color(102, 102, 102));
        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chassi", "Nome", "Modelo", "Marca", "Combustivel", "Ano", "valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVeiculos.setGridColor(new java.awt.Color(255, 255, 255));
        tableVeiculos.setSelectionBackground(new java.awt.Color(1, 111, 185));
        tableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVeiculos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 89, 706, 255));

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
        jPanel1.add(txtDataTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 130, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de Veiculo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 42, -1, -1));

        lblVerFotos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblVerFotos.setText("Foto do Veiculo");
        lblVerFotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerFotosMouseClicked(evt);
            }
        });
        jPanel1.add(lblVerFotos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Veiculo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 40, -1, -1));

        lblDataInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataInicio.setText("Data Inicio");
        jPanel1.add(lblDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        lblDataFim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataFim.setText("Data Terminio");
        jPanel1.add(lblDataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        btnConfirmarPedido.setBackground(new java.awt.Color(1, 111, 185));
        btnConfirmarPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirmarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarPedido.setText("Confirmar Pedido");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 150, 40));

        btnCalcular.setBackground(new java.awt.Color(19, 138, 54));
        btnCalcular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setText("Calcular");
        btnCalcular.setBorder(null);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 130, 40));

        lblValorAluguel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblValorAluguel.setForeground(new java.awt.Color(102, 102, 102));
        lblValorAluguel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(lblValorAluguel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 80, 42));

        panFormaPagamentio.setBackground(new java.awt.Color(255, 255, 255));
        panFormaPagamentio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panFormaPagamentio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radBoleto.setBackground(new java.awt.Color(255, 255, 255));
        radBoleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radBoleto.setSelected(true);
        radBoleto.setText("Boleto");
        radBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBoletoActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(radBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 29, 126, -1));

        radCartao.setBackground(new java.awt.Color(255, 255, 255));
        radCartao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radCartao.setText("Cartão crédito");
        radCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCartaoActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(radCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 29, 126, -1));

        btnConfirmarPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirmarPagamento.setText("Confirmar Pagamento");
        btnConfirmarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPagamentoActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(btnConfirmarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 371, -1, -1));

        radExistente.setBackground(new java.awt.Color(255, 255, 255));
        radExistente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radExistente.setText("Existente");
        radExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radExistenteActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(radExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 72, 126, -1));

        radNovo.setBackground(new java.awt.Color(255, 255, 255));
        radNovo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radNovo.setSelected(true);
        radNovo.setText("Novo");
        radNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNovoActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(radNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 72, 126, -1));

        txtNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });
        panFormaPagamentio.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 185, -1));

        lblVeiculo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo1.setText("Numero");
        panFormaPagamentio.add(lblVeiculo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 177, -1, -1));

        txtCVV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCVV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCVVKeyReleased(evt);
            }
        });
        panFormaPagamentio.add(txtCVV, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 39, -1));

        lblVeiculo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo2.setText("CVV");
        panFormaPagamentio.add(lblVeiculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 180, -1, -1));

        lblVeiculo3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo3.setText("Vencimento");
        panFormaPagamentio.add(lblVeiculo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 180, -1, -1));

        cmbCartoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*Selecione um cartao*", " " }));
        cmbCartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCartoesActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(cmbCartoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 138, 185, -1));

        lblVeiculo4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo4.setText("Cartao");
        panFormaPagamentio.add(lblVeiculo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 115, -1, -1));

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 313, 99, -1));

        btnCancelarCadastoCartao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarCadastoCartao.setText("Cancelar");
        btnCancelarCadastoCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastoCartaoActionPerformed(evt);
            }
        });
        panFormaPagamentio.add(btnCancelarCadastoCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 313, 99, -1));

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panFormaPagamentio.add(txtDataVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 202, 55, -1));

        lblVeiculo5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVeiculo5.setText("Numero de Parcelas");
        panFormaPagamentio.add(lblVeiculo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 241, -1, -1));

        cmbVezes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*Selecione*", "1", "2", "3", "4", "5" }));
        panFormaPagamentio.add(cmbVezes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 264, 185, -1));

        jPanel1.add(panFormaPagamentio, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 600, 430));

        cmbTipoVeiculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**", "Carro", "Moto" }));
        cmbTipoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVeiculoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbTipoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 39, 138, -1));

        lblMoeda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMoeda.setForeground(new java.awt.Color(102, 102, 102));
        lblMoeda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMoeda.setText("Valor atual:");
        jPanel1.add(lblMoeda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 120, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeVeiculoKeyReleased
        nomeVeiculo = txtNomeVeiculo.getText();
        if (!nomeVeiculo.equals("")) {
            dadosTabelNomeVeiculo(nomeVeiculo);
        } else {
            carregaDadosTable();
        }
    }//GEN-LAST:event_txtNomeVeiculoKeyReleased

    private void txtDataInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataInicioMouseClicked
        //Posiciona cursor no inicio do campo, evitando escrever no meio da data
        txtDataInicio.setCaretPosition(0);
    }//GEN-LAST:event_txtDataInicioMouseClicked

    private void chkDataAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDataAtualActionPerformed
        if (chkDataAtual.isSelected()) {
            txtDataInicio.setEnabled(false);
            txtDataInicio.setText(objValidacao.dataAtual());
        } else {
            txtDataInicio.setEnabled(true);
            txtDataInicio.setText("");
        }
    }//GEN-LAST:event_chkDataAtualActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        lblSemPedidos.setVisible(true);
        habilitaPanels(false);
        btnConfirmarPedido.setEnabled(true);
        removeInfoPanels();
        lblMoeda.setVisible(false);
        lblValorAluguel.setVisible(false);
        btnConfirmarPedido.setVisible(false);
        btnCancelar.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVeiculosMouseClicked
        lblVerFotos.setVisible(true);
        lblVerFotos.setText("<html><u>Ver foto do veiculo</u></html>");
        habilitaCamposCotacao();
    }//GEN-LAST:event_tableVeiculosMouseClicked

    private void txtDataTerminoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataTerminoMouseClicked
        //Posiciona cursor no inicio do campo, evitando escrever no meio da data
        txtDataTermino.setCaretPosition(0);
    }//GEN-LAST:event_txtDataTerminoMouseClicked

    private void lblVerFotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerFotosMouseClicked
        int idVeiculo = (int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 0);
        JFFotos fotos = new JFFotos(idVeiculo);
        fotos.setVisible(true);
    }//GEN-LAST:event_lblVerFotosMouseClicked

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
        lblSemPedidos.setVisible(false);
        preencheObjeto();
        btnConfirmarPedido.setEnabled(false);
        habilitaPanels(true);
        insereInfoPanels();
        panFormaPagamentio.setVisible(true);
        lblSemPedidos.setVisible(false);
    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (objValidacao.validaData(txtDataInicio.getText(), txtDataTermino.getText())) {;
            habilitaCamposContratacao();

            lblValorAluguel.setText(calcAluguel());
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void radBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBoletoActionPerformed
        mudaEstadoCampos(false);
        radCartao.setSelected(false);
        btnSalvar.setEnabled(false);
        btnCancelarCadastoCartao.setEnabled(false);
        btnConfirmarPagamento.setEnabled(true);
    }//GEN-LAST:event_radBoletoActionPerformed

    private void radCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCartaoActionPerformed
        mudaEstadoCampos(true);
        novoCartao();
        btnSalvar.setEnabled(true);
        btnCancelarCadastoCartao.setEnabled(true);
    }//GEN-LAST:event_radCartaoActionPerformed

    private void btnConfirmarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPagamentoActionPerformed

        if (radBoleto.isSelected()) {
            if (dialogoConfirmacao("Confirma pagamento em boleto") == JOptionPane.YES_OPTION) {
                if (objVeiculoDAO.realizaLocacao(objLoc)) {
                    dispose();
                    Boleto boleto = new Boleto();
                    boleto.setDataVencimento(objValidacao.dataAtual());
                    boleto.setNumPedido(numberRandom.hashCode());
                    boleto.setTotalPedido(Double.parseDouble(calcAluguel()));
                    JFBoleto frmBoleto = new JFBoleto(boleto);
                    frmBoleto.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Locação não finalizada, tente novamente!");
                }
            }

        } else if (radCartao.isSelected()) {

            if (!cmbCartoes.getSelectedItem().equals("*Selecione um cartao*") && !cmbVezes.getSelectedItem().equals("*Selecione*")
                    && !txtNumero.getText().isEmpty() && !txtDataVencimento.getText().isEmpty() && !txtCVV.getText().isEmpty()) {
                if (dialogoConfirmacao("Confirma pagamento com cartão de crédito " + cmbCartoes.getSelectedItem()) == JOptionPane.YES_OPTION) {
                    if (objVeiculoDAO.realizaLocacao(objLoc)) {
                        JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso! \n*Dica: Para consultar suas locações, abra o menu de Locações e em seguida o sub-menu de Minhas Locações", "Confirmação de Pagamenro", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Locação não finalizada, tente novamente!");
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Preencha TODOS os campos!");
            }
        }
    }//GEN-LAST:event_btnConfirmarPagamentoActionPerformed

    private void radExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radExistenteActionPerformed
        cmbCartoes.removeAllItems();
        preencheCartoes();
        setaVezes();
        radNovo.setSelected(false);
        btnSalvar.setEnabled(false);
        btnCancelarCadastoCartao.setEnabled(false);
        cmbVezes.setEnabled(true);
        btnConfirmarPagamento.setEnabled(true);
    }//GEN-LAST:event_radExistenteActionPerformed

    private void radNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNovoActionPerformed
        novoCartao();
        radExistente.setSelected(false);

        btnSalvar.setEnabled(true);
        btnCancelarCadastoCartao.setEnabled(true);
    }//GEN-LAST:event_radNovoActionPerformed

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtCVVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCVVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCVVKeyReleased

    private void cmbCartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCartoesActionPerformed
        if (radExistente.isSelected()) {
            cartao.exibeCartaoId(cmbCartoes.getSelectedIndex()).forEach((c) -> {
                txtNumero.setText("" + c.getNumero());
                txtDataVencimento.setText(c.getDataVencimento());
                txtCVV.setText("" + c.getCvv());

            });
        }
    }//GEN-LAST:event_cmbCartoesActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificaCampos()) {
            preencheCartao();
            if (cartao.cadastroCartao(c)) {
                preencheCartoes();
                radNovo.setSelected(false);
                radExistente.setSelected(true);
                cmbCartoes.setSelectedItem(cartao.exibeUltimoCartao() + " - " + c.getBandeira());
                btnSalvar.setEnabled(false);
                btnCancelarCadastoCartao.setEnabled(false);
                cmbVezes.setEnabled(true);
                btnConfirmarPagamento.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Cartão cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro insperado. \nPor favor, tente mais tarde!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta faltando campos");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarCadastoCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastoCartaoActionPerformed

    }//GEN-LAST:event_btnCancelarCadastoCartaoActionPerformed

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

    boolean verificaCampos() {
        if (txtCVV.getText().isEmpty() || txtDataVencimento.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarCadastoCartao;
    private javax.swing.JButton btnConfirmarPagamento;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkDataAtual;
    private javax.swing.JComboBox<String> cmbCartoes;
    private javax.swing.JComboBox<String> cmbTipoVeiculo;
    private javax.swing.JComboBox<String> cmbVezes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataLocacao;
    private javax.swing.JLabel lblMoeda;
    private javax.swing.JLabel lblNomeVeiculo;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblSemPedidos;
    private javax.swing.JLabel lblValorAluguel;
    private javax.swing.JLabel lblValorDataLocacao;
    private javax.swing.JLabel lblValorPedido;
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
