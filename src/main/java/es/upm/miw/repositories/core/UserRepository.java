package es.upm.miw.repositories.core;

import java.util.List;

import es.upm.miw.dtos.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import es.upm.miw.documents.core.User;
import es.upm.miw.dtos.UserMinimumDto;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmail(String email);

    public User findById(String id);

    @Query("{ 'token.value' : ?0 }")
    public User findByTokenValue(String tokenValue);

    @Query(value = "{'roles' : 'CLIENT'}", fields = "{ '_id' : 0 }")
    public List<UserDto> findClientAll();

    @Query(value = "{'roles' : 'HOTEL_RESP'}", fields = "{ '_id' : 0 }")
    public List<UserDto> findHotelRespAll();
}
