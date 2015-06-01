/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colores.vista;

import colores.modelo.ModeloColores;

/**
 *
 * @author daniel
 */
public class ControladorColores {
    private VistaColores mivista;
    private ModeloColores mimodelo;
    
    public ControladorColores (VistaColores v, ModeloColores m){
        mivista = v;
        mimodelo = m;
    }
    
    public void salir (){
        System.exit(0);
    }
    
    public void convertir (){
        //1.- Modelo: seters con los datos de la vista
        mimodelo.setRed(mivista.getTextR());
        mimodelo.setGreen(mivista.getTextG());
        mimodelo.setBlue(mivista.getTextB());
        //2.- Cambiamos el valor a hexadecimal
        mimodelo.hexadecimal();
        //3.- Vista se actualiza con los nuevos datos del modelo
        mivista.actualiza();
    }
}
