package com.example.projetopoo.DAO;

import com.example.projetopoo.Models.AtosProcessuais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AtoProcessualDAO {

    private Connection connection;

    public AtoProcessualDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um novo ato processual no banco de dados
    public void inserirAtosProcessuais(AtosProcessuais atosProcessuais) throws SQLException {
        String sql = "INSERT INTO atosProcessuais (autoria, dataGeracao, conteudoTextual, finalidade, sobrePeca, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, atosProcessuais.getAutoria());
            preparedStatement.setString(2, atosProcessuais.getDataGeracao());
            preparedStatement.setString(3, atosProcessuais.getConteudo());
            preparedStatement.setString(4, atosProcessuais.getFinalidade());
            preparedStatement.setInt(5, atosProcessuais.getIdPecaProcessual());
            preparedStatement.setString(6, atosProcessuais.getStatus());
            preparedStatement.executeUpdate();
        }
    }

    // Método para atualizar um ato processual existente
    public void atualizarAtoProcessual(AtosProcessuais atosProcessuais) throws SQLException {
        String sql = "UPDATE atosProcessuais SET autoria = ?, dataGeracao = ?, conteudoTextual = ?, finalidade = ?, sobrePeca = ?, status = ? WHERE idAto = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, atosProcessuais.getAutoria());
            preparedStatement.setString(2, atosProcessuais.getDataGeracao());
            preparedStatement.setString(3, atosProcessuais.getConteudo());
            preparedStatement.setString(4, atosProcessuais.getFinalidade());
            preparedStatement.setInt(5, atosProcessuais.getIdPecaProcessual());
            preparedStatement.setString(6, atosProcessuais.getStatus());
            preparedStatement.setInt(7, atosProcessuais.getId());
            preparedStatement.executeUpdate();
        }
    }

    // Método para buscar um ato processual pelo ID
    public AtosProcessuais buscarAtoProcessualPorId(int id) throws SQLException {
        String sql = "SELECT * FROM atosProcessuais WHERE idAto = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new AtosProcessuais(
                            resultSet.getInt("id"),
                            resultSet.getString("autor"),
                            resultSet.getString("data_geracao"),
                            resultSet.getString("conteudo"),
                            resultSet.getString("finalidade"),
                            resultSet.getInt("id_peca_processual"),
                            resultSet.getString("status")
                    );
                }
            }
        }
        return null; // Ou lançar uma exceção
    }

    // Método para listar todos os atos processuais
    public List<AtosProcessuais> listarAtosProcessuais() throws SQLException {
        List<AtosProcessuais> atos = new ArrayList<>();
        String sql = "SELECT * FROM atosProcessuais";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                atos.add(new AtosProcessuais(
                        resultSet.getInt("id"),
                        resultSet.getString("autor"),
                        resultSet.getString("data_geracao"),
                        resultSet.getString("conteudo"),
                        resultSet.getString("finalidade"),
                        resultSet.getInt("id_peca_processual"),
                        resultSet.getString("status")
                ));
            }
        }
        return atos;
    }

    // Método para deletar um ato processual
    public void deletarAtoProcessual(int id) throws SQLException {
        String sql = "DELETE FROM atosProcessuais WHERE idAto = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}