/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lettcriss
 */
public class DatosAleatorios {

    public DatosAleatorios() {
    }
    
    
    public void DatosAleatorios(){
    
    int filas = 20000;
    int columnas = 3;
    
    String [][] datos = new String [filas][columnas];
    
    for(int i = 0; i<filas;i++){
       for(int j =0; j < columnas; j++){
          datos[i][j]= generarDatosALeatorios();
       }
     }    
    
  }
    
    public static String generarDatosALeatorios(){
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i< 10;i++){
            int aleatorio = (int)(Math.random()*36);
            char c = (aleatorio <10)?(char)(aleatorio+'0'):(char)(aleatorio-10+'A');
            sb.append(c);  
        }
        return sb.toString();
    
    }
    
    
    
}
