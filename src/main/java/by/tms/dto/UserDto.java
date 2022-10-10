package by.tms.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank(message = "Field cant be empty")
    private String name;
    @NotBlank(message = "Field cant be empty")
    private String password;

    public UserDto() {

    }

    public UserDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
