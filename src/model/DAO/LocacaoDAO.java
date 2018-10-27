package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Locacao;


public class LocacaoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    String query = "";
    boolean retorno = false;

    public ArrayList<Locacao> exibeVeiculos(int codCliente) {
        ArrayList<Locacao> listVeiculos = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT locacao.codigo, locacao.total, locacao.dtInicio, locacao.dtTermino, veiculo.nome FROM locacao JOIN veiculo ON locacao.codVeiculo = veiculo.codigo JOIN cliente ON locacao.codCliente = cliente.codigo WHERE locacao.codCliente = '" + codCliente + "'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Locacao objLoc = new Locacao();
                objLoc.setCodLocacao(rs.getInt("locacao.codigo"));
                objLoc.setTotal(rs.getDouble("locacao.total"));
                objLoc.setDtInicio(""+rs.getDate("locacao.dtInicio"));
                objLoc.setDtTermino(""+rs.getDate("locacao.dtTermino"));
                objLoc.setNomeVeiculo(rs.getString("veiculo.nome"));
                listVeiculos.add(objLoc);
                objLoc = null;
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
        return listVeiculos;
    }
}
