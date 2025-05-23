package parcial.tercerTercio.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.tercerTercio.parcial.modules.Cita;
import parcial.tercerTercio.parcial.services.CitaService;

import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {
    CitaService cService;
    @Autowired
    public CitaController(CitaService cService) {
        this.cService = cService;
    }
    @PostMapping
    public void registrarcita(@RequestBody Cita cita) {
        cService.registrarDato(cita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> searchCita(@PathVariable String id) {
        Cita searched = cService.searchCita(id);
        return ResponseEntity.status(HttpStatus.OK).body(searched);
    }

    @GetMapping
    public List<Cita> consultarcitas() {
        return cService.consultarDatos();
    }
}
