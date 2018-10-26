package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Veiculo;

public class VeiculoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    String query = "";

    public ArrayList<Veiculo> exibeVeiculos() {
        ArrayList<Veiculo> listVeiculos = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT * FROM veiculo";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo objVeiculo = new Veiculo();
                objVeiculo.setNome(rs.getString("nome"));
                objVeiculo.setCombustivel(rs.getString("combustivel"));
                objVeiculo.setModelo(rs.getString("modelo"));
                objVeiculo.setMarca(rs.getString("marca"));
                objVeiculo.setAno(rs.getInt("ano"));
                listVeiculos.add(objVeiculo);
                objVeiculo = null;
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

    public int quantidadeDiasAluguel(String dtInicio, String dtFim) {
        int qntDias;
        try {
//            conn = ConexaoDAO.abreConexao();
//            SELECT dtTermino - dtInicio FROM locacao WHERE codCliente = 2
            
//            query = "SELECT * FROM veiculo WHERE tipo = '" + tipo + "' AND alugado = 0";
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Veiculo objVeiculo = new Veiculo();
//                objVeiculo.setNome(rs.getString("nome"));
//                objVeiculo.setCombustivel(rs.getString("combustivel"));
//                objVeiculo.setModelo(rs.getString("modelo"));
//                objVeiculo.setMarca(rs.getString("marca"));
//                objVeiculo.setAno(rs.getInt("ano"));
//
//                objVeiculo = null;
//                query = "";
//            }
            conn.close();
            ps.close();
            rs.close();

        } catch (SQLException erroSQL) {
            erroSQL.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Veiculo> exibeTipoVeiculos(String tipo) {
        ArrayList<Veiculo> listVeiculos = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT * FROM veiculo WHERE tipo = '" + tipo + "' AND alugado = 0";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo objVeiculo = new Veiculo();
                objVeiculo.setNome(rs.getString("nome"));
                objVeiculo.setCombustivel(rs.getString("combustivel"));
                objVeiculo.setModelo(rs.getString("modelo"));
                objVeiculo.setMarca(rs.getString("marca"));
                objVeiculo.setAno(rs.getInt("ano"));
                listVeiculos.add(objVeiculo);
                objVeiculo = null;
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

    public ArrayList<Veiculo> exibeVeiculoNome(String nome) {
        ArrayList<Veiculo> listVeiculos = new ArrayList<>();
        try {
            conn = ConexaoDAO.abreConexao();
            query = "SELECT * FROM veiculo WHERE nome LIKE '%" + nome + "' AND alugado = 0";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo objVeiculo = new Veiculo();
                objVeiculo.setNome(rs.getString("nome"));
                objVeiculo.setCombustivel(rs.getString("combustivel"));
                objVeiculo.setModelo(rs.getString("modelo"));
                objVeiculo.setMarca(rs.getString("marca"));
                objVeiculo.setAno(rs.getInt("ano"));
                listVeiculos.add(objVeiculo);
                objVeiculo = null;
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
