/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.dao.DatoDao;
import controlador.listas.ListaEnlazada;
import java.util.*;
import modelo.Dato;

/**
 *
 * @author cobos
 */
public class main {
    public static void imprimir(Object [] a){
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].toString());
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        String [] matriz = new String[20000];
        for(int i =0; i<matriz.length;i++){
            int lenght = (int)(Math.random()*11)+10;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < lenght; j++){
                char c = (char)('a'+(int)(Math.random()*26));
                sb.append(c);
            }
            matriz[i] = sb.toString();  
        }
        
        System.out.println("|indice|Cadena ALeatoria|");
        System.out.println("|------|----------------|");
        for(int i = 0; i<matriz.length;i++){
            System.out.println("");
            System.out.println("|%6d|%18s|\n"+ i+  matriz[i]);
        }
        
	}
    }

