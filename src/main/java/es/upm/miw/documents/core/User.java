package es.upm.miw.documents.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String password;

    private Role role;

    private Token token;

    public User() {

    }

    public User(String email, String password, Role role) {
        this();
        this.email = email;
        this.setPassword(password);
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return email.equals(((User) obj).email);
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + ", roles=" + role.roleName()
                + ", token=" + token + "]";
    }

}
