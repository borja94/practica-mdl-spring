package es.upm.miw.resources;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.controllers.UserController;
import es.upm.miw.documents.core.Role;
import es.upm.miw.dtos.UserDto;
import es.upm.miw.dtos.UserMinimumDto;
import es.upm.miw.resources.exceptions.ForbiddenException;
import es.upm.miw.resources.exceptions.UserFieldAlreadyExistException;
import es.upm.miw.resources.exceptions.UserIdNotFoundException;

@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {

    public static final String USERS = "/users";

    public static final String USER_ID = "/{id}";

    public static final String SEARCH = "/search";

    @Autowired
    private UserController userController;

    @PostMapping
    public void createUser(@Valid @RequestBody UserDto userDto) throws UserFieldAlreadyExistException {
        if (userDto.getPassword() == null) {
            userDto.setPassword("admin");
        }
        if (this.userController.existsEmail(userDto.getEmail())) {
            throw new UserFieldAlreadyExistException("Existing email");
        }

        this.userController.createUser(userDto);
    }

    @PutMapping(value = USER_ID)
    public void putCustomer(@PathVariable String id, @Valid @RequestBody UserDto userDto)
            throws ForbiddenException, UserIdNotFoundException, UserFieldAlreadyExistException {
        if (!this.userController.existsEmail(userDto.getEmail())) {
            throw new UserIdNotFoundException("Not existing email");
        }
        if (!this.userController.putUser(userDto)) {
            throw new ForbiddenException();
        }
    }

    @DeleteMapping(value = USER_ID)
    public void deleteCustomer(@PathVariable String id) throws ForbiddenException {
        if (!this.userController.deleteUser(id)){
            throw new ForbiddenException();
        }
    }

    @RequestMapping(value = USER_ID, method = RequestMethod.GET)
    public UserDto readCustomer(@PathVariable String id) throws UserIdNotFoundException {
        return this.userController.readUser(id).orElseThrow(() -> new UserIdNotFoundException(id));
    }

    @GetMapping
    public List<UserDto> readCustomerAll() {
        return this.userController.readClientAll();
    }

}
