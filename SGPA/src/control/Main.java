package control;

import view.Console;

public class Main {

    public static void main(String[] args) {

        SGPA sgpa = SGPA.getInstancia();

        boolean sair = false;
        int opcao;

        do {
            Console.menuLogin();
            opcao = Input.validarOpcao(1,2);

            switch(opcao) {
                case 1:
                    sgpa.entrar();
                    break;
                case 2:
                default:
                    sair = true;
            }
        } while(!sair);
    }
}
