/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.vista;

import number.modelo.ModeloNumber;

/**
 *
 * @author daniel
 */
public class ControladorNumber {
    private VistaNumber mivista;
    private ModeloNumber mimodelo;
    
    public ControladorNumber (VistaNumber v, ModeloNumber m){
        mivista = v;
        mimodelo = m;
    }
    
    public void salir (){
        System.exit(0);
    }
    
    public void borrar (){
        sumar ();
    }
    
    public void sumar (){
        //1.- Obtenemos los datos dela vista
        mimodelo.setNumero1(mivista.getTxtNum1());
        mimodelo.setNumero2(mivista.getTxtNum2());
        //2.- Llamamos a la funcion de sumar del modelo
        mimodelo.suma();
        //3.- Actualizamos la vista
        mivista.actualiza();
    }
}
