package by.salary.agreementservice.model;


import by.salary.agreementservice.entity.Agreement;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class AgreementResponseDTO {

    private Long id;

    private String agreementName;

    private List<AgreementListResponseDTO> agreementLists;

    public AgreementResponseDTO(Agreement agreement) {
        this.id = agreement.getId();
        this.agreementName = agreement.getAgreementName();
        this.agreementLists = agreement.getAgreementLists().stream()
                .map(AgreementListResponseDTO::new)
                .toList();
    }

}
