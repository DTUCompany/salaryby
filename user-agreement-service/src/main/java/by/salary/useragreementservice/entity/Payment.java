package by.salary.useragreementservice.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long moderatorId;
    private String moderatorComment;
    private Double price;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

}
