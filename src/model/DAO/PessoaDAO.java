package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDAO {

    String query;
    Connection conn;
    PreparedStatement ps;

    public void cadastro(Pessoa objCliente) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.abreConexao();
        CallableStatement ps;
        query = "{call cadastro (?,?,?,?,?,?)}";
        ps = conn.prepareCall(query);
        ps.setString(1, objCliente.getNome());
        ps.setString(2, objCliente.getEmail());
        ps.setString(3, objCliente.getTelefone());
        ps.setString(4, objCliente.getCelular());
        ps.setString(5, objCliente.getUsuario());
        ps.setString(6, objCliente.getSenha());
        ps.execute();
        conn.close();
        ps.close();
    }

    public ResultSet buscaLogin(String usuario, String senha) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.abreConexao();
        query = "SELECT * FROM usuario JOIN pessoa ON pessoa.codUsuario = usuario.codigo "
                + "WHERE usuario.usuario = '" + usuario + "' and usuario.senha = md5('" + senha + "')";
        ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        return rs;
    }

    public boolean buscaUsuario(String usuario) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.abreConexao();
        query = "SELECT * FROM usuario WHERE usuario = '" + usuario + "';";
        ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);

        if (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean alterar(Pessoa c) {
        try {
            conn = ConexaoDAO.abreConexao();
            CallableStatement ps;
            query = "{call atualiza (?,?,?,?,?,?,?)}";
            ps = conn.prepareCall(query);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getCelular());
            ps.setString(5, c.getUsuario());
            ps.setString(6, c.getSenha());
            ps.setInt(7, c.getCodigo());
            ps.execute();
            conn.close();
            ps.close();
            return true;
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } finally {
            try {
                query = "";
                conn.close();

            } catch (Exception e) {
            }
        }
        return false;
    }

    public boolean deletar(Pessoa c) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = "DELETE FROM `pessoa` WHERE `codigo` = " + c.getCodigo() + ";";
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            ps = null;

            query = "DELETE FROM `usuario` WHERE `codigo` = " + c.getCodigo() + ";";
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            ps = null;
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                query = "";
                conn.close();
            } catch (SQLException e) {
            }
        }
        return false;
    }

    public void infoPessoa(ResultSet rs) {
        Pessoa cliente = new Pessoa();
        try {
            cliente.setCodigo(rs.getInt("pessoa.codigo"));
            cliente.setNome(rs.getString("pessoa.nome"));
            cliente.setEmail(rs.getString("pessoa.email"));
            cliente.setTelefone(rs.getString("pessoa.telefone"));
            cliente.setCelular(rs.getString("pessoa.celular"));
            cliente.setUsuario(rs.getString("usuario.usuario"));
            cliente.setAcesso(rs.getInt("usuario.acesso"));
            ConexaoDAO.setCliente(cliente);
        } catch (SQLException e) {
        }
    }

}
