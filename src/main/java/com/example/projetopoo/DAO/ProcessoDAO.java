package com.example.projetopoo.DAO;

import com.example.projetopoo.Models.Processo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProcessoDAO {

    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public ProcessoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um novo processo no banco de dados
    public void inserirProcesso(Processo processo) throws SQLException {
        String sql = "INSERT INTO processo (numero_processo, tipo, data_protocolo, numero_tribunal, tribunal, instancia) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, processo.getNumero());
            preparedStatement.setString(2, processo.getTipo());
            preparedStatement.setDate(3, processo.getDataProtocolo());
            preparedStatement.setString(4, processo.getNumeroTribunal());
            preparedStatement.setString(5, processo.getTribunal());
            preparedStatement.setInt(6, processo.getInstancia());
            preparedStatement.executeUpdate();
        }
    }

    // Método para atualizar um processo existente no banco de dados
    public void atualizarProcesso(Processo processo) throws SQLException {
        String sql = "UPDATE processo SET tipo = ?, data_protocolo = ?, numero_tribunal = ?, tribunal = ?, instancia = ? WHERE numero_processo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, processo.getTipo());
            preparedStatement.setDate(2, processo.getDataProtocolo());
            preparedStatement.setString(3, processo.getNumeroTribunal());
            preparedStatement.setString(4, processo.getTribunal());
            preparedStatement.setInt(5, processo.getInstancia());
            preparedStatement.setString(6, processo.getNumero());
            preparedStatement.executeUpdate();
        }
    }

    // Método para buscar um processo pelo número do processo
    public Processo buscarProcessoPorNumero(String numeroProcesso) throws SQLException {
        String sql = "SELECT * FROM processo WHERE numero_processo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroProcesso);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Processo(
                            resultSet.getString("numero"),
                            resultSet.getString("tipo"),
                            resultSet.getDate("dataProtocolo"),
                            resultSet.getString("numeroTribunal"),
                            resultSet.getString("tribunal"),
                            resultSet.getInt("instancia")
                    );
                }
            }
        }
        return null; // Ou lançar uma exceção
    }

    // Método para listar todos os processos
    public List<Processo> listarProcessos() throws SQLException {
        List<Processo> processos = new ArrayList<>();
        String sql = "SELECT * FROM processo";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                processos.add(new Processo(
                        resultSet.getString("numero"),
                        resultSet.getString("tipo"),
                        resultSet.getDate("dataProtocolo"),
                        resultSet.getString("numero_tribunal"),
                        resultSet.getString("tribunal"),
                        resultSet.getInt("instancia")
                ));
            }
        }
        return processos;
    }

    // Método para deletar um processo
    public void deletarProcesso(String numeroProcesso) throws SQLException {
        String sql = "DELETE FROM processo WHERE numero_processo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroProcesso);
            preparedStatement.executeUpdate();
        }
    }
}
