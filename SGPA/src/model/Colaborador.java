package model;

import view.Console;

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


    //INFORMACOES
    public void informacoes() {

        Console.mostrar("Nome: " + this.nome);
        Console.mostrar("Email: " + this.email);
        Console.mostrar("Tipo: " + stringTipo());

        if(!this.listaProjetosAssociados.isEmpty()) {
            informacoesProjetos();
        }

        if(!this.listaPublicacoesAssociadas.isEmpty()) {
            informacoesPublicacoes();
        }

        if((this.tipo == Tipo.PROFESSOR) && !this.listaOrientacoesAssociadas.isEmpty()) {
            informacoesOrientacoes();
        }
    }

    private void informacoesProjetos() {

        Console.mostrar("\nProjetos associados:");
        for(Projeto atual: this.listaProjetosAssociados) {
            Console.mostrar(atual.toString());
        }
    }

    private void informacoesPublicacoes() {

        Console.mostrar("\nPublicacoes associadas:");
        for(Publicacao atual: this.listaPublicacoesAssociadas) {
            Console.mostrar(atual.toString());
        }
    }

    private void informacoesOrientacoes() {

        Console.mostrar("\nOrientacoes associadas:");
        for(Orientacao atual: this.listaOrientacoesAssociadas) {
            Console.mostrar(atual.toString());
        }
    }


    //PUBLICACAO
    public void associarPublicacao(Publicacao publicacao) {

        this.listaPublicacoesAssociadas.add(publicacao);
    }


    //ORIENTACAO
    public void associarOrientacao(Orientacao orientacao) {

        if(this.tipo == Tipo.PROFESSOR) {
            this.listaOrientacoesAssociadas.add(orientacao);
        }
    }


    //PROJETO
    public void associarProjeto(Projeto projeto) {

        this.listaProjetosAssociados.add(projeto);
    }

    public void desassociarProjeto(Projeto projeto) {

        this.listaProjetosAssociados.remove(projeto);
    }

    //GERAL
    private String stringTipo() {

        if(this.tipo == Tipo.PESQUISADOR) {
            return "Pesquisador";
        } else if(this.tipo == Tipo.PROFESSOR) {
            return "Professor";
        } else if(this.tipo == Tipo.ALUNODOUTORADO) {
            return "Aluno de doutorado";
        } else if(this.tipo == Tipo.ALUNOMESTRADO) {
            return "Aluno de mestrado";
        } else {
            return "Aluno de graduacao";
        }
    }

    public boolean eProfessor() {

        return (this.tipo == Tipo.PROFESSOR);
    }

    public String getNome() {

        return (this.nome + " (" + stringTipo() + ")");
    }

    public boolean validoParaProjeto() {

        if(this.tipo == Tipo.ALUNOGRADUACAO) {
            int projetosEmAndamento = 0;
            for (Projeto atual : this.listaProjetosAssociados) {
                if (atual.emElaboracao() || atual.emAndamento()) {
                    projetosEmAndamento++;

                    if (projetosEmAndamento == 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
