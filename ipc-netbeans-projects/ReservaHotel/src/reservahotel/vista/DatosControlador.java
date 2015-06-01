package reservahotel.vista;

import reservahotel.Main;
import reservahotel.modelo.Reserva;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class DatosControlador {
    private DatosVista mivista;
    private Reserva mimodelo;
    
    // Constructor de la clase.
    public DatosControlador(DatosVista v, Reserva m){
        mivista = v;
        mimodelo = m;
    }
    
    /**
     * Método que comprueba si todos los campos de datos estan rellenos y si los 
     * tipos y cantidad de caracteres son correctos.
     * En caso afirmativo confirma la reserva.
     */
    public void confirmar() {  
        String nombre, apellidos, pais, email, propietarioTarjeta;
        int i, telefono, mesCaducidad, añoCaducidad, CVC;
        long numeroTarjeta;
        boolean[] errores; 
        boolean flag = false;
        
        //1.- Toma los datos de la vista.
        nombre = mivista.getNombre();
        apellidos = mivista.getApellidos();
        pais = mivista.getPais();
        email = mivista.getEmail();
        telefono = mivista.getTelefono();
        propietarioTarjeta = mivista.getNombrePropietario();
        numeroTarjeta = mivista.getNumeroTarjeta();
        mesCaducidad = mivista.getMesCaducidad();
        añoCaducidad = mivista.getAñoCaducidad();
        CVC = mivista.getCVC();
        
        //2.- Comprobamos los errores
        errores = mimodelo.compruebaDatosVista(nombre, apellidos, pais, email, 
                       telefono, propietarioTarjeta, numeroTarjeta, CVC); 
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
            mimodelo.getUsuario().setNombre(nombre);
            mimodelo.getUsuario().setApellidos(apellidos);
            mimodelo.getUsuario().setPais(pais);
            mimodelo.getUsuario().setEmail(email);
            mimodelo.getUsuario().setTelefono(telefono);
            mimodelo.getUsuario().setPropietario(propietarioTarjeta);
            mimodelo.getUsuario().setNumTarjeta(numeroTarjeta);
            mimodelo.getUsuario().setMes(mesCaducidad);
            mimodelo.getUsuario().setAño(añoCaducidad);
            mimodelo.getUsuario().setCVC(CVC);
            
            /* Como es una simulacion no almacenaremos el modelo en una base de
             * datos, pero aún así mostramos un mensaje para simular que hemos
             * almacenado la reserva.
             */
            mivista.actualiza();
            mivista.mensajeCorrecto();
        } else { mivista.error(errores); }
    }
    
    /**
     * Método que implementa el botón de atrás.
     */
    public void atras() {
        Main.getMaquinaEstados().atras2();
    }
    
    /**
     * Método que implementa el botón de cancelar.
     */
    public void cancelar() {
        Main.getMaquinaEstados().cancelar();
    }
}