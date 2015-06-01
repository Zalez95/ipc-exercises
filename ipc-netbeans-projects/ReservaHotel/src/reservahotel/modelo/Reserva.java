package reservahotel.modelo;

import static reservahotel.ConstantesError.*;

/**
 * @author Daniel González Alonso
 * @author Daniel Paredes Santamaría
 */
public class Reserva {
    private Fecha fechaEntrada;
    private Fecha fechaSalida;
    private int numeroPersonas;
    private int pension;
    private int habitacion;
    /* Si el valor de disponibilidad es 0, hay disponiblidad en las fechas, 
     * si es uno no hay disponiblidad (error).
     */
    private int disponibilidad;
    private Usuario usuario;
    
    /**
     * Constructor por defecto.
     */
    public Reserva() {
        fechaEntrada = new Fecha();
        fechaSalida = new Fecha(fechaEntrada.getDia()+1,fechaEntrada.getMes(),fechaEntrada.getAño());
        numeroPersonas = 0;
        pension = 0;
        habitacion = 0;
        usuario = new Usuario();
    }
    
    // Getters
    /** 
     * @return la Fecha de Entrada.
     */
    public Fecha getFechaEntrada() {
        return fechaEntrada;
    }
    
    /** 
     * @return la Fecha de Salida
     */
    public Fecha getFechaSalida() {
        return fechaSalida;
    }
    
    /** 
     * @return el Numero de Personas.
     */
    public int getNumeroPersonas(){
        return numeroPersonas;
    }
    
    /** 
     * @return el valor de Pension.
     */
    public int getPension(){
        return pension;
    }
    
    /** 
     * @return el valor de Habitacion.
     */
    public int getHabitacion(){
        return habitacion;
    }
    
    /** 
     * @return el valor de disponibilidad.
     */
    public int getDisponibilidad(){
        return disponibilidad;
    }
    
    /** 
     * @return el valor de Usuario.
     */
    public Usuario getUsuario(){
        return usuario;
    }
    
    // Setters
    /**
     * Método para cambiar el valor de FechaEntrada.
     * @param dia con el nuevo valor del Día.
     * @param mes con el nuevo valor del Mes.
     * @param año con el nuevo valor del Año.
     */
    public void setFechaEntrada(int dia, int mes, int año) {
        this.fechaEntrada = new Fecha(dia, mes, año);
    }
    
    /**
     * Método para cambiar el valor de FechaSalida.
     * @param dia con el nuevo valor del Día.
     * @param mes con el nuevo valor del Mes.
     * @param año con el nuevo valor del Año.
     */
    public void setFechaSalida(int dia, int mes, int año) {
        this.fechaSalida = new Fecha(dia, mes, año);
    }
    
    /**
     * Método para cambiar el valor de NumeroPersonas
     * @param numeroPersonas con el nuevo valor del numero de personas.
     */
    public void setNumeroPersonas(int numeroPersonas){
        this.numeroPersonas = numeroPersonas;
    }
    
    /**
     * Método para cambiar el valor de Pension
     * @param pension con el nuevo valor de Pension.
     */
    public void setPension(int pension){
        this.pension = pension;
    }
    
    /**
     * Método para cambiar el valor Habitacion
     * @param habitacion con el nuevo valor de Habitacion.
     */
    public void setHabitacion(int habitacion){
        this.habitacion = habitacion;
    }
    
    /**
     * Método para cambiar el valor de la disponibilidad
     * @param disponiblidad con el nuevo valor de disponiblidad.
     */
    public void setDisponibilidad(int disponiblidad){
        this.disponibilidad = disponiblidad;
    }
    
