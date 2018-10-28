package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.ConexaoDAO;
import model.*;

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
                    + "codCliente = " + ConexaoDAO.getCliente().getCodigo()+";";

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

    public String comentarios() {
        String comentarios = "";
        try {
            conn=  ConexaoDAO.abreConexao();
            query = "SELECT cliente.nome, avaliacao.numAvaliacao, veiculo.nome, avaliacao.comentario FROM cliente JOIN avaliacao ON cliente.codigo = avaliacao.codCliente JOIN veiculo ON veiculo.codigo = avaliacao.codVeiculo ORDER BY avaliacao.codigo DESC;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                comentarios += "<br>O "+rs.getString("cliente.nome")+" avaliou com a nota "
                        + rs.getInt("avaliacao.numAvaliacao")+"<br>"
                        + "Veículo utilizado: "+rs.getString("veiculo.nome")
                        + "<br><br>"
                        + "<b>Sua Experiencia com nossos serviços:</b><br>"
                        + "<i>\""+rs.getString("avaliacao.comentario")+"\"</i>"
                        + "<br><br><hr>";
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            
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
}
