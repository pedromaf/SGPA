package control;

import model.Colaborador;
import model.Orientacao;
import model.Projeto;
import model.Publicacao;
import model.sistema.Conta;
import view.Console;

import java.util.ArrayList;

public class SGPA {

    private static SGPA instancia;

    private Conta admin;

    private ArrayList<Colaborador> listaColaboradores;
    private ArrayList<Projeto> listaProjetos;
    private ArrayList<Publicacao> listaPublicacoes;
    private ArrayList<Orientacao> listaOrientacoes;

    private SGPA() {

        this.admin = Conta.getInstancia();
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

        //TODO
    }
}
