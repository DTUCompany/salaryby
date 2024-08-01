package by.salary.userservice.model;

import by.salary.userservice.entity.User;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Long id;

    private String login;

    private String password;

    private String email;

    private String name;

    private String surname;

    private String lastname;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.lastname = user.getLastname();
    }
}