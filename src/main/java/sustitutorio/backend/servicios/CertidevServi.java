package sustitutorio.backend.servicios;

import sustitutorio.backend.dto.Examen;
import sustitutorio.backend.dto.Pregunta;


public interface CertidevServi {
    Examen BuscarPreguntas();
    Examen BuscarRespuestas();
}