    /**
     * Método para cambiar el usuario por otro.
     * @param usuario, el nuevo usuario por el que cambiaremos.
     */
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    /**
     * Método que comprueba si las fechas de entrada y salida son correctas y
     * posibles de la ventana FechaVista.
     * @return un array de booleanos para saber en que campo o campos
     * se produjo el error, true indica que en el campo hubo un error y false 
     * que es correcto.
     */
    public boolean[] compruebaFechaVista(int diaEntrada, int mesEntrada, 
                int añoEntrada, int diaSalida, int mesSalida, 
                int añoSalida, int numeroPersonas){        
        boolean[] errores, erroresEntrada, erroresSalida;
        int i, j;
        Fecha tmpFechaEntrada, tmpFechaSalida, tmpFechaActual;
        
        erroresEntrada = Fecha.check(diaEntrada, mesEntrada, añoEntrada);
        erroresSalida = Fecha.check(diaSalida, mesSalida, añoSalida);
        errores = new boolean[NUMERRORESFECHA*2 + 4];
        
        /* Los 3 primeros campos de errores contendrán los fallos
         * de la fecha de entrada.
         */
        for(i = 0; i < NUMERRORESFECHA; i++){
            errores[i] = erroresEntrada[i];
        }
        
        /* Los 3 siguientes campos de errores contendrán los fallos 
         * de la fecha de salida.
         */
        for(j = 0; j < NUMERRORESFECHA; j++){
            errores[i+j] = erroresSalida[j];
        }
        
        tmpFechaActual = new Fecha();
        tmpFechaEntrada = new Fecha(diaEntrada, mesEntrada, añoEntrada);
        tmpFechaSalida = new Fecha(diaSalida, mesSalida, añoSalida);
        
        /* El siguiente campo de errores indicara si la fecha de entrada 
         * es inferior a la fecha actual.
         */
        errores[FECHAINFACTUAL] = Fecha.mayor(tmpFechaActual, tmpFechaEntrada);
        
        /* El siguiente campo de errores indicara si la fecha de salida 
         * es inferior o igual a la de entrada.
         */
        if ((Fecha.mayor(tmpFechaEntrada, tmpFechaSalida)) |
                (Fecha.igual(tmpFechaEntrada, tmpFechaSalida))){
            errores[SALIDAINFENTRADA] = true; 
        } else { errores[SALIDAINFENTRADA] = false; }
        
        /* El siguiente campo de errores indicará si se ha seleccionado algun
         * dato o no en los Radio Button.
         */
        if (numeroPersonas == ERRORGEN) { errores[NUMPERSONAS] = true; }
        else { errores[NUMPERSONAS] = false; }
        
        /* El ultimo campo de errores indicará la falta de disponibilidad en 
         * la fecha indicada.
         */
        if (disponibilidad == 0) {
            errores[DISPONIBILIDAD] = false;
        } else { errores[DISPONIBILIDAD] = true; }
        
        return errores;
    }

    /**
     * Método que comprueba si los datos de la habitación y pensión de 
     * la ventana HabitaciónVista son correctos.
     * @return un array de booleanos para saber en que campo o campos
     * se produjo el error, true indica que en el campo hubo un error y false 
     * que es correcto.
     */
    public boolean[] compruebaHabitacionVista(int habitacion, int pension) {
        boolean[] errores = new boolean[2];
        
        if (habitacion == ERRORGEN) { errores[HABITACION] = true; }
        else { errores[HABITACION] = false; }
                
        // Si el indice de pension es 0, el usuario no ha seleccionado nada.
        if (pension == 0) { errores[PENSION] = true; }
        else { errores[PENSION] = false; }
        
        return errores;
    }
    
    /**
     * Método para comprobar la longitud de un numero.
     * @return el numero de digitos del numero.
     */
    public int longitud(long numero){
        int contadorLongitud = 0;
        while (numero != 0){
            numero = numero/10;
            contadorLongitud++;
        }
        return contadorLongitud;
    }
    
    /**
     * Método que comprueba si los datos personales y bancarios de la ventana 
     * DatosVista son correctos.
     * @return un array de booleanos para saber en que campo o campos
     * se produjo el error, true indica que en el campo hubo un error y false 
     * que es correcto.
     */
    public boolean[] compruebaDatosVista(String nombre, String apellidos, 
            String pais, String email, int telefono, String propietarioTarjeta,
            long numeroTarjeta, int CVC) {
        boolean[] error = new boolean[8];
        
        /* Si el tamaño de los Strings es igual a 0, el Usuario no ha rellenado
         * ese campo.
         */
        if (nombre.length() == 0){
            error[NOMBRE] = true;
        } else { error[NOMBRE] = false; }
        
        if (apellidos.length() == 0){
            error[APELLIDOS] = true;
        } else { error[APELLIDOS] = false; }
        
        if (pais.length() == 0){
            error[PAIS] = true;
        } else { error[PAIS] = false; }
        
        if (email.length() == 0){
            error[EMAIL] = true;
        } else { error[EMAIL] = false; }
        
        // 9 es el numero de digitos admitidos para el teléfono.
        if (longitud(telefono) != 9){
            error[TELEFONO] = true;
        } else { error[TELEFONO] = false; }
        
        if (propietarioTarjeta.length() == 0){
            error[PROPTARJETA] = true;
        } else { error[PROPTARJETA] = false; }
      
        // 16 es el numero de digitos admitidos para el numero de tarjeta.
        if (longitud(numeroTarjeta) != 16){
            error[NUMTARJETA] = true;
        } else { error[NUMTARJETA] = false; }
        
        // 3 es el numero de digitos admitidos para el CVC.
        if (longitud(CVC) != 3){
            error[CTECVC] = true;
        } else { error[CTECVC] = false; }
        
        return error;
    }
}