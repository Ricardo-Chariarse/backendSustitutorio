package sustitutorio.backend.dto;

import lombok.Data;

import java.util.List;
@Data
public class Examen {
    private List<Pregunta> preguntas;
}
