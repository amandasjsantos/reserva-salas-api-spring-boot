package com.example.reserva.model;

public class Reserva {
    private int codigo;
    private String nomeDoResponsavel;
    private String sala;
    private String data;
    private String horario;
    private int qtdPessoas;

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome do responsável: " + nomeDoResponsavel + " | Sala: " + sala + " | Data: " + data + " | Horário: " + horario + " | Quantidade de pessoas: " + qtdPessoas;
    }

    public Reserva(int codigo, String nomeDoResponsavel, String sala, String data, String horario, int qtdPessoas) {
        this.codigo = codigo;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.sala = sala;
        this.data = data;
        this.horario = horario;
        this.qtdPessoas = qtdPessoas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
}
