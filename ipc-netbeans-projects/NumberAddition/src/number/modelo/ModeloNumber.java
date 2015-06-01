/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.modelo;

/**
 *
 * @author daniel
 */
public class ModeloNumber {
    private double numero1;
    private double numero2;
    private double resultado;
    
    public ModeloNumber (){
        numero1 = 0;
        numero2 = 0;
        resultado = 0;
    }
    
    public double getNumero1 (){
        return numero1;
    }
    
    public double getNumero2 (){
        return numero2;
    }
    
    public double getResultado (){
        return resultado;
    }
    
    public void setNumero1 (double numero1){
        this.numero1 = numero1;
    }
    
    public void setNumero2 (double numero2){
        this.numero2 = numero2;
    }
    
    // Funcion para sumar.
    public void suma (){
        resultado = numero1 + numero2;
    }
}
