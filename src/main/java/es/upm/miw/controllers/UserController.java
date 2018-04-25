package es.upm.miw.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Role;
import es.upm.miw.documents.core.User;
import es.upm.miw.dtos.UserDto;
import es.upm.miw.dtos.UserMinimumDto;
import es.upm.miw.repositories.core.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {
        User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getRole());
        this.userRepository.save(user);
    }

    public boolean existsEmail(String email) {
        return this.userRepository.findByEmail(email) != null;
    }

    public boolean isClient(String email) {
        return isRole(email, Role.CLIENT);
    }

    public boolean isHotelResponsible(String email) {
        return isRole(email, Role.HOTEL_RESP);
    }

    public boolean isRole(String email, Role role) {
        User user = this.userRepository.findByEmail(email);
        return ( user.getRole() == role );
    }

    public boolean deleteUser(String id) {
        User userBd = this.userRepository.findById(id);
        if (userBd == null) {
            return true;
        } else {
            this.userRepository.delete(userBd);
            return true;
        }
    }

    public Optional<UserDto> readUser(String id) {
        User userBd = this.userRepository.findById(id);
        if (userBd == null) {
            return Optional.empty();
        } else {
            return Optional.of(new UserDto(userBd));
        }
    }

    public List<UserDto> readClientAll() {
        return this.userRepository.findClientAll();
    }

    public List<UserDto> readHotelResponsibleAll() { return this.userRepository.findHotelRespAll(); }

    public boolean putUser( UserDto userDto ) {
        User user = this.userRepository.findByEmail(userDto.getEmail());
        assert user != null;
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        this.userRepository.save(user);

        return true;
    }

}
