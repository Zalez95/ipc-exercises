/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertir.vista;

import convertir.modelo.ModeloTemperatura;

/**
 *
 * @author daniel
 */
public class ControladorTemperatura {
    private VistaTemperatura mivista;    
    private ModeloTemperatura mimodelo;
    
    public  ControladorTemperatura (VistaTemperatura v, ModeloTemperatura m){
       mivista = v;
       mimodelo = m;
    }
    
    public void salir (){
        System.exit(0);
    }
    
    public void convierte (){
        //1.- Toma los datos de la vista
        double gC = mivista.getTxtGrados();
        //2.- Modelo: setGradosCentigrados()
        mimodelo.setCentigrados(gC);
        //3.- Modelo: convierte los grados centigrados a Fahrenheit
        mimodelo.gradosCentigradosAFahrenheit();
        //4.- Vista se actualice con los nuevos datos del modelo
        mivista.actualiza();
    }
}