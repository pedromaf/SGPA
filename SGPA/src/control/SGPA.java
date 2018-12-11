package control;

import model.Colaborador;
import model.Orientacao;
import model.Projeto;
import model.Publicacao;
import model.sistema.Conta;
import model.sistema.Relatorio;
import view.Console;

import java.util.ArrayList;

class SGPA {
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

    static SGPA getInstancia() {

        if(instancia == null) {
            instancia = new SGPA();
        }
        return instancia;
    }

    void entrar() {

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
                    menuInformacoes();
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
        this.relatorio.incrementarColaboradores();
    }

    private void criarProjeto() {

        String titulo;
        String descricao;
        String objetivo;
        String agenciaFinanciadora;
        double valorFinanciado;
        Projeto novoProjeto;

        Console.solicitarTituloProjeto();
        titulo = Input.lerString();

        Console.solicitarDescricaoProjeto();
        descricao = Input.lerString();

        Console.solicitarObjetivoProjeto();
        objetivo = Input.lerString();

        Console.solicitarAgenciaFinanciadora();
        agenciaFinanciadora = Input.lerString();

        Console.solicitarValorFinanciado();
        valorFinanciado = Input.lerDouble();

        novoProjeto = new Projeto(titulo, descricao, objetivo, agenciaFinanciadora, valorFinanciado);
        this.listaProjetos.add(novoProjeto);
        Console.projetoCriado();
        this.relatorio.incrementarProjetos();
        this.relatorio.incrementarProjetosElaboracao();
        menuProjeto(novoProjeto);
    }

