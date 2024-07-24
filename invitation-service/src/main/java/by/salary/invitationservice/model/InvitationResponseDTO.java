package by.salary.invitationservice.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationResponseDTO {
    private Long id;
    private String invitationCode;
}
