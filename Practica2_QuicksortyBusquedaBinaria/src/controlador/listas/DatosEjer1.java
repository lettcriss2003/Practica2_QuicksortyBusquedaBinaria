/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas;

import static controlador.listas.ListaEnlazada.generarDatosALeatorios;
import javax.swing.table.DefaultTableModel;
import controlador.listas.ListaEnlazada;

/**
 *
 * @author lettcriss
 */
public class DatosEjer1 {
    
    private String [] matriz;
    private int size;
    
    public DatosEjer1(int capacidad){
      matriz = new String[capacidad];
      size = 0;
    }
    
    public void anadir(String elemento){
      matriz[size++]= elemento;
    }
    
    public void quickSort(){
        quickSort(0, size-1);
    
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
    
    
    
    private void quickSort(int bajo, int alto){
        
         if(bajo < alto){
            int pivotI = particionAscendente(bajo, alto);
         } else{
             int pivotI = particionDescendente(bajo, alto);
            quickSort(bajo, pivotI -1);
            quickSort(pivotI +1, alto);
            
         }
    }
    
    private int particionAscendente(int bajo, int alto){
       String pivot= matriz[alto];
       int i = bajo -1;
       for(int j = bajo; j< alto; j++){
          if(matriz[j].compareTo(pivot)<0){
            i++;
            intercambio(i, j);
          }
       }
       intercambio(i+1, alto);
       return i+1;
    }
    
    private int particionDescendente(int bajo, int alto){
       String pivot= matriz[alto];
       int i = bajo -1;
       for(int j = bajo; j< alto; j++){
          if(matriz[j].compareTo(pivot)>0){
            i++;
            intercambio(i, j);
          }
       }
       intercambio(i+1, alto);
       return i+1;
    }
    
    
    private void intercambio(int i, int j){
       String event = matriz[i];
       matriz[i] = matriz[j];
       matriz[j] = event;
    }
    
    
    
    public void shellsortAscendente(){
        int diferencia = size/2;
        while(diferencia > 0){
          for(int i = diferencia; i < size; i++){
             String temp = matriz[i];
             int j; 
             for(j = i; j >= diferencia && matriz[j-diferencia].compareTo(temp)> 0; j-= diferencia){
                  matriz[j] = matriz[j-diferencia];
             }
             matriz[j]=temp;
          }
          diferencia/= 2;
        }
    }
    
    public void shellsortDescendente(){
        int diferencia = size/2;
        while(diferencia > 0){
          for(int i = diferencia; i < size; i++){
             String temp = matriz[i];
             int j; 
             for(j = i; j >= diferencia && matriz[j-diferencia].compareTo(temp) < 0; j-= diferencia){
                  matriz[j] = matriz[j-diferencia];
             }
             matriz[j]=temp;
          }
          diferencia/= 2;
        }
    }
    
    
}
