package domain;

import org.junit.Assert;
import org.junit.Test;

public class CorrelativaTest {

    @Test
    public void alumnoCumpleCorrelativas() {

        Materia matematicaDiscreta = new Materia("Matematica Discreta", 1);
        Materia analisisUno = new Materia("Analisis Matematico 1", 1);
        Materia analisisDos = new Materia("Analisis Matematico 2", 2);
        Materia algebra= new Materia("Algebra",1);
        Materia algoritmos = new Materia("Algoritmos y estructura de datos", 1);
        Materia sintaxis = new Materia("Sintaxis y semantica de lenguajes", 2);
        Materia paradigmas = new Materia("Paradigmas de programacion", 2);
        Materia disenio = new Materia("Diseño de Sistemas", 3);

        sintaxis.agregarMateriasCorrelativas(algoritmos);
        paradigmas.agregarMateriasCorrelativas(algoritmos, sintaxis);
        disenio.agregarMateriasCorrelativas(algoritmos, sintaxis, paradigmas);
        analisisDos.agregarMateriasCorrelativas(algebra, matematicaDiscreta, analisisUno);

        Alumno juan = new Alumno("Juan", "Perez", "8912221");
        Alumno pedro = new Alumno("Pedro", "Sanchez", "3209278");
        Alumno nico = new Alumno("Nico", "Mendoza", "8399273");

        juan.agregarMateriasCursadas(algoritmos,sintaxis);
        pedro.agregarMateriasCursadas(algoritmos, sintaxis);
        nico.agregarMateriasCursadas(algebra, analisisUno, sintaxis);

        Inscripcion inscripcionJuan = new Inscripcion(juan);
        Inscripcion inscripcionPedro = new Inscripcion(pedro);
        Inscripcion inscripcionNico = new Inscripcion(nico);

        inscripcionJuan.agregarMateriasAInscribir(paradigmas);

        inscripcionPedro.agregarMateriasAInscribir(paradigmas, disenio);

        inscripcionNico.agregarMateriasAInscribir(analisisDos);

        Assert.assertEquals(true, inscripcionJuan.aprobada());          //SE APRUEBA PORQUE TIENE CURSADAS ALGORITMOS Y SINTAXIS PARA CURSAR PARADIGMAS

        Assert.assertEquals(false, inscripcionPedro.aprobada());        //NO SE APRUEBA PORQUE LE FALTA TENER CURSADA PARADIGMAS PARA CURSAR DISEÑO

        Assert.assertEquals(false, inscripcionNico.aprobada());          //NO SE APRUEBA PORQUE LE FALTA TENER CURSADA MATEMATICA DISCRETA PARA CURSAR ANALISIS MATEMATICO 2

    }
}
