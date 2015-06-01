package maquinaestados;

import javax.swing.JFrame;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class LoginStateMachine {

    private JFrame currentState;

    public LoginStateMachine() {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new LoginWindow();
                        currentState.setVisible(true);
                    }
                });
    } //LoginStateMachine()
    
    public void login() {
        currentState.dispose();
        //realiza transición
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
                currentState = new LoginWindow();
                currentState.setVisible(true);
            }
        });
    }

    public void recoverPassword() {
        currentState.dispose();
        //realiza transición
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new PasswordRecoveryWindow();
                        currentState.setVisible(true);
                    }
                });
    } //recoverPassword

    public void help() {
        currentState.dispose();
        //realiza transición
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new HelpWindow();
                        currentState.setVisible(true);
                    }
                });
    } //help

    public void close() {
        currentState.dispose();
    } //close
} //Login class