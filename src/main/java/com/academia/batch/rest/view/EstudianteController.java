package com.academia.batch.rest.view;

import com.academia.batch.rest.model.EstudianteEntity;
import com.academia.batch.rest.repository.EstudianteRepository;
import com.academia.batch.rest.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/api/estudiantes")
@ResponseBody
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteRepository estudianteRepository, EstudianteService estudianteService) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteEntity>> listarTodos() {
        return ResponseEntity.ok(estudianteRepository.findAll());
    }

   /**
     * Endpoint para contar el número de estudiantes aprobados.
     *
     * @return ResponseEntity con un mapa que contiene el total de estudiantes aprobados.
     */

    @GetMapping("/aprobados/total")
    public ResponseEntity<Map<String, Long>> contarAprobados() {
        Map<String, Long> respuesta = new HashMap<>();
        respuesta.put("totalAprobados", estudianteService.contarAprobados());
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<EstudianteEntity> crear(@RequestBody EstudianteEntity estudiante) {
        EstudianteEntity creado = estudianteRepository.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteEntity> reemplazar(@PathVariable Long id, @RequestBody EstudianteEntity estudiante) {
        Optional<EstudianteEntity> existente = estudianteRepository.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        EstudianteEntity actualizado = existente.get();
        actualizado.setNombre(estudiante.getNombre());
        actualizado.setGrupo(estudiante.getGrupo());
        actualizado.setNota1(estudiante.getNota1());
        actualizado.setNota2(estudiante.getNota2());
        actualizado.setNota3(estudiante.getNota3());
        actualizado.setPromedio(estudiante.getPromedio());
        return ResponseEntity.ok(estudianteRepository.save(actualizado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstudianteEntity> actualizarGrupo(@PathVariable Long id, @RequestBody Map<String, Object> cambios) {
        Optional<EstudianteEntity> existente = estudianteRepository.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        EstudianteEntity actualizado = existente.get();
        if (cambios.containsKey("grupo")) {
            actualizado.setGrupo(String.valueOf(cambios.get("grupo")));
        }
        return ResponseEntity.ok(estudianteRepository.save(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!estudianteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estudianteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
