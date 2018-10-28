package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Locacao;
import model.Veiculo;

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
                objLoc.setDtInicio("" + rs.getDate("locacao.dtInicio"));
                objLoc.setDtTermino("" + rs.getDate("locacao.dtTermino"));
                objLoc.setNomeVeiculo(rs.getString("veiculo.nome"));
                listVeiculos.add(objLoc);
                objLoc = null;
            }

        } catch (SQLException erroSQL) {
            erroSQL.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        } finally {
            try {
                query = "";
                conn.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {

            }
        }
        return listVeiculos;
    }

    public ArrayList<Object> historicoLocacao() {
        ArrayList<Object> listHistoricoLocacao = new ArrayList<>();
        
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT veiculo.codigo, veiculo.nome, locacao.codigo, locacao.dtTermino FROM veiculo JOIN locacao ON veiculo.codigo = locacao.codVeiculo JOIN cliente ON cliente.codigo = locacao.codCliente WHERE cliente.codigo = "+ConexaoDAO.getCliente().getCodigo()+" AND locacao.dtTermino <= now()";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Locacao objLocacao = new Locacao();
                Veiculo objVeiculo =  new Veiculo();
                objLocacao.setCodLocacao(rs.getInt("locacao.cogido"));
                objLocacao.setDtTermino(rs.getString("locacao.dtTermino"));
                objVeiculo.setCodigo(rs.getInt("veiculo.codigo"));
                objVeiculo.setNome(rs.getString("veiculo.nome"));
                listHistoricoLocacao.add(objLocacao);
                listHistoricoLocacao.add(objVeiculo);
                objLocacao = null;
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
        return listHistoricoLocacao;
    }
}
