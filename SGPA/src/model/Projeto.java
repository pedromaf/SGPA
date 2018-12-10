package model;

import model.sistema.Data;
import model.sistema.Relatorio;
import view.Console;

import java.util.ArrayList;

public class Projeto {

    public enum Estado {

        ELABORACAO, ANDAMENTO, CONCLUIDO
    }

    private Estado estado;
    private String titulo;
    private Data dataInicio;
    private Data dataConclusao;
    private String agenciaFinanciadora;
    private double valorFinanciado;
    private String objetivo;
    private String descricao;
    private ArrayList<Colaborador> listaColaboradores;
    private ArrayList<Publicacao> listaPublicacoesAssociadas;

    public Projeto(String titulo, String descricao, String objetivo) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.listaColaboradores = new ArrayList<>();
        this.listaPublicacoesAssociadas = new ArrayList<>();
        this.estado = Estado.ELABORACAO;
    }

    //ALTERAR INFORMACOES
    public void alterarInformacoes() {

        //TODO
    }


    //REMOVER COLABORADOR
    public void removerColaborador() {

        //TODO
    }


    //ESTADO
    public void alterarEstado() {

        if(this.estado != Estado.CONCLUIDO) {
            if(emElaboracao()) {
                iniciarProjeto();
            } else {
                concluirProjeto();
            }
        } else {
            Console.projetoJaConcluido();
        }
    }

    public boolean emElaboracao() {

        return (this.estado == Estado.ELABORACAO);
    }


    //VALIDACAO
    private boolean validarRequesitosMinimosIniciar() {

        //TODO
        return false;
    }

    private boolean validarRequesitosMinimosConcluir() {

        //TODO
        return false;
    }

    public void iniciarProjeto() {

        if(validarRequesitosMinimosIniciar()) {
            this.estado = Estado.ANDAMENTO;
            this.dataInicio = new Data();
            Console.projetoIniciado();
            Relatorio relatorio = Relatorio.getInstancia();
            relatorio.decrementarProjetosElaboracao();
            relatorio.incrementarProjetosAndamento();
        } else {
            Console.requisitosNecessariosIniciar();
        }
    }

    public void concluirProjeto() {

        if(validarRequesitosMinimosConcluir()) {
            this.estado = Estado.CONCLUIDO;
            this.dataConclusao = new Data();
            Console.projetoConcluido();
            Relatorio relatorio = Relatorio.getInstancia();
            relatorio.decrementarProjetosAndamento();
            relatorio.incrementarProjetosConcluidos();
        } else {
            Console.requisitosNecessariosConcluir();
        }
    }


    //GERAL
    public String getTitulo() {

        return this.titulo;
    }

    private String estadoString() {

        if(this.estado == Estado.ELABORACAO) {
            return "Em elaboracao";
        } else if(this.estado == Estado.ANDAMENTO) {
            return "Em andamento";
        } else {
            return "Concluido";
        }
    }

    public String toString() {

        return ("Titulo: " + this.titulo + " (" + estadoString() + ")\n" +
                "Descricao: " + this.descricao + "\n");
    }
}
