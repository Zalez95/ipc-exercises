package fechasistema.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class ModeloFechaSistema {
    private Calendar fechayhoraActual;
    
    // Constantes para las errores
    private final int NUMERRORES = 5;
    private final int ERRORAÑO = 0;
    private final int ERRORMES = 1;
    private final int ERRORDIA = 2;
    private final int ERRORHORA = 3;
    private final int ERRORMINUTOS = 4;
    
    // Constructor por defecto
    public ModeloFechaSistema (){
        fechayhoraActual = (GregorianCalendar) GregorianCalendar.getInstance();
    }
    
    // Getters
    /** 
     * @return el valor de los Minutos en el modelo.
     */
    public int getMinutos (){
        return fechayhoraActual.get(GregorianCalendar.MINUTE);
    }
    
    /** 
     * @return el valor de la Hora en el modelo.
     */
    public int getHora (){
        return fechayhoraActual.get(GregorianCalendar.HOUR_OF_DAY);
    }
    
    /**
     * @return el valor del Día en el modelo.
     */
    public int getDia (){
        return fechayhoraActual.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    // El mes va de 0 a 11.
    /**
     * @return el valor del Mes en el modelo.
     */
    public int getMes (){
        return fechayhoraActual.get(GregorianCalendar.MONTH);
    }
    
    /**
     * @return el valor del Año en el modelo.
     */
    public int getAño (){
        return fechayhoraActual.get(GregorianCalendar.YEAR);
    }

    /** 
     * @return el Número de Errores posibles.
     */
    public int getNumErrores (){
        return NUMERRORES;
    }
    
    // Setters
    /**
     * Método para cambiar el valor de los Minutos en el modelo.
     * @param minutos con el nuevo valor de los Minutos.
     */
    public void setMinutos (int minutos){
        fechayhoraActual.set(GregorianCalendar.MINUTE, minutos);
    }
    
    /**
     * Método para cambiar el valor de la Hora en el modelo.
     * @param hora con el nuevo valor de la Hora.
     */
    public void setHora (int hora){
        fechayhoraActual.set(GregorianCalendar.HOUR_OF_DAY, hora);
    }
    
    /**
     * Método para cambiar el valor del Día en el modelo.
     * @param dia con el nuevo valor del Día.
     */
    public void setDia (int dia){
        fechayhoraActual.set(GregorianCalendar.DAY_OF_MONTH, dia);
    }
    
    /**
     * Método para cambiar el valor del Mes en el modelo.
     * @param mes con el nuevo valor del Mes.
     */
    public void setMes (int mes){
        fechayhoraActual.set(GregorianCalendar.MONTH, mes);
    }
    
    /**
     * Método para cambiar el valor del Año en el modelo.
     * @param año con el nuevo valor del Año
     */
    public void setAño (int año){
        fechayhoraActual.set(GregorianCalendar.YEAR, año);
    }
    
    /** 
     * @return un array de booleanos para saber en que campo o campos
     * se produjo el error, true indica que en el campo hubo un error y false 
     * que es correcto.
     */
    public boolean[] check (int minutos, int hora, int dia, int mes, int año){
        boolean [] errores = new boolean [NUMERRORES];
        
        /** 
         * Creamos una instancia de GregorianCalendar (el constructor es: 
         * int year, int month, int dayOfMonth, int hourOfDay, int minute)
         * sobre la que haremos comprobaciones sobre la fecha.
         */
        Calendar calendarioTemporal = new GregorianCalendar(2015, 3, 14, 9, 26);
        
        // Error en Año
        if ((año < calendarioTemporal.getActualMinimum(GregorianCalendar.YEAR))
            || (año > calendarioTemporal.getActualMaximum(GregorianCalendar.YEAR))){
            errores[ERRORAÑO] = true;
        } else { calendarioTemporal.set(GregorianCalendar.YEAR, año); }
        
        // Error en Mes
        if ((mes < calendarioTemporal.getActualMinimum(GregorianCalendar.MONTH))
            || (mes > calendarioTemporal.getActualMaximum(GregorianCalendar.MONTH))){
            errores[ERRORMES] = true;
        } else { calendarioTemporal.set(GregorianCalendar.MONTH, mes); }
        
        // Error en Día
        if ((dia < calendarioTemporal.getActualMinimum(GregorianCalendar.DAY_OF_MONTH))
            || (dia > calendarioTemporal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH))){
            errores[ERRORDIA] = true;
        } else { calendarioTemporal.set(GregorianCalendar.DAY_OF_MONTH, dia); }
        
        // Error en Hora
        if ((hora < calendarioTemporal.getActualMinimum(GregorianCalendar.HOUR_OF_DAY))
            || (hora > calendarioTemporal.getActualMaximum(GregorianCalendar.HOUR_OF_DAY))){
            errores[ERRORHORA] = true;
        } else { calendarioTemporal.set(GregorianCalendar.HOUR_OF_DAY, hora); }
        
        // Error en Minutos
        if ((minutos < calendarioTemporal.getActualMinimum(GregorianCalendar.MINUTE))
            || (minutos > calendarioTemporal.getActualMaximum(GregorianCalendar.MINUTE))){
            errores[ERRORMINUTOS] = true;
        } else { calendarioTemporal.set(GregorianCalendar.MINUTE, minutos); }
        
        return errores;
    }
}