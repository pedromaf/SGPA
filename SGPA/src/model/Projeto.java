package model;

import control.Input;
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
    private String objetivo;
    private String descricao;
    private String agenciaFinanciadora;
    private double valorFinanciado;
    private Data dataInicio;
    private Data dataConclusao;
    private ArrayList<Colaborador> listaColaboradores;
    private ArrayList<Publicacao> listaPublicacoesAssociadas;

    public Projeto(String titulo, String descricao, String objetivo, String agenciaFinanciadora, double valorFinanciado) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.listaColaboradores = new ArrayList<>();
        this.listaPublicacoesAssociadas = new ArrayList<>();
        this.estado = Estado.ELABORACAO;
    }


    //COLABORADOR
    public void removerColaborador() {

        if(!this.listaColaboradores.isEmpty()) {
            if(this.estado == Estado.ELABORACAO) {
                int lista = 0;
                int opcao;

                Console.selecioneColaboradorParaRemover();
                for(Colaborador atual: this.listaColaboradores) {
                    Console.listar(++lista, atual.getNome());
                }

                Console.listar(++lista, "Voltar");
                Console.selecioneOpcao();
                opcao = Input.validarOpcao(1, lista);

                if(opcao != lista) {
                    Colaborador colaborador = this.listaColaboradores.remove(opcao-1);
                    colaborador.desassociarProjeto(this);
                    Console.colaboradorRemovidoDoProjeto();
                }
            } else {
                Console.removerColaboradorInvalido();
            }
        } else {
            Console.projetoSemColaboradores();
        }
    }

    public void associarColaborador(Colaborador colaborador) {

        if(emElaboracao()) {
            this.listaColaboradores.add(colaborador);
        }
    }

    public boolean pertenceAoProjeto(Colaborador colaborador) {

        for(Colaborador atual: this.listaColaboradores) {
            if(atual.equals(colaborador)) {
                return true;
            }
        }
        return false;
    }


    //PUBLICACAO
    public boolean associadaAoProjeto(Publicacao publicacao) {

        for(Publicacao atual: this.listaPublicacoesAssociadas) {
            if(atual.equals(publicacao)) {
                return true;
            }
        }
        return false;
    }

    public void associarPublicacao(Publicacao publicacao) {

        this.listaPublicacoesAssociadas.add(publicacao);
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

    public boolean emAndamento() {

        return (this.estado == Estado.ANDAMENTO);
    }


    //VALIDACAO
    private boolean validarRequesitosMinimosIniciar() {

        for(Colaborador atual: this.listaColaboradores) {
            if(atual.eProfessor()) {
                return true;
            }
        }
        return false;
    }

    private boolean validarRequesitosMinimosConcluir() {

        return (!this.listaPublicacoesAssociadas.isEmpty());
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



    //INFORMACAO
    public void informacoes() {

        Console.mostrar("Titulo: " + this.titulo);
        Console.mostrar("Estado: " + estadoString());
        Console.mostrar("Descricao: " + this.descricao);
        Console.mostrar("Objetivo: " + this.objetivo);
        Console.mostrar("Agencia Financiadora: " + this.agenciaFinanciadora);
        Console.mostrar("Valor Financiado: " + this.valorFinanciado);
        if(this.dataInicio != null) {
            Console.mostrar("Data de inicio: " + this.dataInicio.toString());
        }
        if(this.dataConclusao != null) {
            Console.mostrar("Data de conclusao: " + this.dataConclusao.toString());
        }

        if(!this.listaColaboradores.isEmpty()) {
            informacoesColaboradores();
        }

        if(!this.listaPublicacoesAssociadas.isEmpty()) {
            informacoesPublicacoesAssociadas();
        }
    }

    private void informacoesColaboradores() {

        Console.mostrar("\nLista de colaboradores:");
        for(Colaborador atual: this.listaColaboradores) {
            Console.mostrar(atual.getNome());
        }
    }

    private void informacoesPublicacoesAssociadas() {

        Console.mostrar("\nLista de publicacoes associadas:");
        for(Publicacao atual: this.listaPublicacoesAssociadas) {
            Console.mostrar(atual.toString());
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
                "Descricao: " + this.descricao + "\n" +
                "Objetivo: " + this.objetivo + "\n");
    }
}
