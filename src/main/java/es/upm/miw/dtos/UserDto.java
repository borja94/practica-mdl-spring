package es.upm.miw.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import es.upm.miw.documents.core.Role;
import es.upm.miw.documents.core.User;

import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public class UserDto {

    @NotNull
    private String email;

    private String password;

    private Role role;

    public UserDto() {
        // Empty for framework
    }

    public UserDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDto(User user) {
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email.toLowerCase();
        } else {
            this.email = email;
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "[" + "UserDto [password=" + password + ", email=" + email + ", role=" + role.roleName() + "]";
    }

}
