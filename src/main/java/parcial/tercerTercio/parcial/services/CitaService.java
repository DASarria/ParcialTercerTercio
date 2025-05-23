package parcial.tercerTercio.parcial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import parcial.tercerTercio.parcial.modules.Cita;
import parcial.tercerTercio.parcial.modules.User;
import parcial.tercerTercio.parcial.repository.CitaRepository;
import parcial.tercerTercio.parcial.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    CitaRepository cRespository;
    UsuarioService uService;

    @Autowired
    public CitaService(CitaRepository cRepository, UsuarioService uService) {
        this.cRespository = cRepository;
        this.uService = uService;
    }
    public void registrarDato(Cita cita) {
        User usuario = uService.searchUserByCorreo(cita.getCorreoUser());
//        User doctor = uService.searchUser(cita.getDoctor());
        if(usuario!= null){
            cRespository.save(cita);
        }
    }
    public List<Cita> consultarDatos() {
        return cRespository.findAll();
    }

    public Cita searchCita(String id) {
        Optional<Cita> optionalCita = cRespository.findById(id);
        if(optionalCita.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalCita.get();
    }
}
