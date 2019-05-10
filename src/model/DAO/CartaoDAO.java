package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cartao;
import model.Veiculo;

public class CartaoDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String query = "";
    boolean retorno = false;

    public int exibeUltimoCartao() {
        int id = 0;
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT codigo FROM cartao ORDER BY codigo";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                id = rs.getInt("codigo");

                query = "";
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (SQLException erroSQL) {
            erroSQL.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return id;
    }

    public ArrayList<Cartao> exibeCartoes() {
        ArrayList<Cartao> listCartoes = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT * FROM cartao ";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cartao objCartao = new Cartao();
                objCartao.setCodigo(rs.getInt("codigo"));
                objCartao.setNumero(rs.getInt("numero"));
                objCartao.setCvv(rs.getInt("cvv"));
                objCartao.setDataVencimento(rs.getString("dataVencimento"));
                objCartao.setBandeira(rs.getString("bandeira"));

                listCartoes.add(objCartao);
                objCartao = null;
                query = "";
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (SQLException erroSQL) {
            erroSQL.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return listCartoes;
    }

    public boolean cadastroCartao(Cartao c) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = " INSERT INTO cartao (codigo, numero, cvv, dataVencimento, bandeira, codPessoa) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, c.getNumero());
            ps.setInt(2, c.getCvv());
            ps.setString(3, c.getDataVencimento());
            ps.setString(4, c.getBandeira());
            ps.setInt(5, c.getCodPessoa());
            ps.executeUpdate();
            return retorno = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            retorno = false;
            query = "";
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return retorno;
    }
    
    
    public ArrayList<Cartao> exibeCartaoId(int codigo) {
        ArrayList<Cartao> listCartoes = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT * FROM cartao WHERE codigo='"+codigo+"'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cartao objCartao = new Cartao();
                objCartao.setCodigo(rs.getInt("codigo"));
                objCartao.setNumero(rs.getInt("numero"));
                objCartao.setCvv(rs.getInt("cvv"));
                objCartao.setDataVencimento(rs.getString("dataVencimento"));
                objCartao.setBandeira(rs.getString("bandeira"));

                listCartoes.add(objCartao);
                objCartao = null;
                query = "";
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (SQLException erroSQL) {
            erroSQL.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return listCartoes;
    }

}
