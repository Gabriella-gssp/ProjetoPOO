package com.example.projetopoo.Models;

public class GeradorCapaProcesso {

    public static String gerarCapa(Processo processo) {
        StringBuilder capa = new StringBuilder();
        capa.append("Capa do Processo\n");
        capa.append("Número do Processo: ").append(processo.getNumero()).append("\n");
        capa.append("Tipo: ").append(processo.getTipo()).append("\n");
        capa.append("Data de Protocolo: ").append(processo.getDataProtocolo()).append("\n");
        capa.append("Número no Tribunal: ").append(processo.getNumeroTribunal()).append("\n");
        capa.append("Tribunal: ").append(processo.getTribunal()).append("\n");
        capa.append("Instância: ").append(processo.getInstancia()).append("\n");

        // Aqui você pode adicionar mais informações relacionadas às partes do processo,
        // classificação ou qualquer outro detalhe relevante conforme a sua modelagem

        return capa.toString();
    }
}

