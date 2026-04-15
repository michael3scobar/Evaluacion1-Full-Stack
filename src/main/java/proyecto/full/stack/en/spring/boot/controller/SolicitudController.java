package proyecto.full.stack.en.spring.boot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.full.stack.en.spring.boot.model.Solicitud;
import proyecto.full.stack.en.spring.boot.service.SolicitudService;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService service;

    @GetMapping
    public List<Solicitud> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<String> crear(@Valid @RequestBody Solicitud s) {
        service.registrar(s);
        return new ResponseEntity<>("Se registro la solicitud correctamente", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@PathVariable Integer id, @RequestBody Solicitud s) {
        service.actualizar(id, s);
        return ResponseEntity.ok("Solicitud actualizada con eexito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/urgentes")
    public List<Solicitud> verUrgentes() {
        return service.obtenerUrgentes();
    }

    @GetMapping("/especialidad/{esp}")
    public List<Solicitud> getPorEspecialidad(@PathVariable String esp) {
        return service.filtrarPorEspecialidad(esp);
}
}