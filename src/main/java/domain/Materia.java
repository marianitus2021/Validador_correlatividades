package domain;

import java.util.*;

public class Materia {
    private String nombre;
    private Integer anio;
    private List <Materia> materiasCorrelativas;

    public Materia(String nombre, Integer anio) {
        this.nombre = nombre;
        this.anio = anio;
        this.materiasCorrelativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public List<Materia> getMateriasCorrelativas() {
        return materiasCorrelativas;
    }

    public void agregarMateriasCorrelativas(Materia ... materias) {
        Collections.addAll(this.materiasCorrelativas, materias);
    }

}
