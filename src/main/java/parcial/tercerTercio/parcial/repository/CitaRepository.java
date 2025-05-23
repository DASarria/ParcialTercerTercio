package parcial.tercerTercio.parcial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import parcial.tercerTercio.parcial.modules.Cita;

@Repository
public interface CitaRepository extends MongoRepository<Cita, String> {

}
