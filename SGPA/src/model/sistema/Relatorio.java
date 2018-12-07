package model.sistema;

public class Relatorio {

    private static Relatorio instancia;

    private int totalColaboradores;
    private int totalProjetos;
    private int totalProjetosConcluidos;
    private int totalProjetosElaboracao;
    private int totalProjetosAndamento;
    private int totalPublicacoes;
    private int totalOrientacoes;

    private Relatorio() {

        this.totalColaboradores = 0;
        this.totalProjetos = 0;
        this.totalProjetosConcluidos = 0;
        this.totalProjetosElaboracao = 0;
        this.totalProjetosAndamento = 0;
        this.totalPublicacoes = 0;
        this.totalOrientacoes = 0;
    }

    public static Relatorio getInstancia() {

        if(instancia == null) {
            instancia = new Relatorio();
        }
        return instancia;
    }


    //VARIAVEIS
    public void incrementarColaboradores() {

        this.totalColaboradores++;
    }

    public void incrementarProjetos() {

        this.totalProjetos++;
    }

    public void incrementarProjetosConcluidos() {

        this.totalProjetosConcluidos++;
    }

    public void incrementarProjetosElaboracao() {

        this.totalProjetosElaboracao++;
    }

    public void decrementarProjetosElaboracao() {

        this.totalProjetosElaboracao--;
    }

    public void incrementarProjetosAndamento() {

        this.totalProjetosAndamento++;
    }

    public void decrementarProjetosAndamento() {

        this.totalProjetosAndamento--;
    }

    public void incrementarPublicacoes() {

        this.totalPublicacoes++;
    }

    public void incrementarOrientacoes() {

        this.totalOrientacoes++;
    }


    //GERAL
    public String toString() {

        return ("\n\t\t[Relatorio]\n\n" +
                "Total de colaboradores: " + this.totalColaboradores + "\n" +
                "Total de projetos: " + this.totalProjetos + "\n" +
                "Total de projetos concluidos: " + this.totalProjetosConcluidos + "\n" +
                "Total de projetos em elaboracao: " + this.totalProjetosElaboracao + "\n" +
                "Total de projetos em andamento: " + this.totalProjetosAndamento + "\n" +
                "Total de publicacoes: " + this.totalPublicacoes + "\n" +
                "Total de orientacoes: " + this.totalOrientacoes + "\n");
    }
}
