package by.salary.organisationservice.entity;


import by.salary.organisationservice.model.OrganisationRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "organisations")
@Getter
@Setter
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long directorId;

    private String name;
    private String address;
    private String phone;

    private Double baseReward;
    private Double balance;

    public Organisation(OrganisationRequestDTO organisationRequestBody) {
        this.directorId = organisationRequestBody.getDirectorId();
        this.name = organisationRequestBody.getName();
        this.address = organisationRequestBody.getAddress();
        this.phone = organisationRequestBody.getPhone();
        this.baseReward = organisationRequestBody.getBaseReward();
        this.balance = organisationRequestBody.getBalance() == null ? 0.0 : organisationRequestBody.getBalance();
    }

    public void update(OrganisationRequestDTO organisationRequestBody) {
        this.directorId = organisationRequestBody.getDirectorId() == null? this.directorId : organisationRequestBody.getDirectorId();
        this.name = organisationRequestBody.getName() == null? this.name : organisationRequestBody.getName();
        this.address = organisationRequestBody.getAddress() == null? this.address : organisationRequestBody.getAddress();
        this.phone = organisationRequestBody.getPhone() == null? this.phone : organisationRequestBody.getPhone();
        this.baseReward = organisationRequestBody.getBaseReward() == null? this.baseReward : organisationRequestBody.getBaseReward();
        this.balance = organisationRequestBody.getBalance() == null? this.balance : organisationRequestBody.getBalance();
    }
}
