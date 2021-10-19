package sustitutorio.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sustitutorio.backend.dto.Examen;

import sustitutorio.backend.dto.Pregunta;
import sustitutorio.backend.servicios.CertidevServi;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class CertidevControlador {
    @Autowired
    private CertidevServi servicio;

    @RequestMapping(
            value="/busqueda-pregunta",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody Examen BuscarPreguntas(){
        return servicio.BuscarPreguntas();
    }
    @RequestMapping(
            value="/busqueda-respuesta",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody Examen BuscarRespuesta(){
        return servicio.BuscarRespuestas();
    }

}
