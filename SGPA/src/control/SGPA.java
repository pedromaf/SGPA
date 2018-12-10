package control;

import model.Colaborador;
import model.Orientacao;
import model.Projeto;
import model.Publicacao;
import model.sistema.Conta;
import model.sistema.Relatorio;
import view.Console;

import java.util.ArrayList;

public class SGPA {

    private static SGPA instancia;

    private Conta admin;

    private Relatorio relatorio;
    private ArrayList<Colaborador> listaColaboradores;
    private ArrayList<Projeto> listaProjetos;
    private ArrayList<Publicacao> listaPublicacoes;
    private ArrayList<Orientacao> listaOrientacoes;

    private SGPA() {

        this.admin = Conta.getInstancia();
        this.relatorio = Relatorio.getInstancia();
        this.listaColaboradores = new ArrayList<>();
        this.listaProjetos = new ArrayList<>();
        this.listaPublicacoes = new ArrayList<>();
        this.listaOrientacoes = new ArrayList<>();
    }

    public static SGPA getInstancia() {

        if(instancia == null) {
            instancia = new SGPA();
        }
        return instancia;
    }

    public void entrar() {

        String usuario;
        String senha;

        Console.solicitarUsuario();
        usuario = Input.lerString();

        Console.solicitarSenha();
        senha = Input.lerString();

        if(this.admin.validarUsuario(usuario)) {
            if(this.admin.validarSenha(senha)) {
                Console.loginEfetuado();
                menuPrincipal();
            } else {
                Console.loginInvalido();
            }
        } else {
            Console.loginInvalido();
        }
    }

    private void menuPrincipal() {

        boolean sair = false;
        int opcao;

        do {
            Console.menuPrincipal();
            opcao = Input.validarOpcao(1, 9);

            switch(opcao) {
                case 1:
                    registrarColaborador();
                    break;
                case 2:
                    criarProjeto();
                    break;
                case 3:
                    projetos();
                    break;
                case 4:
                    publicacoes();
                    break;
                case 5:
                    orientacoes();
                    break;
                case 6:
                    adicionarPublicacao();
                    break;
                case 7:
                    adicionarOrientacao();
                    break;
                case 8:
                    informacoes();
                    break;
                case 9:
                default:
                    sair = true;
            }
        } while(!sair);
    }

    private void registrarColaborador() {

        String nome;
        String email;
        int opcao;
        Colaborador.Tipo tipo;

        Console.solicitarNome();
        nome = Input.lerString();

        Console.solicitarEmail();
        email = Input.lerString();

        Console.menuSolicitarTipo();
        opcao = Input.validarOpcao(1,5);

        switch(opcao) {
            case 1:
                tipo = Colaborador.Tipo.PESQUISADOR;
                break;
            case 2:
                tipo = Colaborador.Tipo.PROFESSOR;
                break;
            case 3:
                tipo = Colaborador.Tipo.ALUNODOUTORADO;
                break;
            case 4:
                tipo = Colaborador.Tipo.ALUNOMESTRADO;
                break;
            case 5:
            default:
                tipo = Colaborador.Tipo.ALUNOGRADUACAO;
        }

        this.listaColaboradores.add(new Colaborador(nome, email, tipo));
        Console.colaboradorRegistrado();
    }

    private void criarProjeto() {

        String titulo;
        String descricao;
        String objetivo;
        Projeto novoProjeto;

        Console.solicitarTituloProjeto();
        titulo = Input.lerString();

        Console.solicitarDescricaoProjeto();
        descricao = Input.lerString();

        Console.solicitarObjetivoProjeto();
        objetivo = Input.lerString();

        novoProjeto = new Projeto(titulo, descricao, objetivo);
        this.listaProjetos.add(novoProjeto);
        Console.projetoCriado();
        menuProjeto(novoProjeto);
    }

    private void projetos() {

        if(!this.listaProjetos.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Projeto atual: this.listaProjetos) {
                Console.listar(++lista, atual.toString());
            }

        } else {
            Console.listaProjetosVazia();
        }
    }

    public void menuProjeto(Projeto projeto) {

        int opcao;
        boolean voltar = false;

        do {
            Console.menuProjeto(projeto.getTitulo(), projeto.toString(), projeto.emElaboracao());
            opcao = Input.validarOpcao(1, 6);

            switch(opcao) {
                case 1:
                    alocarColaborador(projeto);
                    break;
                case 2:
                    projeto.alterarInformacoes();
                    break;
                case 3:
                    associarPublicacao();
                    break;
                case 4:
                    projeto.removerColaborador();
                    break;
                case 5:
                    projeto.alterarEstado();
                    break;
                case 6:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }

    private void publicacoes() {

        //TODO
    }

    private void orientacoes() {

        //TODO
    }

    private void adicionarPublicacao() {

        //TODO
    }

    private void adicionarOrientacao() {

        //TODO
    }

    private void informacoes() {


        //TODO
    }

}
