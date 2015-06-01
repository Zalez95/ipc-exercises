package reservahotel;

import javax.swing.JFrame;
import reservahotel.modelo.Reserva;
import reservahotel.vista.DatosVista;
import reservahotel.vista.FechaVista;
import reservahotel.vista.HabitacionVista;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class MaquinaEstados {
    private JFrame currentState;
    private Reserva modelo;
    
    /**
     * Constructor con parámetro
     * @param disponibilidad, el valor de disponibilidad con el que crearemos
     * la instancia de MaquinaEstados.
     */
    public MaquinaEstados(int disponibilidad) {
        modelo = new Reserva();
        modelo.setDisponibilidad(disponibilidad);
        
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new FechaVista(modelo);
                        currentState.setVisible(true);
                    }
                });
    }
    
    /**
     * Realiza transición de FechaVista a HabitaciónVista.
     */
    public void siguiente1() {
        currentState.dispose();
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
                currentState = new HabitacionVista(modelo);
                currentState.setVisible(true);
            }
        });
    }
    
    /**
     * Realiza transición de HabitacionVista a FechaVista.
     */
    public void atras1() {
        currentState.dispose();
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new FechaVista(modelo);
                        currentState.setVisible(true);
                    }
                });
    }

    /**
     * Realiza transición de HabitacionVista a DatosVista.
     */
    public void siguiente2() {
        currentState.dispose();
        //realiza transición
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new DatosVista(modelo);
                        currentState.setVisible(true);
                    }
                });
    }
    
    /**
     * Realiza transición de DatosVista a HabitacionVista.
     */
    public void atras2() {
        currentState.dispose();
        //realiza transición
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new HabitacionVista(modelo);
                        currentState.setVisible(true);
                    }
                });
    }

    /**
     * Realiza transición a FechaVista y borra los datos del modelo.
     */
    public void cancelar() {
        currentState.dispose();
        modelo = new Reserva();
        //realiza transición
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        currentState = new FechaVista(modelo);
                        currentState.setVisible(true);
                    }
                });
    }

    public void close() {
        currentState.dispose();
    }
}