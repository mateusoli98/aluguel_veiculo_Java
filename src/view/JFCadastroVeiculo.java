package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Veiculo;
import model.DAO.VeiculoDAO;

public class JFCadastroVeiculo extends javax.swing.JFrame {

    Veiculo veiculo = new Veiculo();
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    DefaultTableModel dtmDefault = new DefaultTableModel();

    BufferedImage imagemBuffer;
    ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
    byte[] byteArray;

    public JFCadastroVeiculo() {
        initComponents();
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        tableVeiculos.setRowSorter(new TableRowSorter(dtmDefault));
        carregaDadosTable();
        lblRequireAno.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCombustivel = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lbAno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        lblModelo1 = new javax.swing.JLabel();
        cmbModelo = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        cmbCombustivel = new javax.swing.JComboBox<>();
        txtAno = new javax.swing.JTextField();
        lblRequireAno = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNome.setText("Veiculo");

        txtNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblCombustivel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCombustivel.setText("Combústivel");

        lblModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblModelo.setText("Modelo");

        txtMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMarca.setText("Marca");

        lbAno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbAno.setText("Ano");

        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chassi", "Nome", "Tipo", "Modelo", "Marca", "Combústivel", "Ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        btnCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeletar.setText("Remover");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        lblModelo1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblModelo1.setText("Tipo");

        cmbModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**" }));

        cmbTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**", "Carro", "Moto" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        cmbCombustivel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "**Selecione**", "Alcool", "Gasolina", "Flex" }));

        txtAno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnoKeyReleased(evt);
            }
        });

        lblRequireAno.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblRequireAno.setText("...");

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblFoto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Inisira aqui a imagem");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbTipo, 0, 196, Short.MAX_VALUE)
                                            .addComponent(lblCombustivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRequireAno, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtAno, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                                .addComponent(lbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(lblRequireAno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (verificaCampos()) {
            try {
                salvarVeiculo();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ano do veiculo deve ser numerico!");
                txtAno.requestFocus();
                txtAno.selectAll();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (IllegalArgumentException ex) {
                if (ex.getMessage().equals("image == null!")) {
                    JOptionPane.showMessageDialog(null, "Voce nao selecionou img");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Preecha todos os campos!");
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (verificaCampos()) {
            preencheObjeto();
            veiculo.setCodigo((int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 0));
            if (veiculoDAO.alterarVeiculo(veiculo)) {
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
                carregaDadosTable();
                limpaCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Alteração não finalizada, tente novamente!");
                limpaCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preecha todos os campos!");
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVeiculosMouseClicked
        btnCadastrar.setEnabled(false);
        txtNome.setText("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 1));
        cmbTipo.setSelectedItem("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 2));
        cmbModelo.setSelectedItem("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 3));
        txtMarca.setText("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 4));
        cmbCombustivel.setSelectedItem("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 5));
        txtAno.setText("" + tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 6));
        buscaFotoVeiculo();
    }//GEN-LAST:event_tableVeiculosMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        veiculo.setCodigo((int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 0));
        if (veiculoDAO.deletarVeiculo(veiculo)) {
            JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
            carregaDadosTable();
            limpaCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Remoção não finalizada, veiculo em uso, tente novamente mais tarde!");
            limpaCampos();
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if (cmbTipo.getSelectedItem().equals("Moto")) {
            cmbModelo.removeAllItems();
            cmbModelo.addItem("**Selecione**");
            cmbModelo.addItem("Custom");
            cmbModelo.addItem("Scrambler");
            cmbModelo.addItem("Tracker");

        }
        if (cmbTipo.getSelectedItem().equals("Carro")) {
            cmbModelo.removeAllItems();
            cmbModelo.addItem("**Selecione**");
            cmbModelo.addItem("Hacth");
            cmbModelo.addItem("Sedãn");
            cmbModelo.addItem("4x4");
        }
        if (cmbTipo.getSelectedItem().equals("**Selecione**")) {
            cmbModelo.removeAllItems();
            cmbModelo.addItem("**Selecione**");
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtAnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyReleased
        if (txtAno.getText().length() < 4) {
            lblRequireAno.setVisible(true);
            lblRequireAno.setForeground(new Color(237, 16, 16));
            lblRequireAno.setText("Deve conter 4 digitos");
        } else {
            lblRequireAno.setVisible(false);
        }
    }//GEN-LAST:event_txtAnoKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        try {
            selecionaFoto();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lblFotoMouseClicked

    void selecionaFoto() throws IOException {
        JFileChooser buscaFoto = new JFileChooser();
        buscaFoto.setFileFilter(new FileNameExtensionFilter("Imagem", "bmp", "png", "jgp", "jpeg"));
        buscaFoto.setAcceptAllFileFilterUsed(false);
        buscaFoto.setDialogTitle("Selecionar Imagem");
        buscaFoto.showOpenDialog(this);
        if (buscaFoto.getSelectedFile() != null) {
            String caminho = "" + buscaFoto.getSelectedFile().getAbsolutePath();
            imagemBuffer = ImageIO.read(new File(caminho));
            Image imgRezise = imagemBuffer.getScaledInstance(100, 100, 0);
            lblFoto.setText("");
            lblFoto.setIcon(new ImageIcon(imgRezise));
        } else {
            JOptionPane.showMessageDialog(null, "N Gravou");
            limpaCampos();
        }
    }

    void salvarVeiculo() throws IOException, IllegalArgumentException {

        ImageIO.write(imagemBuffer, "jpg", bytesImg);

        bytesImg.flush();
        byteArray = bytesImg.toByteArray();
        bytesImg.close();
        preencheObjeto();

        if (veiculoDAO.cadastro(veiculo)) {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            carregaDadosTable();
            limpaCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não finalizado, tente novamente!");
            limpaCampos();
        }
    }

    void buscaFotoVeiculo() {
        imagemBuffer = null;
        veiculo.setCodigo((int) tableVeiculos.getValueAt(tableVeiculos.getSelectedRow(), 0));

        try {
            imagemBuffer = ImageIO.read(new ByteArrayInputStream(veiculoDAO.retornaFotoVeiculo(veiculo.getCodigo())));
            Image imgRezise = imagemBuffer.getScaledInstance(100, 100, 0);
            lblFoto.setText("");
            lblFoto.setIcon(new ImageIcon(imgRezise));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void preencheObjeto() {
        veiculo.setNome(txtNome.getText());
        veiculo.setTipo("" + cmbTipo.getSelectedItem());
        veiculo.setAno(Integer.parseInt(txtAno.getText()));
        veiculo.setCombustivel("" + cmbCombustivel.getSelectedItem());
        veiculo.setMarca(txtMarca.getText());
        veiculo.setModelo("" + cmbModelo.getSelectedItem());
        veiculo.setFoto(byteArray);
    }

    void carregaDadosTable() {
        inicializaModel();
        for (Veiculo objVeiculo : veiculoDAO.exibeVeiculos()) {
            dtmDefault.addRow(new Object[]{
                objVeiculo.getCodigo(),
                objVeiculo.getNome(),
                objVeiculo.getTipo(),
                objVeiculo.getModelo(),
                objVeiculo.getMarca(),
                objVeiculo.getCombustivel(),
                objVeiculo.getAno(),});
        }
    }

    boolean verificaCampos() {
        boolean retorno = false;
        if (!txtNome.getText().equals("") && !txtMarca.getText().equals("") && !txtAno.getText().equals("")
                && !cmbTipo.getSelectedItem().equals("**Selecione**") && !cmbCombustivel.getSelectedItem().equals("**Selecione**")
                && !cmbModelo.getSelectedItem().equals("**Selecione**")) {
            retorno = true;
        }
        return retorno;
    }

    void inicializaModel() {
        dtmDefault = (DefaultTableModel) tableVeiculos.getModel();
        dtmDefault.setNumRows(0);
    }

    void limpaCampos() {
        txtNome.setText("");
        cmbTipo.setSelectedItem("**Selecione**");
        cmbModelo.removeAllItems();
        cmbModelo.setSelectedItem("**Selecione**");
        txtMarca.setText("");
        cmbCombustivel.setSelectedItem("**Selecione**");
        txtAno.setText("");
        lblFoto.setIcon(null);
        lblFoto.setText("Insira a img aqui");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JComboBox<String> cmbCombustivel;
    private javax.swing.JComboBox<String> cmbModelo;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lblCombustivel;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblModelo1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRequireAno;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
