package view;

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
        btnCancelar.setVisible(false);

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
        lblresetpassword = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

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

        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblsenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblsenha.setText("Senha");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOCAÇÕES A&M");

        lblUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUser.setText("Usuário");

        lblresetpassword.setForeground(new java.awt.Color(51, 204, 255));
        lblresetpassword.setText("esqueceu sua senha?");
        lblresetpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblresetpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblresetpasswordMouseClicked(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblresetpassword)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblsenha)
                                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(lblUser))
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(lblUser)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblresetpassword)
                .addGap(5, 5, 5)
                .addComponent(lblsenha)
                .addGap(3, 3, 3)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
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
        JFCadastroPessoa frmCadastro = new JFCadastroPessoa();
        frmCadastro.setVisible(true);
        frmCadastro.setLocationRelativeTo(null);
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
        } else {
            try {
                if(clienteDAO.buscaUsuarioNovaSenha(usuario)){
                    cliente.setUsuario(usuario);
                    cliente.setSenha(senha);
                    if(clienteDAO.atualizaSenha(cliente)){
                        JOptionPane.showMessageDialog(null, "deu certo");
                    }else{
                        JOptionPane.showMessageDialog(null, "deu ruim");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "user não existente");
                }
            } catch (SQLException ex) {
                Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed

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


    }//GEN-LAST:event_btnEntrarKeyPressed

    private void lblresetpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblresetpasswordMouseClicked

        mudaEstado("Insira seu Usuario", "Nova senha", "Confirmar", false);
    }//GEN-LAST:event_lblresetpasswordMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mudaEstado("Usuario", "Senha", "Cadastrar", true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    void mudaEstado(String a, String b, String c, boolean flag) {
        lblUser.setText(a);
        lblsenha.setText(b);
        btnEntrar.setText(c);
        btnCadastrar.setVisible(flag);
        btnCancelar.setVisible(!flag);
        lblresetpassword.setVisible(flag);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblresetpassword;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
