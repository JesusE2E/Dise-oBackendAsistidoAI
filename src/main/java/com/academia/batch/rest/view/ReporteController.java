package com.academia.batch.rest.view;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academia.batch.rest.repository.ReporteRepository;

import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import com.academia.batch.model.EstudianteReporte;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteRepository reporteRepository;
 
    public ReporteController(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
     
    }

  
    public ResponseEntity<List<EstudianteReporte>> listAllReports() {
        return ResponseEntity.ok(reporteRepository.findAll());
    }
 @GetMapping("/estado/{estado}")
    public ResponseEntity<List<EstudianteReporte>> listReportsByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reporteRepository.findByEstado(estado));
    }

}

