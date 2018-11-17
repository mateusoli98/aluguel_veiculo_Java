package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Pessoa;


abstract public class ConexaoDAO {

    private static Pessoa cliente =  new Pessoa(); 

    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/aluguelveiculos";

    public static Connection abreConexao() throws ClassNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn;
    }
    public static Pessoa getCliente() {
        return cliente;
    }

    public static void setCliente(Pessoa cliente) {
        ConexaoDAO.cliente = cliente;
    }
}