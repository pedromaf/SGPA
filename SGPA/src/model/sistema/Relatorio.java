package model.sistema;

public class Relatorio {

    private Relatorio instancia;

    private int totalColaboradores;
    private int totalProjetos;
    private int totalProjetosConcluidos;
    private int totalProjetosElaboracao;
    private int totalProjetosAndamento;
    private int totalPublicacoes;
    private int totalOrientacoes;

    private Relatorio() {

        this.totalProjetos = 0;
        this.totalColaboradores = 0;
        this.totalProjetosConcluidos = 0;
        this.totalProjetosElaboracao = 0;
        this.totalProjetosAndamento = 0;
        this.totalPublicacoes = 0;
        this.totalOrientacoes = 0;
    }

    public Relatorio getInstancia() {

        if(this.instancia == null) {
            this.instancia = new Relatorio();
        }
        return this.instancia;
    }

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
