package model;

import view.Console;

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
        associaAutores();
    }

    private void associaAutores() {

        for(Colaborador atual: this.listaAutores) {
            atual.associarPublicacao(this);
        }
    }

    public void informacao() {

        Console.mostrar(toString());
        informacaoAutores();
    }

    private void informacaoAutores() {

        Console.mostrar("Autores:");
        for(Colaborador atual: this.listaAutores) {
            atual.getNome();
        }
    }

    //GERAL
    public String getTitulo() {

        return (this.titulo + " (" + this.anoPublicacao + ")");
    }

    public String toString() {

        return ("Titulo: " + getTitulo() + "\n" +
                "Publicacao: " + this.conferenciaDePublicacao + "\n" +
                (this.projetoAssociado != null ? ("Projeto: " + this.projetoAssociado.getTitulo()) : ""));
    }
}
