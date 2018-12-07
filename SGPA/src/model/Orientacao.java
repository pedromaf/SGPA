package model;

import model.sistema.Data;
import view.Console;

public class Orientacao {

    private String titulo;
    private String texto;
    private Colaborador autor;
    private Data data;

    private Orientacao(String titulo, String texto, Colaborador autor) {

        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.data = new Data();
    }

    public Orientacao criarOrientacao(String titulo, String texto, Colaborador autor) {

        if(autor.eProfessor()) {
            return (new Orientacao(titulo, texto, autor));
        } else {
            Console.autorNaoEProfessor();
            return null;
        }
    }


    //GERAL
    public String toString() {

        return ("Titulo: " + this.titulo + "\n" +
                "Autor: " + this.autor.getNome() + "\n" +
                "Data: " + this.data.toString() + "\n\n\t" + this.texto + "\n\n");
    }
}
