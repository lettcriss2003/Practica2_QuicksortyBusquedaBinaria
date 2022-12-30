/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas;

import controlador.listas.excepciones.AtributoException;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import vistas.Utilidades.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import oracle.jrockit.jfr.events.Bits;

/**
 *
 * @author DEEPIN
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;
    public static Integer ASCENDENTE = 1;
    public static Integer DESCENDENTE = 2;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

//    private Integer tamanio() {
//        Integer tamanio = 0;
//        NodoLista<E> aux` = cabecera;
//        while (aux != null) {
//            tamanio++;
//            aux = aux.getSiguiente();
//        }
//        return tamanio;
//    }
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;

    }

    public void insertarCabecera(E dato) {

        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;

        }
    }

    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == (size - 1)) {
                insertar(dato);
            } else if (pos == 0) {
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void imprimir() {
        System.out.println("----------------------LISTA ENLAZADA----------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();

        }
        System.out.println("\n----------------------------------------------------------");
    }

    public E obtener(Integer pos) throws ListaNullException, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
        //return dato;

    }

    public void modificar(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (!estaVacia()) {
            insertar(dato);

        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }

        } else {
            throw new PosicionNoEncontradaException();
        }

    }

    public E eliminar(Integer pos) throws ListaNullException, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
    }

    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }
    
    public static void llenarTabla(){
    String[] matriz = new String[20000];
        for(int i =0; i<matriz.length;i++){
            int lenght = (int)(Math.random()*11)+10;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < lenght; j++){
                char c = (char)('a'+(int)(Math.random()*26));
                sb.append(c);
            }
            matriz[i] = sb.toString();  
        }
        for(int i = 0; i<matriz.length;i++){
            System.out.println("");
            System.out.println(" "+ i+  matriz[i]);
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

    public ListaEnlazada<E> burbuja(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = matriz.length; i < 1; i++) {
                for (int j = 0; j < i - 1; j++) {
                    if (isObject) {
                        intercambioObjeto(j, matriz, clazz, tipoOrdenacion, atributo);
                    } else {
                        intercambioDato(j, matriz, clazz, tipoOrdenacion);
                    }
                }
            }
        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;
    }
    

    private void intercambioDato(int j, E[] matriz, Class clazz, Integer tipoOrdenacion) {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        intercambio(j, matriz, auxJ, auxJ1, tipoOrdenacion);
    }

    private void intercambioObjeto(int j, E[] matriz, Class clazz, Integer tipoOrdenacion, String atributo) throws Exception {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(auxJ);
        Object b = field.get(auxJ1);
        intercambio(j, matriz, a, b, tipoOrdenacion);
    }

    private void intercambio(int j, E[] matriz, Object auxJ, Object auxJ1, Integer tipoOrdenacion) {
        Class clazz = auxJ.getClass();
        E a = matriz[j];
        E b = matriz[j + 1];
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
            if (Utilidades.isString(clazz)) {
                if (tipoOrdenacion == DESCENDENTE) {
                    if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                        matriz[j] = b;
                        matriz[j + 1] = a;
                    } else {
                        if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                            matriz[j] = b;
                            matriz[j + 1] = a;
                        }
                    }
                }
            }
        }
    }

    public ListaEnlazada<E> seleccionOrden(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            Integer i, j, k = 0;
            Integer n = matriz.length;
            E t = null;
            for (i = 0; i < n; i++) {
                k = i;
                t = matriz[i];
                for (j = i + 1; j < n; j++) {
                    E auxj1 = matriz[j];
                    Object[] aux = null;
                    if (isObject) {
                        aux = evaluarCambioObjeto(t, auxj1, j, tipoOrdenacion, clazz, atributo);
                    } else {
                        aux = evaluarCambioDato(t, auxj1, j, tipoOrdenacion);
                    }
                    if (aux[0] != null) {
                        t = (E) aux[0];
                        k = (Integer) aux[1];
                    }
                }
                matriz[k] = matriz[i];
                matriz[i] = t;
            }
            if (matriz != null) {
                toList(matriz);
            }
        }
        return this;
    }

    private Object[] evaluarCambio(Object auxJ, Object auxJ1, E dato, Integer j, Integer tipoOrdenacion) {
        Object[] aux = new Object[2];
        Class clazz = auxJ.getClass();
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }
            if (Utilidades.isString(clazz)) {
                if (tipoOrdenacion == DESCENDENTE) {
                    if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                        aux[0] = dato;
                        aux[1] = j;
                    } else {
                        if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                            aux[0] = dato;
                            aux[1] = j;
                        }
                    }
                }
            }
        }
        return aux;
    }

    private Object[] evaluarCambioDato(E auxJ, E auxJ1, Integer j, Integer tipoOrdenacion) {
        return evaluarCambio(auxJ, auxJ1, auxJ1, j, tipoOrdenacion);
    }

    private Object[] evaluarCambioObjeto(E auxJ, E auxJ1, Integer j, Integer tipoOrdenacion, Class clazz, String atributo) throws AtributoException, IllegalArgumentException, IllegalAccessException {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(auxJ);
        Object b = field.get(auxJ1);
        return evaluarCambio(a, b, auxJ1, j, tipoOrdenacion);
    }

    public ListaEnlazada<E> buscar(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = 0; i < matriz.length; i++) {
                if (isObject) {
                    Boolean band = evaluarBusquedaObjeto(matriz[i], dato, clazz, atributo);
                    if (band) {
                        resultado.insertar(matriz[i]);
                    }
                } else {
                    Boolean band = buscarPosicion(matriz[i], dato);
                    if (band) {
                        resultado.insertar(matriz[i]);
                    }
                }
            }
        }
        return resultado;
    }
    
    public static int busquedaBinaria(String[] matriz, String elemento) {
        int inferior = 0;
        int superior = matriz.length - 1;

        while (inferior <= superior) {
            int medio = inferior + (superior - inferior) / 2;
            if (matriz[medio].equals(elemento)) {
                return medio;
            }
            if (matriz[medio].compareTo(elemento) < 0) {
                inferior = medio + 1;

            } else {
                superior = medio - 1;
            }
        }
        return -1;

    }

    public static int busquedaLinealBinaria(String[] matriz, String elemento) {
        int indice = 0;
        while (indice < matriz.length) {
            if (matriz[indice].equals(elemento)) {
                return indice;
            }
            if (matriz[indice].compareTo(elemento) < 0) {
                indice++;
            } else {
                break;
            }
        }

        int inferior = indice;
        int superior = matriz.length - 1;

        while (inferior <= superior) {
            int medio = inferior + (superior - inferior) / 2;
            if (matriz[medio].equals(elemento)) {
                return medio;
            }
            if (matriz[medio].compareTo(elemento) < 0) {
                inferior = medio + 1;
            } else {
                superior = medio - 1;
            }
        }
        return -1;
    }
    
      public ListaEnlazada<E> busquedaBinaria(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = 0; i < matriz.length; i++) {
                if (isObject) {
                    Boolean band = evaluarBusquedaObjeto(matriz[i], dato, clazz, atributo);
                    if (band) {
                        resultado.insertar(matriz[i]);
                    }
                } else {
                    Boolean band = buscarPosicion(matriz[i], dato);
                    if (band) {
                        resultado.insertar(matriz[i]);
                    }
                }
            }
        }
        return resultado;
    }

    private boolean buscarPosicion(Object datoMatriz, Object busqueda) {
        if (Utilidades.isNumber(busqueda.getClass())) {
            if (((Number) datoMatriz).doubleValue() == ((Number) busqueda).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datoMatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private Boolean evaluarBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(aux);
        return buscarPosicion(a, dato);
    }
//Getter and Setter

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
//        this.size = tamanio();
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
