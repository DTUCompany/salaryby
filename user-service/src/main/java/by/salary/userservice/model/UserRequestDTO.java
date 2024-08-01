package by.salary.userservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDTO {

    private Long id;

    @Schema(description = "Login",
            example = "dtalalaev",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 20)
    private String login;

    @Schema(description = "Password",
            example = "12345",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 50)
    private String password;

    @Schema(description = "Email",
            example = "example@innowise.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @Email
    private String email;

    @Schema(description = "Name",
            example = "Dzianis",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 2, max = 50)
    private String name;

    @Schema(description = "Surname",
            example = "Talalayeu",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 2, max = 50)
    private String surname;

    @Schema(description = "Lastname",
            example = "Uladzimiravich",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Size(min = 2, max = 50)
    private String lastname;
}
