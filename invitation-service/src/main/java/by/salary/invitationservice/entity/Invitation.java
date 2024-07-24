package by.salary.invitationservice.entity;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("invitations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invitation {

    @Id
    private Long id;

    @Size(min = 8, max = 8)
    private String invitationCode;
}
