package by.salary.agreementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agreements")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String agreementName;

    @JoinColumn(name = "agreementId")
    @OneToMany
    private ArrayList<AgreementList> agreementLists;

}
