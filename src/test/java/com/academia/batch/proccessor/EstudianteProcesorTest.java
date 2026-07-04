package com.academia.batch.proccessor;

import com.academia.batch.model.Estudiante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EstudianteProcesorTest {

    private final EstudianteProcesor processor = new EstudianteProcesor();

    @Test
    void calculaPromedioCorrectamente() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setNota1(80);
        estudiante.setNota2(90);
        estudiante.setNota3(70);

        Estudiante procesado = processor.process(estudiante);

        assertEquals(80.0, procesado.getPromedio());
    }

    @Test
    void calculaPromedioEnCasosLimite() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setNota1(70);
        estudiante.setNota2(70);
        estudiante.setNota3(70);

        Estudiante procesado = processor.process(estudiante);

        assertEquals(70.0, procesado.getPromedio());
    }
}
