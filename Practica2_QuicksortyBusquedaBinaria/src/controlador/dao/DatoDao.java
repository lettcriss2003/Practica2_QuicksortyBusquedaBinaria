/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.xml.bind.annotation.XmlRootElement;
import modelo.Dato;


/**
 *
 * @author lettcriss
 */

@XmlRootElement
public class DatoDao extends AdaptadorDao<Dato>{
    

    private Dato dato;

    public DatoDao() {
        super(Dato.class);
    }

    public Dato getDato() {
        if (dato == null) {
            dato = new Dato();
        }
        return dato;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }
    
    

    public boolean guardar() throws Exception {
        guardar(this.dato);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.dato, pos);
        return true;
    }
    
    
}
