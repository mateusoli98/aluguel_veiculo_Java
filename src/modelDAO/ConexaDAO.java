package modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class ConexaDAO {

    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static final String URL = "jdbc:mysql://localhost/aluguelveiculos", USER = "root", PASS = "";

    public static void connection() throws SQLException {
        con = DriverManager.getConnection(URL, USER, PASS);
    }

    public static void fechaConexao() throws SQLException {
        if (con != null) {
            con.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public static boolean executaQuery(String query) throws SQLException {
        boolean retorno = false;
        try {
            connection();
            stm = con.prepareStatement(query);
            if (stm.executeUpdate() == 1) {
                retorno = true;
            }

        } catch (SQLException e) {
            retorno = false;
        } finally {
            fechaConexao();
        }
        return retorno;
    }

    public static ResultSet executaQueryR(String query) throws SQLException {
        connection();
        stm = con.prepareStatement(query);
        return rs = stm.executeQuery();

    }
}


