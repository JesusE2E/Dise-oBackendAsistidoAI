package com.academia.batch.rest.service;

import com.academia.batch.rest.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Long contarAprobados() {
        return estudianteRepository.findAll().stream()
                .filter(estudiante -> Double.parseDouble(estudiante.getPromedio()) >= 70)
                .count();
    }
}
