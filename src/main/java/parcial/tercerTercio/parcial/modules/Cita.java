package parcial.tercerTercio.parcial.modules;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Document(collection = "citas")
public class Cita {
    @Id
    String id;
    String fecha;
    Speciality especialidadSeleccionada;
    User doctor;
    String correoUser;

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public Cita() {
        this.id = UUID.randomUUID().toString();
    }

    public Cita(Cita cita) {
        this.id = UUID.randomUUID().toString();
        this.especialidadSeleccionada = cita.especialidadSeleccionada;
        this.fecha = cita.fecha;
        this.doctor = cita.doctor;
        this.correoUser=cita.correoUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Speciality getEspecialidadSeleccionada() {
        return especialidadSeleccionada;
    }

    public void setEspecialidadSeleccionada(Speciality especialidadSeleccionada) {
        this.especialidadSeleccionada = especialidadSeleccionada;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
}


