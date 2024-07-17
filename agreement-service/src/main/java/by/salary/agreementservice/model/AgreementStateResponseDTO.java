package by.salary.agreementservice.model;


import by.salary.agreementservice.entity.AgreementState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AgreementStateResponseDTO {
    private Long id;

    private String stateName;
    private String stateDescription;

    public AgreementStateResponseDTO(AgreementState agreementState) {
        this.id = agreementState.getId();
        this.stateName = agreementState.getStateName();
        this.stateDescription = agreementState.getStateDescription();
    }
}
