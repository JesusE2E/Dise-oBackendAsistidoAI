package com.academia.batch.proccessor;

import com.academia.batch.model.Estudiante;
import com.academia.batch.model.EstudianteReporte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReporteEstudianteProcessorTest {

    private final ReporteEstudianteProcessor processor = new ReporteEstudianteProcessor();

    @Test
    void asignaEstadoAprobadoCuandoPromedioEs70OMayor() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Ana");
        estudiante.setGrupo("A");
        estudiante.setPromedio(70.0);

        EstudianteReporte reporte = processor.process(estudiante);

        assertEquals(70.0, reporte.getPromedio());
        assertEquals("APROBADO", reporte.getEstado());
    }

    @Test
    void asignaEstadoReprobadoCuandoPromedioEsMenorA70() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Luis");
        estudiante.setGrupo("B");
        estudiante.setPromedio(69.9);

        EstudianteReporte reporte = processor.process(estudiante);

        assertEquals(69.9, reporte.getPromedio());
        assertEquals("REPROBADO", reporte.getEstado());
    }
}
