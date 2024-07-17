package by.salary.agreementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
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
