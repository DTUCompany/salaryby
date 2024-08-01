package by.salary.useragreementservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class PaymentRequestDTO {
    private Long id;
    private String name;
    private String description;
    private Long moderatorId;
    private String moderatorComment;
    private Double price;

    private Long customerId;
}
