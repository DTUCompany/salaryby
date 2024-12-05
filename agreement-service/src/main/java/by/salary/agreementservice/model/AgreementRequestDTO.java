package by.salary.agreementservice.model;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AgreementRequestDTO {
    private Long id;
    private String agreementName;
}
