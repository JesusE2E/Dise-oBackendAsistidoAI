package com.academia.batch.rest.repository;

import com.academia.batch.rest.model.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    List<EstudianteEntity> findByGrupo(String grupo);
}
