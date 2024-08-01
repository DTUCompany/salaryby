package by.salary.organisationservice.model;

import by.salary.organisationservice.entity.Organisation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class OrganisationResponseDTO {

    private Long id;

    private Long directorId;

    private String name;
    private String address;
    private String phone;

    private Double baseReward;
    private Double balance;

    public OrganisationResponseDTO(Organisation organisation) {
        this.id = organisation.getId();
        this.directorId = organisation.getDirectorId();
        this.name = organisation.getName();
        this.address = organisation.getAddress();
        this.phone = organisation.getPhone();
        this.baseReward = organisation.getBaseReward();
        this.balance = organisation.getBalance();
    }
}

