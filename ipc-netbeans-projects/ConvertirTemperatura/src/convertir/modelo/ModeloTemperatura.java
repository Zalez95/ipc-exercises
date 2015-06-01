/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertir.modelo;

/**
 *
 * @author daniel
 */
public class ModeloTemperatura {
    private double gradC;
    private double gradF;
    
    public ModeloTemperatura (){
        gradC = 0;
        gradF = -32.0;
    }
    
    public double getCentigrados (){
        return gradC;
    }
    
    public double getFahrenheit (){
        return gradF;
    }
    
    public void setCentigrados (double gradC){
        this.gradC = gradC;
    }
    
    public void setFahrenheit (double gradF){
        this.gradF = gradF;
    }
    
    // Funcion para convertir de grados centigrados a fahrenheit.
    public void gradosCentigradosAFahrenheit (){
        gradF = 1.8*gradC - 32.0;
    }
}
