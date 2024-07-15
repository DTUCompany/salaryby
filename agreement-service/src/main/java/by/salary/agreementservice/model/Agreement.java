package by.salary.agreementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agreements")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
