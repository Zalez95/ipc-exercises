package maquinaestados;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class HelpControlador {
    private HelpWindow mivista;
    
    public HelpControlador(HelpWindow mivista){
        this.mivista = mivista;
    }
    
    /**
     * Metodo que implementa el boton de cerrar de la ventana de Ayuda, cierra
     * la ventana actual y abre la ventana LoginWindow.
     */
    public void cerrar(){
        Main.getStateMachineLogin().login();
    }
}