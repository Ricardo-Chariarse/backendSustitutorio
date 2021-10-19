package sustitutorio.backend.dto;

import lombok.Data;

import java.util.List;
@Data
public class Pregunta {
    private Integer codPregunta;
    private String enunciado;
    private List <Alternativas> alternativas;
}
