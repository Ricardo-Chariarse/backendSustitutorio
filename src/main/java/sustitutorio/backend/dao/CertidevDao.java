package sustitutorio.backend.dao;

import sustitutorio.backend.dto.Examen;
import sustitutorio.backend.dto.Pregunta;


public interface CertidevDao {
    Examen BuscarPreguntas();
    Examen BuscarRespuestas();
}
