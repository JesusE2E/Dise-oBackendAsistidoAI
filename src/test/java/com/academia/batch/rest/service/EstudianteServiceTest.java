package com.academia.batch.rest.service;

import com.academia.batch.rest.model.EstudianteEntity;
import com.academia.batch.rest.repository.EstudianteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    @Test
    void contarAprobadosDevuelveDosCuandoHayDosAprobadosYUnReprobado() {
        EstudianteEntity aprobado1 = new EstudianteEntity();
        aprobado1.setPromedio("80.0");

        EstudianteEntity aprobado2 = new EstudianteEntity();
        aprobado2.setPromedio("70.0");

        EstudianteEntity reprobado = new EstudianteEntity();
        reprobado.setPromedio("69.9");

        when(estudianteRepository.findAll()).thenReturn(List.of(aprobado1, aprobado2, reprobado));

        Long resultado = estudianteService.contarAprobados();

        assertEquals(2L, resultado);
    }
}
