package es.upm.miw.repositories.core;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.documents.core.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
