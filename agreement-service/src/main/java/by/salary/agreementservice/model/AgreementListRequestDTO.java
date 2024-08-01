package by.salary.agreementservice.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AgreementListRequestDTO {
    private Long id;
    private String agreementListName;
    private List<AgreementStateResponseDTO> agreementStates;
}
