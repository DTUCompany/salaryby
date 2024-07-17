package by.salary.agreementservice.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AgreementStateRequestDTO {

    private Long id;
    private String stateName;
    private String stateDescription;
}
