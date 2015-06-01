package fechasistema.vista;

import fechasistema.modelo.ModeloFechaSistema;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class ControladorFechaSistema {
    private VistaFechaSistema mivista;
    private ModeloFechaSistema mimodelo;
    
    // Constructor de la clase.
    public ControladorFechaSistema(VistaFechaSistema v, ModeloFechaSistema m){
        mivista = v;
        mimodelo = m;
    }
    
    /**
     * Método que implementa el boton "Cambiar" de la interfaz.
     */
    public void cambiar (){
        // Bandera para saber si hubo un error (si vale true hubo un error).
        boolean flag = false;
        
        //1.- Toma los datos de la vista.
        int minutos = mivista.getMinutos();
        int hora = mivista.getHora();
        int dia = mivista.getDia();
        int mes = mivista.getMes();
        int año = mivista.getAño();
        
        /* 2.- Comprobamos los datos
         */
        boolean[] errores = mimodelo.check(minutos, hora, dia, mes, año);
        
        for (int i = 0; i < mimodelo.getNumErrores(); i++){
            if (errores[i] == true){
                flag = true;
                break;
            }
        }
        
        /* 3.- Cambiamos los datos del modelo y actualizamos la Vista con los 
         * nuevos datos del modelo, solo en caso de que no hubiese errores, 
         * para que el usuario no tenga que introducir los datos de nuevo.
         */
        if (flag == false){
            mimodelo.setMinutos(minutos);
            mimodelo.setHora(hora);
            mimodelo.setDia(dia);
            mimodelo.setMes(mes);
            mimodelo.setAño(año);
            mivista.actualiza();
            mivista.correcto();
        } else { mivista.error(errores); }
    }
    
    /**
     * Método que implementa el botón de Salir del programa.
     */
    public void salir (){
        System.exit(0);
    }
}
