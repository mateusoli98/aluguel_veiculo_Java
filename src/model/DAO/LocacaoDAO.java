package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.HistoricoLocacao;
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

    public ArrayList<HistoricoLocacao> historicoLocacao() {
        ArrayList<HistoricoLocacao> listHistoricoLocacao =  new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT veiculo.codigo, veiculo.nome, veiculo.modelo, locacao.codigo, locacao.dtTermino FROM veiculo JOIN avaliacao on avaliacao.codVeiculo =  veiculo.codigo JOIN locacao ON veiculo.codigo = locacao.codVeiculo JOIN cliente ON cliente.codigo = locacao.codCliente WHERE cliente.codigo = "+ConexaoDAO.getCliente().getCodigo()+" AND locacao.dtTermino <= now() AND avaliacao.status = 0;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                HistoricoLocacao objHL =  new HistoricoLocacao();
                Locacao objLocacao =  new Locacao();
                Veiculo objVeiculo =  new Veiculo();
                objVeiculo.setCodigo(rs.getInt("veiculo.codigo"));
                objVeiculo.setNome(rs.getString("veiculo.nome"));
                objVeiculo.setModelo(rs.getString("veiculo.modelo"));
                objLocacao.setCodLocacao(rs.getInt("locacao.codigo"));
                objLocacao.setDtTermino(rs.getString("locacao.dtTermino"));
                
                objHL.setLocacao(objLocacao);
                objHL.setVeiculo(objVeiculo);
                
                listHistoricoLocacao.add(objHL);
                
                objHL = null;
                objLocacao = null;
                objVeiculo = null;  
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
