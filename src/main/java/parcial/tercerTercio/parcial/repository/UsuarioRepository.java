package parcial.tercerTercio.parcial.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import parcial.tercerTercio.parcial.modules.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<User, String> {
    public Optional<User> findByCorreo(String correo);

}
