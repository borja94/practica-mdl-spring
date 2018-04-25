package es.upm.miw.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserMinimumDto {

    @NotNull
    private String email;

    public UserMinimumDto() {
    }

    public UserMinimumDto(String email, String username) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserMinimumDto [email=" + email + "]";
    }
}
