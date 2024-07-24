package by.salary.organisationservice.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationRequestDTO {
    private Long id;

    private Long directorId;

    private String name;
    private String address;
    private String phone;

    private Double baseReward;
    private Double balance;
}
