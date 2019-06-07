package view;

import controller.Validacoes;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import model.Pessoa;
import model.DAO.PessoaDAO;
import model.DAO.ConexaoDAO;

public class JFCadastroPessoa extends javax.swing.JFrame {

    Pessoa cliente = new Pessoa();
    PessoaDAO clienteDAO = new PessoaDAO();
    Validacoes objValidacao = new Validacoes();

    public JFCadastroPessoa() {
        
        initComponents();
        lblValidaUsuario.setVisible(false);
        if (ConexaoDAO.getCliente().getCodigo() <= 0) {
            btnCadastrar.setText("Cadastrar");
        } else {
            setaCamposAlteracao();
            btnCadastrar.setText("Alterar");
            setTitle("Atualização Cliente");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCadastro = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblValidaUsuario = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblEmail = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        txtCelular = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cliente");
        setUndecorated(true);
        setResizable(false);

        panCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(51, 51, 51));
        lblNome.setText("Nome");
        panCadastro.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtNome.setBackground(new java.awt.Color(240, 240, 240));
        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(51, 51, 51));
        txtNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        panCadastro.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 247, 30));

        lblTelefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(51, 51, 51));
        lblTelefone.setText("Telefone");
        panCadastro.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtTelefone.setBackground(new java.awt.Color(240, 240, 240));
        txtTelefone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtTelefone.setForeground(new java.awt.Color(51, 51, 51));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panCadastro.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 247, 36));

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("Usuário");
        panCadastro.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(240, 240, 240));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        panCadastro.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 216, 247, 30));

        lblValidaUsuario.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblValidaUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblValidaUsuario.setText("Usuário disponível");
        panCadastro.add(lblValidaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 240, -1));

        btnCadastrar.setBackground(new java.awt.Color(33, 112, 146));
        btnCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        panCadastro.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 314, 153, 50));

        txtSenha.setBackground(new java.awt.Color(240, 240, 240));
        txtSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(51, 51, 51));
        txtSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        panCadastro.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 218, 250, 30));

        lblEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(51, 51, 51));
        lblEmail.setText("Email");
        panCadastro.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        lblCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCelular.setForeground(new java.awt.Color(51, 51, 51));
        lblCelular.setText("Celular");
        panCadastro.add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(51, 51, 51));
        lblSenha.setText("Senha");
        panCadastro.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 235, -1));

        btnLimpar.setBackground(new java.awt.Color(197, 36, 39));
        btnLimpar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar ");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        panCadastro.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 154, 50));

        txtCelular.setBackground(new java.awt.Color(240, 240, 240));
        txtCelular.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtCelular.setForeground(new java.awt.Color(51, 51, 51));
        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panCadastro.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 250, 36));

        txtEmail.setBackground(new java.awt.Color(240, 240, 240));
        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        panCadastro.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 250, 30));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        lblClose.setToolTipText("Fechar");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        panCadastro.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void limpaCampos() {
        txtUsuario.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        txtNome.requestFocus();
        lblValidaUsuario.setVisible(false);
    }

    boolean verificaCampos() {
        boolean retorno = false;

        if (!txtNome.getText().equals("") && !txtCelular.getText().equals("") && !txtCelular.getText().equals("") && !txtEmail.getText().equals("")
                && !txtSenha.getText().equals("") && !txtUsuario.getText().equals("")) {
            if (txtCelular.getText().trim().length() > 15 && txtTelefone.getText().trim().length() > 15) {
                retorno = true;
            }
        }
        return retorno;
    }

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            setaObjeto();
            if (verificaCampos()) {

                switch (btnCadastrar.getText()) {
                    case "Cadastrar":
                        clienteDAO.cadastro(cliente);
                        JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                        dispose();
                        break;
                    case "Alterar":
                        if (clienteDAO.alterar(cliente)) {
                            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
                            ConexaoDAO.setCliente(cliente);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração!");
                        }
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Telefone/Celular digite apenas numeros!");
            System.out.println(e.getMessage());
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if (txtUsuario.getText().equals("")) {
            lblValidaUsuario.setVisible(false);
        } else {
            try {

                if (clienteDAO.buscaUsuario(txtUsuario.getText())) {
                    lblValidaUsuario.setVisible(true);
                    lblValidaUsuario.setText("Usuário indisponível");
                    lblValidaUsuario.setForeground(new Color(237, 16, 16));
                    btnCadastrar.setEnabled(false);
                } else {
                    lblValidaUsuario.setVisible(true);
                    lblValidaUsuario.setText("Usuário disponível");
                    lblValidaUsuario.setForeground(new Color(0, 153, 12));
                    btnCadastrar.setEnabled(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(JFCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
         if (objValidacao.dialogoConfirmacao("Deseja realmente sair?") == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    void setaObjeto() {
        cliente.setCodigo(ConexaoDAO.getCliente().getCodigo());
        cliente.setNome(txtNome.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setTelefone(txtCelular.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setUsuario(txtUsuario.getText());
        cliente.setSenha(txtSenha.getText());
    }

    void setaCamposAlteracao() {
        txtNome.setText(ConexaoDAO.getCliente().getNome());
        txtEmail.setText(ConexaoDAO.getCliente().getEmail());
        txtTelefone.setText(ConexaoDAO.getCliente().getTelefone());
        txtCelular.setText(ConexaoDAO.getCliente().getCelular());
        txtUsuario.setText(ConexaoDAO.getCliente().getUsuario());
        lblSenha.setText("Digite sua nova senha");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValidaUsuario;
    private javax.swing.JPanel panCadastro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
