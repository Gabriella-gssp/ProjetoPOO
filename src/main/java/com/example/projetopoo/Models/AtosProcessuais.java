package com.example.projetopoo.Models;

public class AtosProcessuais {

    private int id;
    private String autoria;
    private String dataGeracao;
    private String conteudo;
    private String finalidade;
    private int idPecaProcessual;
    private String status;

    // Construtor
    public AtosProcessuais(int id, String autoria, String dataGeracao, String conteudo,
                           String finalidade, int idPecaProcessual, String status) {
        this.id = id;
        this.autoria = autoria;
        this.dataGeracao = dataGeracao;
        this.conteudo = conteudo;
        this.finalidade = finalidade;
        this.idPecaProcessual = idPecaProcessual;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoria() {
        return autoria;
    }

    public void setAutoria(String autoria) {
        this.autoria = autoria;
    }

    public String getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(String dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public int getIdPecaProcessual() {
        return idPecaProcessual;
    }

    public void setIdPecaProcessual(int idPecaProcessual) {
        this.idPecaProcessual = idPecaProcessual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para representar o objeto AtoProcessual como uma String (opcional)
    @Override
    public String toString() {
        return "AtoProcessual{" +
                "id=" + id +
                ", autor='" + autoria + '\'' +
                ", dataGeracao='" + dataGeracao + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", finalidade='" + finalidade + '\'' +
                ", idPecaProcessual=" + idPecaProcessual +
                ", status=" + status +
                '}';
    }
}
