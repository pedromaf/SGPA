package view;

public class Console {

    //GERAL
    public static void selecioneOpcao() {

        System.out.println("\nDigite o numero da opcao:");
    }

    public static void listar(int opcao, String informacao) {

        System.out.println("[" + opcao + "] " + informacao);
    }

    public static void mostrar(String informacao) {

        System.out.println(informacao);
    }


    //LOGIN
    public static void loginInvalido() {

        System.out.println("Usuario ou senha invalidos!\n");
    }

    public static void loginEfetuado() {

        System.out.println("Login efetuado! Bem vindo.\n");
    }


    //INPUT
    public static void opcaoInvalida(int limite1, int limite2) {

        System.out.println("Opcao invalida! digite valores entre " + limite1 + " e " + limite2 + ".");
    }

    public static void solicitarUsuario() {

        System.out.println("Digite o usuario:");
    }

    public static void solicitarSenha() {

        System.out.println("Digite a senha:");
    }

    public static void solicitarNome() {

        System.out.println("Digite o nome do colaborador:");
    }

    public static void solicitarEmail() {

        System.out.println("Digite o email do colaborador:");
    }

    public static void solicitarTituloProjeto() {

        System.out.println("Digite o titulo do projeto:");
    }

    public static void solicitarDescricaoProjeto() {

        System.out.println("Digite a descricao do projeto:");
    }

    public static void solicitarObjetivoProjeto() {

        System.out.println("Digite o objetivo do projeto:");
    }

    public static void solicitarTituloPublicacao() {

        System.out.println("Digite o titulo da publicacao:");
    }

    public static void solicitarConferenciaDePublicacao() {

        System.out.println("Digite o nome da conferencia de publicacao:");
    }

    public static void solicitarAnoPublicacao() {

        System.out.println("Digite o ano de publicacao:");
    }

    public static void solicitarTituloOrientacao() {

        System.out.println("Digite o titulo da orientacao:");
    }

    public static void selecioneAutorOrientacao() {

        System.out.println("Selecione o autor da orientacao:");
    }

    public static void solicitarTextoOrientacao() {

        System.out.println("Digite o texto da orientacao:");
    }

    public static void solicitarAgenciaFinanciadora() {

        System.out.println("Digite o nome da agencia financiadora:");
    }

    public static void solicitarValorFinanciado() {

        System.out.println("Digite o valor financiado pela agencia:");
    }


    //MENUS
    public static void menuLogin() {

        System.out.println("\n\t\t[S.G.P.A]\n");
        System.out.println("[1] Entrar");
        System.out.println("[2] Sair");

        selecioneOpcao();
    }

    public static void menuPrincipal() {

        System.out.println("\n\t\t[Laboratorio de Pesquisa]\n");
        System.out.println("[1] Registrar colaborador");
        System.out.println("[2] Criar projeto");
        System.out.println("[3] Projetos");
        System.out.println("[4] Publicacoes");
        System.out.println("[5] Orientacoes");
        System.out.println("[6] Adicionar publicacao");
        System.out.println("[7] Adicionar orientacao");
        System.out.println("[8] Informacoes");
        System.out.println("[9] Sair");

        selecioneOpcao();
    }

    public static void menuProjeto(String titulo, String informacoesProjeto, boolean emElaboracao) {

        System.out.println("\n\t\t[Projeto]\n");

        System.out.println(informacoesProjeto);

        System.out.println("[1] Alocar colaborador");
        System.out.println("[2] Associar publicacao");
        System.out.println("[3] Remover colaborador");
        if(emElaboracao) {
            System.out.println("[4] Iniciar projeto");
        } else {
            System.out.println("[4] Concluir projeto");
        }
        System.out.println("[5] Voltar");

        selecioneOpcao();
    }

    public static void menuInformacoes() {

        System.out.println("\n\t\t[Informacoes]\n");
        System.out.println("[1] Consultar colaborador");
        System.out.println("[2] Consultar projeto");
        System.out.println("[3] Relatorio");
        System.out.println("[4] Voltar");

        selecioneOpcao();
    }

    public static void menuSolicitarTipo() {

        System.out.println("\nSelecione o tipo de colaborador:\n");
        System.out.println("[1] Pesquisador");
        System.out.println("[2] Professor");
        System.out.println("[3] Aluno de doutorado");
        System.out.println("[4] Aluno de mestrado");
        System.out.println("[5] Aluno de graduacao");

        selecioneOpcao();
    }

    public static void menuOutroAutor() {

        System.out.println("Selecionar outro autor?");
        System.out.println("[1] Sim");
        System.out.println("[2] Nao");

        selecioneOpcao();
    }


    //REGISTRAR COLABORADOR
    public static void colaboradorRegistrado() {

        System.out.println("Colaborador registrado!\n");
    }


    //PROJETO
    public static void requisitosNecessariosIniciar() {

        System.out.println("Projeto nao atende aos requisitos minimos para ser iniciado!\n");
    }

    public static void requisitosNecessariosConcluir() {

        System.out.println("Projeto nao atende aos requisitos minimos para ser concluido!\n");
    }

    public static void projetoCriado() {

        System.out.println("Projeto criado!\n");
    }

    public static void listaProjetosVazia() {

        System.out.println("Ainda nao ha projetos.\n");
    }

    public static void projetoJaConcluido() {

        System.out.println("Erro! Projeto ja foi concluido.\n");
    }

    public static void projetoConcluido() {

        System.out.println("Projeto concluido!\n");
    }

    public static void projetoIniciado() {

        System.out.println("Projeto Iniciado!\n");
    }

    public static void alocacaoNaoPermitida() {

        System.out.println("Alocacao de colaborador nao permitida.\n");
    }

    public static void colaboradorJaPertenceAoProjeto() {

        System.out.println("Colaborador ja pertence ao projeto!\n");
    }

    public static void colaboradorInvalidoParaProjeto() {

        System.out.println("Colaborador invalido para o projeto! Limite de projetos atingido.\n");
    }

    public static void projetoSemColaboradores() {

        System.out.println("Nenhum colaborador associado ao projeto.\n");
    }

    public static void selecioneColaboradorParaRemover() {

        System.out.println("Selecione o colaborador que deseja remover do projeto:");
    }

    public static void colaboradorRemovidoDoProjeto() {

        System.out.println("Colaborador removido do projeto!\n");
    }


    //PUBLICACAO
    public static void listaPublicacoesVazia() {

        System.out.println("Ainda nao ha publicacoes.\n");
    }

    public static void nenhumAutorDisponivel() {

        System.out.println("Nao ha colaboradores no laboratorio.\n");
    }

    public static void selecioneOsAutores() {

        System.out.println("Selecione os autores:");
    }

    public static void publicacaoAdicionada() {

        System.out.println("Publicacao adicionada!\n");
    }

    public static void autorJaSelecionado() {

        System.out.println("Voce ja selecionou este autor!\n");
    }

    public static void publicacaoJaAssociada() {

        System.out.println("Publicacao ja esta associada ao projeto!\n");
    }

    public static void publicacaoAssociada() {

        System.out.println("Publicacao associada ao projeto!\n");
    }


    //ORIENTACAO
    public static void autorNaoEProfessor() {

        System.out.println("Erro! Apenas professores podem adicionar orientacoes.\n");
    }

    public static void listaOrientacoesVazia() {

        System.out.println("Ainda nao ha orientacoes.\n");
    }

    public static void orientacaoAdicionada() {

        System.out.println("Orientacao adicionada!\n");
    }


    //INFORMACOES
    public static void nenhumColaboradorRegistrado() {

        System.out.println("Nao ha colaboradores registrados!\n");
    }
}
