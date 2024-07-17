package by.salary.agreementservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class AgreementListRequestDTO {
    private Long id;
    private String agreementListName;
    private List<AgreementStateResponseDTO> agreementStates;
}
