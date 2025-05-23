package parcial.tercerTercio.parcial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import parcial.tercerTercio.parcial.modules.Cita;
import parcial.tercerTercio.parcial.repository.CitaRepository;
import parcial.tercerTercio.parcial.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    CitaRepository uRespository;
    UsuarioService uService;

    @Autowired
    public CitaService(CitaRepository cRepository, UsuarioService uService) {
        this.uRespository = cRepository;
    }
    public void registrarDato(Cita cita) {

    }
    public List<Cita> consultarDatos() {
        return uRespository.findAll();
    }

    public Cita searchCita(String id) {
        Optional<Cita> optionalCita = uRespository.findById(id);
        if(optionalCita.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalCita.get();
    }
}
