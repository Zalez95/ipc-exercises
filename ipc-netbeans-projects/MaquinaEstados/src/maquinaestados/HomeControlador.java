package maquinaestados;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class HomeControlador {
    private HomeWindow mivista;
    
    public HomeControlador(HomeWindow mivista){
        this.mivista = mivista;
    }
    
    /**
     * Método que implementa el boton logOut de la ventana Home, cierra
     * la ventana actual y abre la ventana LoginWindow.
     */
    public void logOut(){
        Main.getStateMachineHome().close();
        Main.logOut();
    }
}
