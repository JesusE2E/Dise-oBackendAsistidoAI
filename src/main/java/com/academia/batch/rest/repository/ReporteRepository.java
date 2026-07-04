package com.academia.batch.rest.repository;

import com.academia.batch.model.EstudianteReporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository extends JpaRepository<EstudianteReporte, Long> {
    List<EstudianteReporte> findByEstado(String estado);
}
