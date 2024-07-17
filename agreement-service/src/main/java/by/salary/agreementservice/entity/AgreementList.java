package by.salary.agreementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AgreementList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "agreementId")
    @ManyToOne
    private Agreement agreement;

    private String agreementListName;

    @JoinColumn(name = "agreementListId")
    @OneToMany
    private ArrayList<AgreementState> agreementStates;
}
