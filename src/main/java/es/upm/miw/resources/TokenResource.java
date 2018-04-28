package es.upm.miw.resources;

import es.upm.miw.dtos.UserDto;
import es.upm.miw.dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import es.upm.miw.controllers.TokenController;
import es.upm.miw.dtos.TokenOutputDto;

// @PreAuthorize("hasRole('CLIENT') or hasRole('HOTEL_RESP')")
@RestController
@RequestMapping(TokenResource.LOGIN)
public class TokenResource {

    public static final String LOGIN = "/login";

    @Autowired
    private TokenController tokenController;
    
//    @Autowired
//    private UserController userController;

    //@PreAuthorize("authenticated")
//    @PostMapping
//    public TokenOutputDto login(@AuthenticationPrincipal User activeUser) {
//        return tokenController.login(activeUser.getUsername());
//    }
    @PreAuthorize("authenticated")
    @PostMapping
    public TokenOutputDto login (@AuthenticationPrincipal User springUser) {
        return tokenController.login(springUser.getUsername());
    }

}
