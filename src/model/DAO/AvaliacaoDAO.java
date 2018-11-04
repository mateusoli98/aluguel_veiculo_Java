package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.ConexaoDAO;


public class AvaliacaoDAO {

    String query;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public boolean resgistarAvaliacao(Avaliacao a, HistoricoLocacao hl) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = "UPDATE avaliacao SET numAvaliacao = " + a.getNumAvaliacao() + ", "
                    + "comentario = '" + a.getComentario() + "',"
                    + "status = 1 "
                    + "WHERE codVeiculo = " + hl.getVeiculo().getCodigo() + " AND "
                    + "codCliente = " + ConexaoDAO.getCliente().getCodigo() + ";";

            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {

        } finally {
            query = "";
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
            }
        }
        return false;
    }

    public String comentarios(String veiculo) {
        String comentarios = "";
        try {
            conn = ConexaoDAO.abreConexao();
            if (veiculo.equals("Geral")) {
                query = "SELECT cliente.nome, avaliacao.numAvaliacao, veiculo.nome, avaliacao.comentario FROM cliente JOIN avaliacao ON cliente.codigo = avaliacao.codCliente JOIN veiculo ON veiculo.codigo = avaliacao.codVeiculo WHERE avaliacao.status <> 0 ORDER BY avaliacao.codigo DESC;";
            }else{
                query = "SELECT cliente.nome, avaliacao.numAvaliacao, veiculo.nome, avaliacao.comentario FROM cliente JOIN avaliacao ON cliente.codigo = avaliacao.codCliente JOIN veiculo ON veiculo.codigo = avaliacao.codVeiculo WHERE veiculo.nome = "+veiculo+" AND avaliacao.status <> 0 ORDER BY avaliacao.codigo DESC;";
            }
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                comentarios += "<br>O " + rs.getString("cliente.nome") + " avaliou com a nota "
                        + rs.getInt("avaliacao.numAvaliacao") + "<br>"
                        + "Veículo utilizado: " + rs.getString("veiculo.nome")
                        + "<br><br>"
                        + "<b>Sua Experiencia com nossos serviços:</b><br>"
                        + "<i>\"" + rs.getString("avaliacao.comentario") + "\"</i>"
                        + "<br><br><hr>";
            }

        } catch (SQLException | ClassNotFoundException e) {

        } finally {
            try {
                query = "";
                conn.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }

        return comentarios;
    }

    public ArrayList<Avaliacao> notas() {
        int i = 0;
        ArrayList<Avaliacao> listAvaliacao = new ArrayList<>();

        try {
            conn = ConexaoDAO.abreConexao();
            while (i <= 5) {
                query = "SELECT COUNT(numAvaliacao) as nota, numAvaliacao from avaliacao where numAvaliacao = " + i;
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setQtdAvaliacao(rs.getInt("nota"));
                    avaliacao.setNumAvaliacao(rs.getInt("numAvaliacao"));
                    listAvaliacao.add(avaliacao);
                }
                i++;
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAvaliacao;
    }

    public ArrayList<Avaliacao> notasVeiculo(String veiculo) {
        int i = 0;
        ArrayList<Avaliacao> listAvaliacao = new ArrayList<>();

        try {
            conn = ConexaoDAO.abreConexao();
            while (i <= 5) {
                query = "SELECT COUNT(avaliacao.numAvaliacao) as nota, avaliacao.numAvaliacao from avaliacao join veiculo on veiculo.codigo = avaliacao.codVeiculo where veiculo.nome = '" + veiculo + "' and numAvaliacao = " + i;
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setQtdAvaliacao(rs.getInt("nota"));
                    avaliacao.setNumAvaliacao(rs.getInt("numAvaliacao"));
                    listAvaliacao.add(avaliacao);
                }
                i++;
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAvaliacao;
    }
}
