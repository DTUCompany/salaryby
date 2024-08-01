package by.salary.agreementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "agreementId")
    private Agreement agreement;

    private String agreementListName;

    @OneToMany(mappedBy = "agreementList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AgreementState> agreementStates;
}