    private void projetos() {

        if(!this.listaProjetos.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Projeto atual: this.listaProjetos) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                menuProjeto(this.listaProjetos.get(opcao-1));
            }
        } else {
            Console.listaProjetosVazia();
        }
    }

    private void menuProjeto(Projeto projeto) {

        if(projeto != null) {
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
                        associarPublicacao(projeto);
                        break;
                    case 3:
                        projeto.removerColaborador();
                        break;
                    case 4:
                        projeto.alterarEstado();
                        break;
                    case 5:
                    default:
                        voltar = true;
                }
            } while(!voltar);
        }
    }

    private void publicacoes() {

        if(!this.listaPublicacoes.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Publicacao atual: this.listaPublicacoes) {
                Console.listar(++lista, atual.getTitulo());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                this.listaPublicacoes.get(opcao-1).informacao();
            }
        } else {
            Console.listaPublicacoesVazia();
        }
    }

    private void orientacoes() {

        if(!this.listaOrientacoes.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Orientacao atual: this.listaOrientacoes) {
                Console.listar(++lista, atual.getTitulo());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                Console.mostrar(this.listaOrientacoes.get(opcao-1).toString());
            }
        } else {
            Console.listaOrientacoesVazia();
        }
    }

    private void adicionarPublicacao() {

        if(!this.listaColaboradores.isEmpty()) {

            String titulo;
            String conferenciaDePublicacao;
            int anoPublicacao;

            ArrayList<Colaborador> listaAutores;

            Console.solicitarTituloPublicacao();
            titulo = Input.lerString();

            Console.solicitarConferenciaDePublicacao();
            conferenciaDePublicacao = Input.lerString();

            Console.solicitarAnoPublicacao();
            anoPublicacao = Input.lerInt();

            Console.selecioneOsAutores();
            listaAutores = escolherAutores();

            this.listaPublicacoes.add(new Publicacao(titulo, conferenciaDePublicacao, anoPublicacao, null, listaAutores));
            this.relatorio.incrementarPublicacoes();
            Console.publicacaoAdicionada();
        } else {
            Console.nenhumAutorDisponivel();
        }

    }

    private ArrayList<Colaborador> escolherAutores() {

        ArrayList<Colaborador> autores = new ArrayList<>();

        if(!this.listaColaboradores.isEmpty()) {
            int lista;
            int opcao;
            Colaborador autor;

            do {
                lista = 0;
                for(Colaborador atual: this.listaColaboradores) {
                    Console.listar(++lista, atual.getNome());
                }

                Console.selecioneOpcao();
                opcao = Input.validarOpcao(1, lista);

                autor = this.listaColaboradores.get(opcao-1);
                if(!autores.contains(autor)) {
                    autores.add(autor);
                } else {
                    Console.autorJaSelecionado();
                }

                Console.menuOutroAutor();
            } while(Input.validarOperacaoBinaria());
        }

        return autores;
    }

    private void adicionarOrientacao() {

        String titulo;
        String texto;
        Colaborador autor;
        boolean autorValido = false;
        int lista = 0;
        int opcao;
        Orientacao novaOrientacao;

        Console.solicitarTituloOrientacao();
        titulo = Input.lerString();

        Console.solicitarTextoOrientacao();
        texto = Input.lerString();

        do {

            Console.selecioneAutorOrientacao();
            for(Colaborador atual: this.listaColaboradores) {
                Console.listar(++lista, atual.getNome());
            }

            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            autor = this.listaColaboradores.get(opcao-1);
            novaOrientacao = Orientacao.criarOrientacao(titulo, texto, autor);

            if(novaOrientacao != null) {
                autorValido = true;
            }
        }while(!autorValido);

        this.listaOrientacoes.add(novaOrientacao);
        this.relatorio.incrementarOrientacoes();
        Console.orientacaoAdicionada();
    }

    private void menuInformacoes() {

        int opcao;
        boolean voltar = false;

        do {
            Console.menuInformacoes();
            opcao = Input.validarOpcao(1, 4);

            switch(opcao) {
                case 1:
                    consultarColaborador();
                    break;
                case 2:
                    consultarProjeto();
                    break;
                case 3:
                    Console.mostrar(this.relatorio.toString());
                    break;
                case 4:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }

    private void alocarColaborador(Projeto projeto) {

        if(projeto.emElaboracao()) {
            int lista = 0;
            int opcao;
            Colaborador colaborador;

            for(Colaborador atual: this.listaColaboradores) {
                Console.listar(++lista, atual.getNome());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                colaborador = this.listaColaboradores.get(opcao-1);
                if(!projeto.pertenceAoProjeto(colaborador)) {
                    if(colaborador.validoParaProjeto()) {
                        projeto.associarColaborador(colaborador);
                        colaborador.associarProjeto(projeto);
                        Console.colaboradorAlocado();
                    } else {
                        Console.colaboradorInvalidoParaProjeto();
                    }
                } else {
                    Console.colaboradorJaPertenceAoProjeto();
                }
            }
        } else {
            Console.alocacaoNaoPermitida();
        }

    }

    private void associarPublicacao(Projeto projeto) {

        if(!this.listaPublicacoes.isEmpty()) {
            int lista = 0;
            int opcao;
            Publicacao publicacao;

            for(Publicacao atual: this.listaPublicacoes) {
                Console.listar(++lista, atual.getTitulo());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                publicacao = this.listaPublicacoes.get(opcao-1);
                if(!projeto.associadaAoProjeto(publicacao)) {
                    projeto.associarPublicacao(publicacao);
                    Console.publicacaoAssociada();
                } else {
                    Console.publicacaoJaAssociada();
                }
            }
        } else {
            Console.listaPublicacoesVazia();
        }
    }

    private void consultarColaborador() {

        if(!this.listaColaboradores.isEmpty()) {

            int lista = 0;
            int opcao;

            for(Colaborador atual: this.listaColaboradores) {
                Console.listar(++lista, atual.getNome());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                this.listaColaboradores.get(opcao-1).informacoes();
            }
        } else {
            Console.nenhumColaboradorRegistrado();
        }
    }

    private void consultarProjeto() {

        if(!this.listaProjetos.isEmpty()) {

            int lista = 0;
            int opcao;

            for(Projeto atual: this.listaProjetos) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                this.listaProjetos.get(opcao-1).informacoes();
            }
        } else {
            Console.listaProjetosVazia();
        }
    }

}
