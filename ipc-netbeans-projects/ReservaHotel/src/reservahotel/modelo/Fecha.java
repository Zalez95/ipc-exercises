package reservahotel.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static reservahotel.ConstantesError.*;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class Fecha {
    private Calendar fecha;
    
    /**
     * Constructor por defecto.
     */
    public Fecha (){
        fecha = (GregorianCalendar) GregorianCalendar.getInstance();
    }
    
    /**
     * Constructor con parámetro:
     * @param dia, el valor del dia con el que crearemos la instancia de Fecha.
     * @param mes, el valor del mes con el que crearemos la instancia de Fecha.
     * @param año, el valor del año con el que crearemos la instancia de Fecha.
     */
    public Fecha (int dia, int mes, int año){
        fecha = new GregorianCalendar(año, mes, dia);
    }
    
    // Getters
    /** 
     * @return la fecha.
     */
    public Calendar getCalendar (){
        return fecha;
    }
    
    /**
     * @return el valor del Día.
     */
    public int getDia (){
        return fecha.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    /**
     * @return el valor del Mes.
     */
    public int getMes (){
        // El mes va de 0 a 11.
        return fecha.get(GregorianCalendar.MONTH);
    }
    
    /**
     * @return el valor del Año.
     */
    public int getAño (){
        return fecha.get(GregorianCalendar.YEAR);
    }
    
    // Setters
    /**
     * Método para cambiar la fecha por otra.
     * @param fecha, la nueva fecha por la que cambiaremos.
     */
    public void setCalendar (Calendar fecha){
        this.fecha = fecha;
    }
    
    /**
     * Método para cambiar el valor del Día.
     * @param dia con el nuevo valor del Día.
     */
    public void setDia (int dia){
        fecha.set(GregorianCalendar.DAY_OF_MONTH, dia);
    }
    
    /**
     * Método para cambiar el valor del Mes.
     * @param mes con el nuevo valor del Mes.
     */
    public void setMes (int mes){
        // El mes va de 0 a 11.
        fecha.set(GregorianCalendar.MONTH, mes);
    }
    
    /**
     * Método para cambiar el valor del Año.
     * @param año con el nuevo valor del Año.
     */
    public void setAño (int año){
        fecha.set(GregorianCalendar.YEAR, año);
    }
    
    /** 
     * Comprueba si cada campo de la fecha es correcto.
     * @return un array de booleanos para saber en que campo o campos
     * se produjo el error, true indica que en el campo hubo un error y false 
     * que es correcto.
     */
    public static boolean[] check (int dia, int mes, int año){
        boolean [] errores = new boolean [NUMERRORESFECHA];
        
        /** 
         * Creamos una instancia de GregorianCalendar (el constructor es: 
         * int year, int month, int dayOfMonth, int hourOfDay, int minute)
         * sobre la que haremos comprobaciones sobre la fecha.
         */
        Calendar calendarioTemporal = new GregorianCalendar(2015, 3, 14, 9, 26);
        
        // Error en Año.
        if ((año < calendarioTemporal.getActualMinimum(GregorianCalendar.YEAR))
            || (año > calendarioTemporal.getActualMaximum(GregorianCalendar.YEAR))){
            errores[ERRORAÑO] = true;
        } else { calendarioTemporal.set(GregorianCalendar.YEAR, año); }
        
        // Error en Mes.
        if ((mes < calendarioTemporal.getActualMinimum(GregorianCalendar.MONTH))
            || (mes > calendarioTemporal.getActualMaximum(GregorianCalendar.MONTH))){
            errores[ERRORMES] = true;
        } else { calendarioTemporal.set(GregorianCalendar.MONTH, mes); }
        
        // Error en Día.
        if ((dia < calendarioTemporal.getActualMinimum(GregorianCalendar.DAY_OF_MONTH))
            || (dia > calendarioTemporal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH))){
            errores[ERRORDIA] = true;
        } else { calendarioTemporal.set(GregorianCalendar.DAY_OF_MONTH, dia); }
        
        return errores;
    }
    
    /**
     * Método que devuelve si la primera fecha es superior a la segunda.
     * @return true si la primera fecha es superior.
     */
    public static boolean mayor(Fecha fecha1, Fecha fecha2){
        boolean flag;
        
        if (fecha1.getAño() > fecha2.getAño()) { flag = true; }
        else {
            if (fecha1.getAño() < fecha2.getAño()) { flag = false; }
            else {
                // caso año1 == año2
                if (fecha1.getMes() > fecha2.getMes()) { flag = true; }
                else {
                    if (fecha1.getMes() < fecha2.getMes()) { flag = false; }
                    else {
                        //caso mes1 == mes2
                        if (fecha1.getDia() > fecha2.getDia()) { flag = true; }
                        else { flag = false; }
                    }
                }
            }
        }
        return flag;
    }
    
    /**
     * Método que devuelve si la primera fecha es igual a la segunda.
     * @return true si son iguales.
     */
    public static boolean igual(Fecha fecha1, Fecha fecha2){
        if ((fecha1.getDia() == fecha2.getDia()) &
                (fecha1.getMes() == fecha2.getMes()) &
                (fecha1.getAño() == fecha2.getAño())){
            return true;
        } else { return false; }
    }
}