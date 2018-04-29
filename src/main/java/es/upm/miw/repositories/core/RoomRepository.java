package es.upm.miw.repositories.core;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.documents.core.Room;

public interface RoomRepository extends MongoRepository<Room,String>{

}
