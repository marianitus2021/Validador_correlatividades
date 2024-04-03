package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    private List <Materia> materiasCursadas;

    public Alumno(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasCursadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public List<Materia> getMateriasCursadas() {
        return materiasCursadas;
    }

    public void agregarMateriasCursadas(Materia ... materias) {
        Collections.addAll(this.materiasCursadas, materias);
    }

    public boolean cumpleCorrelativas(List<Materia> materias) {
        return this.materiasCursadas.containsAll(materias);
    }
}

