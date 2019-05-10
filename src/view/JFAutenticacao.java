package view;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.DAO.PessoaDAO;

public class JFAutenticacao extends javax.swing.JFrame {

    Pessoa cliente = new Pessoa();
    PessoaDAO clienteDAO = new PessoaDAO();
    ResultSet rs = null;
    String usuario, senha, user;

    public JFAutenticacao() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblsenha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblReseteSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticação");
        setResizable(false);

        btnCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });

        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblsenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblsenha.setText("Senha");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOCAÇÕES A&M");

        lblUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUser.setText("Usuário");

        lblReseteSenha.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        lblReseteSenha.setForeground(new java.awt.Color(0, 51, 255));
        lblReseteSenha.setText("Esqueceu sua senha?");
        lblReseteSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReseteSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReseteSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblsenha)
                            .addGap(193, 193, 193))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSenha)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUser)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblReseteSenha)))))
                            .addGap(79, 79, 79)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(136, 136, 136))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReseteSenha)
                .addGap(13, 13, 13)
                .addComponent(lblsenha)
                .addGap(10, 10, 10)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    boolean verificaCampos() {
        boolean retorno = false;
        usuario = txtUsuario.getText();
        senha = txtSenha.getText();
        if (!usuario.equals("") && !senha.equals("")) {
            retorno = true;
        }
        return retorno;
    }


    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (btnCadastrar.getText().equals("Cadastrar-se")) {
            JFCadastroPessoa frmCadastro = new JFCadastroPessoa();
            frmCadastro.setVisible(true);
            frmCadastro.setLocationRelativeTo(null);
        } else if (btnCadastrar.getText().equals("Confirmar")) {
            try {
                cliente.setUsuario(txtUsuario.getText());
                cliente.setSenha(txtSenha.getText());
                if (!cliente.getUsuario().isEmpty() && !cliente.getSenha().isEmpty()) {
                    clienteDAO.atualizaSenha(cliente);
                    JOptionPane.showMessageDialog(null, "Nova senha cadastrada", "sucesso", JOptionPane.INFORMATION_MESSAGE);
                    mudaEstado("Usuario", "Senha", "Entrar", "Cadastrar-se", true);
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "erro", JOptionPane.ERROR);
                    
                    txtUsuario.requestFocus();
                }

            } catch (SQLException ex) {;
                Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (btnEntrar.getText().equals("Entrar")) {
            if (verificaCampos()) {
                try {
                    if ((rs = clienteDAO.buscaLogin(usuario, senha)).next()) {
                        clienteDAO.infoPessoa(rs);
                        JFMenu frmMenu = new JFMenu();
                        frmMenu.setVisible(true);
                        frmMenu.setLocationRelativeTo(null);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário e/ou Senha incorretos!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preecha todos os campos!");
            }
        } else if (btnEntrar.getText().equals("Cancelar")) {
            mudaEstado("Usuario", "Senha", "Entrar", "Cadastrar-se", true);
            txtSenha.setEnabled(true);
            lblReseteSenha.setForeground(new Color(0, 51, 255));
            lblReseteSenha.setText("Esqueceu sua senha?");
            limpaCampos();
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        if (btnEntrar.getText().equals("Entrar")) {
            if (verificaCampos()) {
                try {
                    if ((rs = clienteDAO.buscaLogin(usuario, senha)).next()) {
                        clienteDAO.infoPessoa(rs);
                        JFMenu frmMenu = new JFMenu();
                        frmMenu.setVisible(true);
                        frmMenu.setLocationRelativeTo(null);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário e/ou Senha incorretos!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preecha todos os campos!");
            }
        } else {
            mudaEstado("Usuario", "Senha", "Entrar", "Cadastrar-se", true);
            txtSenha.setEnabled(true);
            lblReseteSenha.setForeground(new Color(0, 51, 255));
        }


    }//GEN-LAST:event_btnEntrarKeyPressed

    private void lblReseteSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReseteSenhaMouseClicked
        if (lblReseteSenha.getText().equals("Esqueceu sua senha?")) {
            mudaEstado("Insira seu Usuario", "Nova senha", "Cancelar", "Confirmar", true);
            lblReseteSenha.setText("");
            txtSenha.setEnabled(false);
            limpaCampos();

        }

    }//GEN-LAST:event_lblReseteSenhaMouseClicked

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if (!lblReseteSenha.getText().equals("Esqueceu sua senha?")) {

            try {
                if (clienteDAO.buscaUsuario(txtUsuario.getText())) {
                    lblReseteSenha.setText("Usuário encontrado!");
                    lblReseteSenha.setForeground(new Color(0, 153, 12));
                    txtSenha.setEnabled(true);
                } else {
                    txtSenha.setEnabled(false);

                    lblReseteSenha.setText("Usuário não encontrado!");
                    lblReseteSenha.setForeground(new Color(237, 16, 16));

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_txtUsuarioKeyReleased

    void limpaCampos() {
        txtUsuario.setText("");
        txtSenha.setText("");
        txtUsuario.requestFocus();
    }

    void mudaEstado(String a, String b, String c, String d, boolean flag) {
        lblUser.setText(a);
        lblsenha.setText(b);
        btnEntrar.setText(c);
        btnCadastrar.setText(d);
        lblReseteSenha.setVisible(flag);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblReseteSenha;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
