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

        panelLogo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelAcesso = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        lblReseteSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticação");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogo.setBackground(new java.awt.Color(33, 112, 146));
        panelLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        panelLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOCAÇÕES A&Ms");
        panelLogo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        getContentPane().add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 470));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 134, 34, 22));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 260, 34, -1));

        panelAcesso.setBackground(new java.awt.Color(217, 217, 217));
        panelAcesso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(217, 217, 217));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        panelAcesso.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 400, 33));

        lblUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(51, 51, 51));
        lblUser.setText("Usuário");
        panelAcesso.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        lblsenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblsenha.setForeground(new java.awt.Color(51, 51, 51));
        lblsenha.setText("Senha");
        panelAcesso.add(lblsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        txtSenha.setBackground(new java.awt.Color(217, 217, 217));
        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelAcesso.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 400, 32));

        btnEntrar.setBackground(new java.awt.Color(0, 100, 148));
        btnEntrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
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
        panelAcesso.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 158, 47));

        btnCadastrar.setBackground(new java.awt.Color(48, 114, 71));
        btnCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        panelAcesso.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 151, 47));

        lblReseteSenha.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        lblReseteSenha.setForeground(new java.awt.Color(102, 102, 102));
        lblReseteSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-bloqueio-de-verificação-30.png"))); // NOI18N
        lblReseteSenha.setText("Esqueceu sua senha?");
        lblReseteSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblReseteSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReseteSenhaMouseClicked(evt);
            }
        });
        panelAcesso.add(lblReseteSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        getContentPane().add(panelAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 440, 470));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblReseteSenha;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JPanel panelAcesso;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
