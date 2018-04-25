package es.upm.miw.repositories.core;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.documents.core.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva,String>{
    
    public Reserva findByNombreHotel(String nombreHotel);
    
    public Reserva findById(String id);

    public List<Reserva> findByNombreUsuario(String nombreUsuario);

}
