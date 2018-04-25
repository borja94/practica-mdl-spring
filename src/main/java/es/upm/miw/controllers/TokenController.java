package es.upm.miw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Token;
import es.upm.miw.documents.core.User;
import es.upm.miw.dtos.TokenOutputDto;
import es.upm.miw.repositories.core.UserRepository;

@Controller
public class TokenController {

    @Autowired
    private UserRepository userRepository;

    public TokenOutputDto login(String email) {
        User user = userRepository.findByEmail(email);
        assert user != null;
        user.setToken(new Token());
        userRepository.save(user);
        return new TokenOutputDto(user);
    }

}
