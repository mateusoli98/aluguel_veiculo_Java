
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.ConexaoDAO;
import model.*;

public class AvaliacaoDAO {

    String query;
    Connection conn;
    PreparedStatement ps;
    boolean retorno = false;

    public boolean resgistarAvaliacao(Avaliacao a, Cliente c, Veiculo v) {
        try {
            conn = ConexaoDAO.abreConexao();
            query = "INSERT INTO avaliacao VALUES (?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(query);
            ps.setInt(1, a.getNumAvaliacao());
            ps.setString(2, a.getComentario());
            ps.setInt(3, a.getStatus());
            ps.setInt(4, v.getCodigo());
            ps.setInt(5, c.getCodigo());
            ps.executeUpdate();
            retorno =  true;
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
        }finally {
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

}
