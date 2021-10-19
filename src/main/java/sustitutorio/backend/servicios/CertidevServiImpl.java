package sustitutorio.backend.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustitutorio.backend.dao.CertidevDao;
import sustitutorio.backend.dto.Examen;
import sustitutorio.backend.dto.Pregunta;

@Transactional
@Service
public class CertidevServiImpl implements CertidevServi{
    @Autowired
    private CertidevDao dao;
    public Examen BuscarPreguntas() {
        return dao.BuscarPreguntas();
    }
    public Examen BuscarRespuestas(){
        return dao.BuscarRespuestas();
    }
}
