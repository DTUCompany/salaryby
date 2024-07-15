package by.salary.invitationservice.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("invitations")
@AllArgsConstructor
@NoArgsConstructor
public class Invitation {

    @Id
    private Long id;

    String invitationCode;
}
