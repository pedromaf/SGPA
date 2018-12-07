package model;

import java.util.ArrayList;

public class Publicacao {

    private String titulo;
    private String conferenciaDePublicacao;
    private int anoPublicacao;
    private Projeto projetoAssociado;

    private ArrayList<Colaborador> listaAutores;

    public Publicacao(String titulo, String conferenciaDePublicacao, int anoPublicacao, Projeto projetoAssociado, ArrayList<Colaborador> listaAutores) {

        this.titulo = titulo;
        this.conferenciaDePublicacao = conferenciaDePublicacao;
        this.anoPublicacao = anoPublicacao;
        this.projetoAssociado = projetoAssociado;
        this.listaAutores = listaAutores;
    }

    //GERAL
    public String toString() {

        return ("Titulo: " + this.titulo + " (" + this.anoPublicacao + ")" + "\n" +
                "Publicacao: " + this.conferenciaDePublicacao + "\n");
    }
}
