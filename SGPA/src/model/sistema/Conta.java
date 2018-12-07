package model.sistema;

public class Conta {

    private static Conta instancia;

    private String usuario;
    private String senha;

    private Conta() {

        this.usuario = "admin123";
        this.senha = "admin123";
    }

    public static Conta getInstancia() {

        if(instancia == null) {
            instancia = new Conta();
        }
        return instancia;
    }

    public boolean validarUsuario(String usuario) {

        return (this.usuario.equals(usuario));
    }

    public boolean validarSenha(String senha) {

        return (this.senha.equals(senha));
    }
}
