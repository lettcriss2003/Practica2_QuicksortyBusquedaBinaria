/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Utilidades;

import java.lang.reflect.Field;



/**
 *
 * @author DEEPIN
 */
public class Utilidades {
    
    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    
    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }
    
    public static Object transformarDato(Field atributo, String dato) {
        Object transformar = null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (atributo.getType().getSimpleName().equals("Intger")) {
                transformar = Integer.parseInt(dato);
            }
        } else if (atributo.getType().isEnum()) {
            Enum enumeracion = Enum.valueOf((Class) atributo.getType(), dato.toString());
            transformar = enumeracion;

        } else if (atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
            transformar = Boolean.parseBoolean(dato);
        } else {
            transformar = dato;
        }
        return transformar;

    }
    
    public static Boolean isNumber(Class clase){
       return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
      public static Boolean isString(Class clase){
       return clase.getSimpleName().equalsIgnoreCase("String");
    }     
      public static Boolean isCharacter(Class clase){
       return clase.getSimpleName().equalsIgnoreCase("Character");
    }
       public static Boolean isBoolean(Class clase){
       return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
        // si no son datos primitivos 
      public static Boolean isPrimitive(Class clase){
       return clase.isPrimitive();
    }
     public static Boolean isDate(Class clase){
       return clase.getSimpleName().equalsIgnoreCase("Date");
    }
     
     public static Boolean isObject(Class clase){
       return (!isPrimitive(clase)&&!isBoolean(clase)&& !isCharacter(clase)&&!isNumber(clase)&&!isString(clase));
    }
    
    

   


}
