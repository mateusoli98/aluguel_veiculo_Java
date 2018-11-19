package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.HistoricoLocacao;
import model.Locacao;
import model.Veiculo;

public class LocacaoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    String query = "", query2 = "";
    ;
    boolean retorno = false;

    public ArrayList<Locacao> exibeVeiculos() {
        ArrayList<Locacao> listVeiculos = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT locacao.codigo, locacao.total, locacao.dtInicio, locacao.dtTermino, veiculo.nome FROM locacao "
                    + "JOIN veiculo ON locacao.codVeiculo = veiculo.codigo JOIN pessoa ON locacao.codPessoa = pessoa.codigo "
                    + "WHERE locacao.codPessoa = '" + ConexaoDAO.getCliente().getCodigo() + "'";
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
        ArrayList<HistoricoLocacao> listHistoricoLocacao = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT DISTINCT veiculo.codigo, veiculo.nome, veiculo.modelo FROM veiculo "
                    + "JOIN avaliacao on avaliacao.codVeiculo =  veiculo.codigo "
                    + "JOIN pessoa ON avaliacao.codPessoa = pessoa.codigo "
                    + "WHERE pessoa.codigo = " + ConexaoDAO.getCliente().getCodigo() + " AND avaliacao.status = 0;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HistoricoLocacao objHL = new HistoricoLocacao();
                Locacao objLocacao = new Locacao();
                Veiculo objVeiculo = new Veiculo();
                objVeiculo.setCodigo(rs.getInt("veiculo.codigo"));
                objVeiculo.setNome(rs.getString("veiculo.nome"));
                objVeiculo.setModelo(rs.getString("veiculo.modelo"));
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

    public int qntLocacoesVencidas() {
        int retorno = 0;
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT count(codigo) FROM locacao WHERE dtTermino <= now();";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt(1);
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
        return retorno;
    }

    public void verificaDisponibilidadeVeiculo() {
        try {
            conn = ConexaoDAO.abreConexao();
            CallableStatement ps;
            query = "{call disponibilidadeCarro ()}";
            ps = conn.prepareCall(query);
            ps.execute();
            conn.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
