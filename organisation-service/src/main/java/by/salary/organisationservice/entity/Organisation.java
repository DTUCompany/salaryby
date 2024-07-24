package by.salary.organisationservice.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "organisations")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
