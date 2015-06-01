package reservahotel.vista;

import reservahotel.Main;
import reservahotel.modelo.Reserva;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class FechaControlador {
    private FechaVista mivista;
    private Reserva mimodelo;
    
    // Constructor de la clase.
    public FechaControlador(FechaVista v, Reserva m){
        mivista = v;
        mimodelo = m;
    }
    
    /**
     * Método que comprueba si hay errores en las fechas seleccionadas.
     * En caso negativo pasa a la ventana de Habitaciones.
     */
    public void comprobar() {
        int i, diaEntrada, mesEntrada, añoEntrada, diaSalida, mesSalida, 
                añoSalida, numeroPersonas;
        boolean flag = false;
        boolean[] errores;
        
        // 1.- Toma los datos de la vista.
        diaEntrada = mivista.getDiaEntrada();
        mesEntrada = mivista.getMesEntrada();
        añoEntrada = mivista.getAñoEntrada();
        diaSalida = mivista.getDiaSalida();
        mesSalida = mivista.getMesSalida();
        añoSalida = mivista.getAñoSalida();
        numeroPersonas = mivista.getNumeroPersonas();
        
        // 2.- Comprobamos los errores.
        errores = mimodelo.compruebaFechaVista(diaEntrada, mesEntrada, añoEntrada,
                diaSalida, mesSalida, añoSalida, numeroPersonas);
        
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
            mimodelo.setFechaEntrada(diaEntrada, mesEntrada, añoEntrada);
            mimodelo.setFechaSalida(diaSalida, mesSalida, añoSalida);
            mimodelo.setNumeroPersonas(numeroPersonas);
            Main.getMaquinaEstados().siguiente1();
        } else { mivista.error(errores); }
    }
    
    /**
     * Método que implementa el botón de salir.
     */
    public void salir() {
        Main.getMaquinaEstados().close();
        System.exit(0);
    }
}