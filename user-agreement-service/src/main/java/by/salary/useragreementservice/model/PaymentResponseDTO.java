package by.salary.useragreementservice.model;

import by.salary.useragreementservice.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Long moderatorId;
    private String moderatorComment;
    private Double price;
    private Date date;

    public PaymentResponseDTO(Payment payment) {
        this.id = payment.getId();
        this.name = payment.getName();
        this.description = payment.getDescription();
        this.moderatorId = payment.getModerator().getId();
        this.moderatorComment = payment.getModeratorComment();
        this.price = payment.getPrice();
        this.date = payment.getDate();
    }
}
