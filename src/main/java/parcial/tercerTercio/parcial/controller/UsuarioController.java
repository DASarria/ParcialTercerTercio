package parcial.tercerTercio.parcial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.tercerTercio.parcial.modules.User;
import parcial.tercerTercio.parcial.services.UsuarioService;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    UsuarioService uService;
    @Autowired
    public UsuarioController(UsuarioService uService) {
        this.uService = uService;
    }
    @PostMapping
    public void registrarUsuario(@RequestBody User usuario) {
        uService.registrarDato(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchUser(@PathVariable String id) {
        User searched = uService.searchUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(searched);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<User> searchUserByCorreo(@PathVariable String correo){
        User searched = uService.searchUserByCorreo(correo);
        return ResponseEntity.status(HttpStatus.OK).body(searched);
    }

    @GetMapping
    public List<User> consultarUsuarios() {
        return uService.consultarDatos();
    }
    @GetMapping("/specialities")
    public List<String> getSpecilities(){
        return uService.getSpecilities();
    }
}
