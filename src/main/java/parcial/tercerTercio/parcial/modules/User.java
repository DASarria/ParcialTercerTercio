package parcial.tercerTercio.parcial.modules;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Document(collection = "usuarios")
public class User {
    @Id
    String id;
    String nombre;
    Speciality especialidad;
    String cedula;
    String correo;


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public User(){
        this.id = UUID.randomUUID().toString();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public User(User usuario){
        this.id = UUID.randomUUID().toString();
        this.nombre = usuario.nombre;
        this.especialidad = usuario.especialidad;
        this.cedula = usuario.cedula;
        this.correo=usuario.correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Speciality getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Speciality especialidad) {
        this.especialidad = especialidad;
    }
}
