/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Tabla;

import controlador.listas.DatosEjer1;
import controlador.listas.ListaEnlazada;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import modelo.Dato;

/**
 *
 * @author lettcriss
 */
public class ModeloTablaEjer1 extends AbstractTableModel {
    
    DefaultTableModel modelo = new DefaultTableModel();
    private ListaEnlazada<Dato> lista = new ListaEnlazada<>();

    public ListaEnlazada<Dato> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Dato> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Datos";
            
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dato d = null;
        controlador.listas.DatosEjer1 dato = new DatosEjer1(20000);
        dato.DatosAleatorios();
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (d != null) ? d.getCarrera(): "NO DEFINIDO";
            case 2:
                return (d != null) ? d.getMateria(): "NO DEFINIDO";
            case 3:
                return (d != null) ? d.getPromedio().toString(): "NO DEFINIDO";
            default:
                return null;
        }
    }


    

    
}
