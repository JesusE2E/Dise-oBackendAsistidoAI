package com.academia.batch.proccessor;

import com.academia.batch.model.Estudiante;
import com.academia.batch.model.EstudianteReporte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ReporteEstudianteProcessor implements ItemProcessor<Estudiante, EstudianteReporte> {

    @Override
    public EstudianteReporte process(Estudiante estudiante) throws Exception {
        EstudianteReporte reporte = new EstudianteReporte();
        reporte.setNombre(estudiante.getNombre());
        reporte.setGrupo(estudiante.getGrupo());
        reporte.setPromedio(estudiante.getPromedio());
        reporte.setEstado(estudiante.getPromedio() >= 70 ? "APROBADO" : "REPROBADO");

        log.info("Step 2 - Reporte: {}", reporte);
        return reporte;
    }
}
