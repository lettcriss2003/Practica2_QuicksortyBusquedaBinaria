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
public class Dato {
    private String carrera;
    private String materia;
    private Double promedio;

    public Dato() {
    }

    public Dato(String carrera, String materia, Double promedio) {
        this.carrera = carrera;
        this.materia = materia;
        this.promedio = promedio;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Dato{" + "carrera=" + carrera + ", materia=" + materia + ", promedio=" + promedio + '}';
    }
    
    

}