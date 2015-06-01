package maquinaestados;

import javax.swing.JFrame;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class HomeStateMachine {

    private JFrame currentState;

    public HomeStateMachine() {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new HomeWindow();
                        currentState.setVisible(true);
                    }
                });
    } //HomeStateMachine()
    
    void close() {
        currentState.dispose(); 
    } //close
} //Login class