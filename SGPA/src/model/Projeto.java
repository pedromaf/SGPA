package model;

import model.sistema.Data;
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
        } else {
            Console.requisitosNecessariosIniciar();
        }
    }

    public void concluirProjeto() {

        if(validarRequesitosMinimosConcluir()) {
            this.estado = Estado.CONCLUIDO;
            this.dataConclusao = new Data();
        } else {
            Console.requisitosNecessariosConcluir();
        }
    }
}
