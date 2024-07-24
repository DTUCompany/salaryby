package by.salary.invitationservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvitationRequestDTO {

    private Long id;

    private String invitationCode;

}
