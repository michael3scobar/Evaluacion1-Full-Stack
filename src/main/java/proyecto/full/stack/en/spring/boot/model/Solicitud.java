package proyecto.full.stack.en.spring.boot.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
    @NotNull (message = "El ID es obligatorio")
    private Integer id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String paciente;

    @NotBlank(message = "La especialidad es requerida")
    private String especialidad;

    @NotBlank(message = "El estado Pendiente/ Atendido es obligatorio")
    private String estado;

    @Min(value = 1, message = "La prioridad minima debe ser 1")
    @Max(value = 5, message = "La prioridad maxima debe ser 5")
    private Integer prioridad;
}