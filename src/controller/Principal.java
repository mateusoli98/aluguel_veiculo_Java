package controller;

import model.Cliente;
import model.DAO.ConexaoDAO;
import model.DAO.LocacaoDAO;
import view.JFAutenticacao;

public class Principal {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFAutenticacao frmLogin = new JFAutenticacao();
            frmLogin.setVisible(true);
            frmLogin.setLocationRelativeTo(null);

//            Cliente cliente = new Cliente();
//            cliente.setCodigo(1);
//            ConexaoDAO.setCliente(cliente);
//            
//            LocacaoDAO loc = new LocacaoDAO();
//            System.out.println(""+loc.historicoLocacao());
            
        });
    }
}
