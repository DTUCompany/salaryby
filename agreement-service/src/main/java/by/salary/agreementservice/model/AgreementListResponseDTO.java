package by.salary.agreementservice.model;

import by.salary.agreementservice.entity.AgreementList;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AgreementListResponseDTO {

    private Long id;

    private String agreementListName;

    private List<AgreementStateResponseDTO> agreementStates;

    public AgreementListResponseDTO(AgreementList agreementList) {
        this.id = agreementList.getId();
        this.agreementListName = agreementList.getAgreementListName();
        this.agreementStates = agreementList.getAgreementStates() == null? null: agreementList.getAgreementStates().stream()
                .map(AgreementStateResponseDTO::new)
                .toList();
    }
}
