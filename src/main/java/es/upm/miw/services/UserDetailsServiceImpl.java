package es.upm.miw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.miw.documents.core.Role;
import es.upm.miw.documents.core.User;
import es.upm.miw.repositories.core.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String P_TOKEN = "";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String mobileOrTokenValue) {
        User user = userRepository.findByTokenValue(mobileOrTokenValue);
        if (user != null) {
            return this.userBuilder(user.getEmail(), new BCryptPasswordEncoder().encode(P_TOKEN), user.getRole());
        } else {
            user = userRepository.findByEmail(mobileOrTokenValue);
            if (user != null) {
                return this.userBuilder(user.getEmail(), user.getPassword(), user.getRole());
            } else {
                throw new UsernameNotFoundException("Username-token not found. " + mobileOrTokenValue);
            }
        }
    }

    private org.springframework.security.core.userdetails.User userBuilder(String email, String password, Role role) {
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        boolean enabled = true;
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role.roleName()));

        return new org.springframework.security.core.userdetails.User(email, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
    }
}