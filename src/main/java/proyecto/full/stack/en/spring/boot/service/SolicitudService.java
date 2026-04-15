package proyecto.full.stack.en.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.full.stack.en.spring.boot.model.Solicitud;
import proyecto.full.stack.en.spring.boot.repository.SolicitudRepository;
import java.util.List;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository repo;

    public List<Solicitud> listarTodas() {
        return repo.findAll();
    }

    public void registrar(Solicitud s) {
        repo.save(s);
    }

    public boolean eliminar(Integer id) {
        if (repo.findAll().stream().anyMatch(s -> s.getId().equals(id))) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public void actualizar(Integer id, Solicitud datosNuevos) {
        repo.findAll().stream()
                .filter(s -> s.getId().equals(id))
                .forEach(s -> {
                    s.setPaciente(datosNuevos.getPaciente());
                    s.setEspecialidad(datosNuevos.getEspecialidad());
                    s.setEstado(datosNuevos.getEstado());
                    s.setPrioridad(datosNuevos.getPrioridad());
                });
    }
//metodo para q solo muestra las urgentes
    public List<Solicitud> obtenerUrgentes() {
        return repo.findAll().stream()
                .filter(s -> s.getPrioridad() >= 4)
                .toList();
    }

// meodo para filtrar por especialidad
public List<Solicitud> filtrarPorEspecialidad(String esp) {
    return repo.findAll().stream()
            .filter(s -> s.getEspecialidad().equalsIgnoreCase(esp))
            .toList();
}    
}