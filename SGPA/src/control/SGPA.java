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
                    adicionarColaborador();
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

    private void adicionarColaborador() {

        //TODO
    }

    private void criarProjeto() {

        //TODO
    }

    private void projetos() {

        //TODO
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
