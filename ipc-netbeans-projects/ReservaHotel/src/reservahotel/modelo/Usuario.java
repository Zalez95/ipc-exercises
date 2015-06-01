package reservahotel.modelo;

/**
 * @author Daniel Gonzalez Alonso
 * @author Daniel Paredes Santamaria
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String pais;
    private String email;
    private int telefono;
    private String propietario;
    private long numTarjeta;
    private Fecha fechaExp;
    private int CVC;
    
    /**
     * Constructor por defecto
     */
    public Usuario(){ 
        fechaExp = new Fecha();
    }
    
    //Getters
    /** 
     * @return el valor de Nombre.
     */
    public String getNombre() {
        return nombre;
    }
    
    /** 
     * @return el valor de los Apellidos.
     */
    public String getApellidos() {
        return apellidos;
    }
    
    /** 
     * @return el valor de País.
     */
    public String getPais() {
        return pais;
    }
    
    /** 
     * @return el valor de Email.
     */
    public String getEmail() {
        return email;
    }
    
    /** 
     * @return el valor de Telefono.
     */
    public int getTelefono() {
        return telefono;
    }
    
    /** 
     * @return el valor del nombre del propietario.
     */
    public String getPropietario() {
        return propietario;
    }
    
    /** 
     * @return el valor del numero de tarjeta.
     */
    public long getNumTarjeta() {
        return numTarjeta;
    }
    
    /** 
     * @return el valor del Mes.
     */
   public int getMes() {
       return fechaExp.getMes();
   }
   
   /** 
     * @return el valor del Año.
     */
   public int getAño() {
       return fechaExp.getAño();
   }
   
   /** 
     * @return el valor de CVC.
     */
   public int getCVC() {
       return CVC;
   }
          
    //setters
    /**
     * Método para cambiar el valor de Nombre.
     * @param nombre el nuevo valor de nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método para cambiar el campo Apellidos.
     * @param apellidos el nuevo valor de apellidos.  
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Método para cambiar el valor de Pais.
     * @param pais el nuevo valor de país.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    /**
     * Método para cambiar el valor de Email,
     * @param email el nuevo valor de email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Método para cambiar el valor de Telefono.
     * @param telefono el nuevo valor de Telefono.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Método para cambiar el valor de Propietario,
     * @param propietario el nuevo valor de propietario.
     */
    public void setPropietario(String propietario){
        this.propietario = propietario;
    }
    
    /**
     * Método para cambiar el valor de NumTarjeta,
     * @param numTarjeta el nuevo valor de numTarjeta.
     */
    public void setNumTarjeta(long numTarjeta){
        this.numTarjeta = numTarjeta;
    }
    
    /**
     * Método para cambiar el valor de Mes,
     * @param mes el nuevo valor de mes.
     */
    public void setMes(int mes){
        fechaExp.setMes(mes);        
    }
    
    /**
     * Método para cambiar el valor de Año,
     * @param año el nuevo valor de año.
     */
    public void setAño(int año){
        fechaExp.setAño(año);  
    }
    
    /**
     * Método para cambiar el valor de CVC,
     * @param CVC el nuevo valor de CVC.
     */
    public void setCVC(int CVC){
        this.CVC = CVC;
    }
}
