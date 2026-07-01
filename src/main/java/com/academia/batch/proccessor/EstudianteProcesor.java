
package com.academia.batch.proccessor;
import com.academia.batch.model.Estudiante;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
// Processor de Spring Batch que implementa ItemProcessor<Estudiante, Estudiante>.
// En el metodo process: calcula el promedio como (nota1 + nota2 + nota3) / 3.0,
// asigna el promedio al estudiante con setPromedio, registra un log con SLF4J usando 
// la anotacion @Slf4j de Lombok con el mensaje
// "Step 1 - Procesando: {estudiante}" y devuelve el estudiante.

@Slf4j
public class EstudianteProcesor implements ItemProcessor<Estudiante, Estudiante> {

    @Override
    public Estudiante process(Estudiante estudiante) throws Exception {
        double promedio = (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3()) / 3.0;
        estudiante.setPromedio(promedio);
        log.info("Step 1 - Procesando: {}", estudiante);
        return estudiante;
    }


}

