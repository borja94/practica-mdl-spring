package es.upm.miw.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserLoginDto {

    @NotNull
    private String email;

    @NotNull
    private String password;

    public UserLoginDto() {
    }

    public UserLoginDto(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDto [email=" + email + "]";
    }
}
