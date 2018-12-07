package model;

import java.util.ArrayList;

public class Colaborador {

    public enum Tipo {

        PESQUISADOR, PROFESSOR, ALUNODOUTORADO, ALUNOMESTRADO, ALUNOGRADUACAO;
    }

    private String nome;
    private String email;
    private Tipo tipo;

    private int projetosEmAndamento;
    private ArrayList<Projeto> listaProjetosAssociados;
    private ArrayList<Publicacao> listaPublicacoesAssociadas;
    private ArrayList<Orientacao> listaOrientacoesAssociadas;

    public Colaborador(String nome, String email, Tipo tipo) {

        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.projetosEmAndamento = 0;
        this.listaProjetosAssociados = new ArrayList<>();
        this.listaPublicacoesAssociadas = new ArrayList<>();
        this.listaOrientacoesAssociadas = new ArrayList<>();
    }




    //GERAL
    public boolean eProfessor() {

        return (this.tipo == Tipo.PROFESSOR);
    }

    public String getNome() {

        return this.nome;
    }
}
