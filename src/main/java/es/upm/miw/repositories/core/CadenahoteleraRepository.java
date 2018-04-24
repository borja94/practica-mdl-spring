package es.upm.miw.repositories.core;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.documents.core.Cadenahotelera;

public interface CadenahoteleraRepository extends MongoRepository<Cadenahotelera, String> {
    public Cadenahotelera findByNombre(String nombre);
}
