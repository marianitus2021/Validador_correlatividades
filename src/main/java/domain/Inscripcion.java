package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private Alumno alumno;
    private List <Materia> materiasAInscribir;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasAInscribir = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMateriasAInscribir() {
        return materiasAInscribir;
    }
    public void agregarMateriasAInscribir(Materia ... materias) {
        Collections.addAll(materiasAInscribir, materias);
    }
    public List<Materia> obtenerTodasCorrelativas() {
        List<Materia> materiasCorrelativas = this.materiasAInscribir
                .stream()
                .flatMap(m -> m.getMateriasCorrelativas().stream())
                .collect(Collectors.toList());
        return materiasCorrelativas;

    }
    public boolean aprobada() {
        return alumno.cumpleCorrelativas(obtenerTodasCorrelativas());
    }
}
