package parcial.tercerTercio.parcial.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import parcial.tercerTercio.parcial.modules.Speciality;
import parcial.tercerTercio.parcial.modules.User;
import parcial.tercerTercio.parcial.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.aot.hint.TypeReference.listOf;


@Service
public class UsuarioService {
    UsuarioRepository uRespository;

    @Autowired
    public UsuarioService(UsuarioRepository uRepository) {
        this.uRespository = uRepository;
    }
    public void registrarDato(User usuario) {
        uRespository.save(usuario);
    }
    public List<User> consultarDatos() {
        return uRespository.findAll();
    }

    public User searchUser(String id) {
        Optional<User> optionalUser = uRespository.findById(id);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalUser.get();
    }

    public User searchUserByCorreo(String correo){
        Optional<User> optionalUser = uRespository.findByCorreo(correo);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalUser.get();
    }
    public List<String> getSpecilities(){
        ArrayList lista = new ArrayList();

        lista.add("MEDICINA_GENERAL");
        lista.add("PSICOLOGIA");
        lista.add("ORTOPEDIA");
        lista.add("ODONTOLOGIA");
        lista.add("USUARIO_NORMAL");
        return lista;

    }




}
