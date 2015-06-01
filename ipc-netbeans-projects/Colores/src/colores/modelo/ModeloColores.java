/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colores.modelo;

/**
 *
 * @author daniel
 */
public class ModeloColores {
    private int red;
    private int green;
    private int blue;
    private String hexadecimal;
    
    public ModeloColores (){
        red = 0;
        green = 0;
        blue = 0;
        hexadecimal = "";
    }
    
    public int getRed (){
        return red;
    }
    
    public int getGreen (){
        return green;
    }
    
    public int getBlue (){
        return blue;
    }
    
    public String getHexadecimal (){
        return hexadecimal;
    }
    
    public void setRed (int red){
        this.red = red;
    }
    
    public void setGreen (int green){
        this.green = green;
    }
        
    public void setBlue (int blue){
        this.blue = blue;
    }
    
    // Funcion para convertir de RGB a Hexadecimal.
    public void hexadecimal (){
        hexadecimal += Integer.toHexString(red);
        hexadecimal += Integer.toHexString(green);
        hexadecimal += Integer.toHexString(blue);
    }
}


