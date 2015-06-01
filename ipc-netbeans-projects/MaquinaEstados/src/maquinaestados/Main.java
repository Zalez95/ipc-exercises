package maquinaestados;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */

public class Main {

    private static LoginStateMachine loginStateMachine;
    private static HomeStateMachine homeStateMachine;

    public static void main(String args[]) {
        loginStateMachine = new LoginStateMachine();
    }
    
    public static LoginStateMachine getStateMachineLogin() {
        return loginStateMachine;
    }
    
    public static HomeStateMachine getStateMachineHome() {
        return homeStateMachine;
    }

    public static void loginSucceed() {
        loginStateMachine.close();
        homeStateMachine = new HomeStateMachine();
    }

    public static void logOut() {
        homeStateMachine.close();
        loginStateMachine = new LoginStateMachine();
    }
}