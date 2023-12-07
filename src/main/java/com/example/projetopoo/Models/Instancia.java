package com.example.projetopoo.Models;

public enum Instancia {
    PRIMEIRA_INSTANCIA(1, "Varas de TJs"),
    SEGUNDA_INSTANCIA(2, "Colegiado de TJs"),
    TERCEIRA_INSTANCIA(3, "STJ");

    private final int valor;
    private final String descricao;

    Instancia(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Instancia porValor(int valor) {
        for (Instancia instancia : Instancia.values()) {
            if (instancia.getValor() == valor) {
                return instancia;
            }
        }
        throw new IllegalArgumentException("Valor de instância inválido: " + valor);
    }
}

