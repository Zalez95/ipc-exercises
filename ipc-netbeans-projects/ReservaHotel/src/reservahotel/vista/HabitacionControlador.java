package reservahotel.vista;

import reservahotel.Main;
import reservahotel.modelo.Reserva;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class HabitacionControlador {
    private HabitacionVista mivista;
    private Reserva mimodelo;
    
    // Constructor de la clase.
    public HabitacionControlador(HabitacionVista v, Reserva m){
        mivista = v;
        mimodelo = m;
    }
    
    /**
     * Método que comprueba si se ha seleccionado un tipo de habitación y un 
     * tipo de pensión. 
     * En caso afirmativo pasa a la ventana de Datos.
     */
    public void siguiente() {
        int i, habitacionSeleccionada, pensionSeleccionada;
        boolean[] errores;
        boolean flag = false;
        
        // 1.- Toma los datos de la vista.
        habitacionSeleccionada = mivista.getHabitacion();
        pensionSeleccionada = mivista.getPension();
        
        // 2.- Comprobamos los errores.
        errores = mimodelo.compruebaHabitacionVista(habitacionSeleccionada, pensionSeleccionada);
    
        for (i = 0; i < errores.length; i++){
            if (errores[i] == true){
                flag = true;
                i = errores.length;
            }
        }
        
        /* 3.- En el caso de que no hubiese errores, se cambiarán los datos
         * del modelo y se cambiará de estado, 
         * si hubo algun error se modificará la vista actual.
         */
        if (flag == false){
            mimodelo.setHabitacion(habitacionSeleccionada);
            mimodelo.setPension(pensionSeleccionada);
            Main.getMaquinaEstados().siguiente2();
        } else { mivista.error(errores); }
    }
    
    /**
     * Método que implementa el botón de atrás.
     */
    public void atras() {
        Main.getMaquinaEstados().atras1();
    }
    
    /**
     * Método que implementa el botón de cancelar.
     */
    public void cancelar() {
        Main.getMaquinaEstados().cancelar();
    }
}