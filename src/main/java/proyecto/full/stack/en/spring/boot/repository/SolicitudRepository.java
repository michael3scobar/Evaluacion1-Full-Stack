package proyecto.full.stack.en.spring.boot.repository;

import org.springframework.stereotype.Repository;
import proyecto.full.stack.en.spring.boot.model.Solicitud;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SolicitudRepository {
    private List<Solicitud> solicitudes = new ArrayList<>();

    public List<Solicitud> findAll() {
        return solicitudes;
    }

    public void save(Solicitud solicitud) {
        solicitudes.add(solicitud);
    }

    public void deleteById(Integer id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}