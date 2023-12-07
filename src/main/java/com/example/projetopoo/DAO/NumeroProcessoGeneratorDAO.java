package com.example.projetopoo.DAO;

import com.example.projetopoo.Models.NumeroProcessoGenerator;
import com.example.projetopoo.Services.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class NumeroProcessoGeneratorDAO {
    private static final String SELECT_BY_TIPO = "SELECT * FROM NumeroProcessoGenerator WHERE tipoProcesso = ?";
    private static final String UPDATE_ULTIMO_NUMERO = "UPDATE NumeroProcessoGenerator SET ultimoNumero = ? WHERE tipoProcesso = ?";

    public NumeroProcessoGenerator getByTipo(String tipo) {
        try (Connection connection = DataBaseConnector.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_TIPO)) {

            preparedStatement.setString(1, tipo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    NumeroProcessoGenerator generator = new NumeroProcessoGenerator();
                    generator.setIdGenerator(resultSet.getInt("id_generator"));
                    generator.setTipoProcesso(resultSet.getString("tipo_processo"));
                    generator.setUltimoNumero(resultSet.getInt("ultimo_numero"));
                    return generator;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter gerador de número de processo", e);
        }
        return null;
    }

    public void updateUltimoNumero(NumeroProcessoGenerator generator) {
        try (Connection connection = DataBaseConnector.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ULTIMO_NUMERO)) {

            preparedStatement.setInt(1, generator.getUltimoNumero());
            preparedStatement.setString(2, generator.getTipoProcesso());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar último número do gerador de processo", e);
        }
    }
}
