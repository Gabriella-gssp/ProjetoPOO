package com.example.projetopoo.Controllers;

import com.example.projetopoo.Models.AtosProcessuais;
import com.example.projetopoo.DAO.AtoProcessualDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AtoProcessualController {
    private AtoProcessualDAO atoProcessualDAO;
    private Connection connection;
    @FXML
    private Label welcomeText;

    public AtoProcessualController() {
        atoProcessualDAO = new AtoProcessualDAO(connection);
    }

    public void criarAtoProcessual(AtosProcessuais ato) {
        // Implementar lógica para criar um novo ato processual
    }

    public AtosProcessuais lerAtoProcessual(int id) {
        // Implementar lógica para ler um ato processual pelo ID
        return null;
    }

    public void atualizarAtoProcessual(AtosProcessuais ato) {
        // Implementar lógica para atualizar um ato processual
    }

    public void excluirAtoProcessual(int id) {
        // Implementar lógica para excluir um ato processual
    }

    public List<AtosProcessuais> pesquisarAtosProcessuais(String criterio) {
        // Implementar lógica para pesquisar atos processuais com base em um critério
        return new ArrayList<>();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}