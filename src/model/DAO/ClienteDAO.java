package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDAO {

    String query;
    Connection conn;
    PreparedStatement ps;
    boolean retorno = false;

    public void cadastraCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.abreConexao();
        query = "INSERT INTO cliente VALUES (DEFAULT, ?, ?, ?, ?, ?, md5(?), 0)";
        ps = conn.prepareStatement(query);
        ps.setString(1, objCliente.getNome());
        ps.setString(2, objCliente.getEmail());
        ps.setString(3, objCliente.getTelefone());
        ps.setString(4, objCliente.getCelular());
        ps.setString(5, objCliente.getUsuario());
        ps.setString(6, objCliente.getSenha());
        ps.executeUpdate();
        conn.close();
        ps.close();
        query = "";
    }

    public ResultSet buscaLoginCliente(String usuario, String senha) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.abreConexao();
        query = "SELECT * FROM cliente WHERE usuario = '" + usuario + "' and senha = md5('" + senha + "')";
        ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        return rs;
    }

    public boolean buscaUsuarioCliente(String usuario) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.abreConexao();
        query = "SELECT * FROM cliente WHERE usuario = '" + usuario + "';";
        ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);

        if (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean alterarCliente(Cliente c) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = "UPDATE cliente SET nome = '" + c.getNome() + "', "
                    + "email = '" + c.getEmail() + "', "
                    + "celular = '" + c.getCelular() + "', "
                    + "telefone = '" + c.getTelefone() + "',"
                    + "usuario = '" + c.getUsuario() + "', "
                    + "senha = md5('" + c.getSenha() + "')"
                    + "WHERE codigo = " + c.getCodigo() + ";";
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            return retorno = true;
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } finally {
            try {
                retorno = false;
                query = "";
                conn.close();

            } catch (Exception e) {
            }
        }
        return retorno;
    }

    public boolean deletarCliente(Cliente c) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = "DELETE FROM `cliente` WHERE `codigo` = " + c.getCodigo() + ";";
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            return retorno = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                retorno = false;
                query = "";
                conn.close();
            } catch (SQLException e) {
            }
        }
        return retorno;
    }

    public void infoCliente(ResultSet rs) {
        Cliente cliente = new Cliente();
        try {
            cliente.setCodigo(rs.getInt("codigo"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setUsuario(rs.getString("usuario"));
            cliente.setAcesso(rs.getInt("acesso"));
            ConexaoDAO.setCliente(cliente);
        } catch (SQLException e) {
        }
    }
    
}
