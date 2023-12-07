package com.example.projetopoo.Models;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

public class PecaProcessual {

    private int id;
    private String conteudoTextual; // O texto da peça processual.
    private LocalDate dataGeracao; // A data de geração do documento.

    // Construtor
    public PecaProcessual(int id, String conteudoTextual, LocalDate dataGeracao) {
        this.id = id;
        this.conteudoTextual = conteudoTextual;
        this.dataGeracao = dataGeracao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudoTextual() {
        return conteudoTextual;
    }

    public void setConteudoTextual(String conteudoTextual) {
        this.conteudoTextual = conteudoTextual;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    // Método para gerar PDF da peça processual (pseudo-código, implementação depende da biblioteca de geração de PDF que você escolher)
    public void gerarPDF(String caminhoArquivo) {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(caminhoArquivo));
            documento.open();
            documento.add(new Paragraph(this.conteudoTextual));
            documento.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
