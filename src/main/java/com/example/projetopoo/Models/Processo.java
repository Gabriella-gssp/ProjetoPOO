package com.example.projetopoo.Models;

import java.util.Date;

public class Processo {
    private String numero;
    private String tipo;
    private Date dataProtocolo;
    private String numeroTribunal;
    private String tribunal;
    private int instancia;

    // Construtor
    public Processo(String numero, String tipo, Date dataProtocolo,
                    String numeroTribunal, String tribunal, int instancia) {
        this.numero = numero;
        this.tipo = tipo;
        this.dataProtocolo = dataProtocolo;
        this.numeroTribunal = numeroTribunal;
        this.tribunal = tribunal;
        this.instancia = instancia;
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public java.sql.Date getDataProtocolo() {
        return (java.sql.Date) dataProtocolo;
    }

    public void setDataProtocolo(Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public String getNumeroTribunal() {
        return numeroTribunal;
    }

    public void setNumeroTribunal(String numeroTribunal) {
        this.numeroTribunal = numeroTribunal;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public int getInstancia() {
        return instancia;
    }

    public void setInstancia(int instancia) {
        this.instancia = instancia;
    }

    // Método para representar o objeto Processo como uma String (opcional)
    @Override
    public String toString() {
        return "Processo{" +
                "numeroProcesso='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", dataProtocolo='" + dataProtocolo + '\'' +
                ", numeroTribunal='" + numeroTribunal + '\'' +
                ", tribunal='" + tribunal + '\'' +
                ", instancia='" + instancia + '\'' +
                '}';
    }
}
