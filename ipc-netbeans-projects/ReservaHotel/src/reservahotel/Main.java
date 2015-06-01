package reservahotel;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class Main {
    private static MaquinaEstados stateMachine;

    public static void main(String args[]) {
        /* Argumentos:
         * 0: Si hay disponibilidad.
         * 1: No hay disponibilidad
         * Cualquier otro caso: mostrará un error por pantalla.
         */
        int disponibilidad = -1;
        
        // Comprobamos el número de argumentos.
        if (args.length != 1) {
            System.out.println("Error en el número de argumentos, Tiene que introducir 0 o 1.");
            System.exit(-1);
        }
        
        // Comprobamos si el argumento pasado es un número.
        try {
            disponibilidad = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) { 
            System.out.println("Tiene que introducir 0 o 1.");
            System.exit(-1);
        }
        
        // Comprobamos si el número pasado es 0 o 1.
        if ((disponibilidad != 0) & (disponibilidad != 1)){
            System.out.println("Tiene que introducir 0 o 1.");
            System.exit(-1);
        }
        
        stateMachine = new MaquinaEstados(disponibilidad);
    }
    
    public static MaquinaEstados getMaquinaEstados() {
        return stateMachine;
    }
}