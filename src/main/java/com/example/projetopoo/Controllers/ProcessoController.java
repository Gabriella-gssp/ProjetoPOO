package com.example.projetopoo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.example.projetopoo.DAO.ProcessoDAO;
import com.example.projetopoo.Models.Processo;

import java.sql.Connection;
import java.sql.SQLException;

public class ProcessoController {
    private ProcessoDAO processoDAO;
    private Connection connection;

    public ProcessoController() {
        this.processoDAO = new ProcessoDAO(connection);
        // Inicialize aqui qualquer outra dependência necessária
    }

    public void adicionarProcesso(Processo processo) throws SQLException {
        // Lógica para adicionar um novo processo
        processoDAO.inserirProcesso(processo);
    }

    public Processo buscarProcessoPorNumero(int id) throws SQLException {
        // Lógica para buscar um processo pelo seu identificador
        return processoDAO.buscarProcessoPorNumero(String.valueOf(id));
    }

    public void atualizarProcesso(Processo processo) throws SQLException {
        // Lógica para atualizar um processo existente
        processoDAO.atualizarProcesso(processo);
    }

    public void deletarProcesso(int id) throws SQLException {

        processoDAO.deletarProcesso(String.valueOf(id));
    }

    @FXML
    private Label Processo;

    @FXML
    protected void onHelloButtonClick() {
        Processo.setText("Pagina dos processos");
    }
}