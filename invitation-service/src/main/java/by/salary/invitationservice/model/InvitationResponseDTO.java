package by.salary.invitationservice.model;

import by.salary.invitationservice.entity.Invitation;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationResponseDTO {
    private Long id;
    private String invitationCode;

    public InvitationResponseDTO(Invitation invitation) {
        this.id = invitation.getId();
        this.invitationCode = invitation.getInvitationCode();
    }
}
