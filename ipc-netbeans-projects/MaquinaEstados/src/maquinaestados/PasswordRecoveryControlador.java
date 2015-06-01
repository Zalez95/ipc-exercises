package maquinaestados;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class PasswordRecoveryControlador {
    private PasswordRecoveryWindow mivista;
    
    public PasswordRecoveryControlador (PasswordRecoveryWindow mivista){
        this.mivista = mivista;
    }
    
    /**
     * Método que implementa el botón de cerrar, cierra la ventana actual
     * y abre la ventana LoginWindow.
     */
    public void cerrar(){
        Main.getStateMachineLogin().login();
    }
}