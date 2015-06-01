package maquinaestados;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class LoginControlador {
    private LoginWindow mivista;
    
    public LoginControlador(LoginWindow mivista) {
        this.mivista = mivista;
    }

    /**
     * Metodo que implementa el boton de Recuperar Contraseña, cierra la 
     * ventana actual y abre la ventana PasswordRecoveryWindow.
     */
    void recuperar() {
        Main.getStateMachineLogin().recoverPassword();
    }

    /**
     * Método que implementa el boton de help, cierra la ventana actual y abre 
     * la ventana de HelpWindow.
     */
    void ayuda() {
        Main.getStateMachineLogin().help();
    }

    /**
     * Método que implementa el boton de login, cierra la ventana actual y abre
     * la ventana HomeWindow.
     */
    void login() {
        Main.loginSucceed();
    }

    /**
     * Método que implementa el boton de Salir del programa, cierra la ventana 
     * actual y sale del programa.
     */
    void salir() {
        Main.getStateMachineLogin().close();
        System.exit(0);
    }
}