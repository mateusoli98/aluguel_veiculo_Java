package model;
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DAO.ConexaoDAO;
import model.*;

public class AvaliacaoDAO {

    String query;
    Connection conn;
    PreparedStatement ps;

    public boolean resgistarAvaliacao(Avaliacao a, HistoricoLocacao hl) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = "UPDATE avaliacao SET numAvaliacao = "+a.getNumAvaliacao()+", "
                                       + "comentario = '"+a.getComentario()+"',"
                                       + "status = 1 " 
                                       + "WHERE codVeiculo = "+hl.getVeiculo().getCodigo()+" AND "
                                       + "codCliente = "+ConexaoDAO.getCliente().getCodigo();
            
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            
        }finally {
            query = "";
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
            }
        }
        return false;
    }
}
