package tn.esprit.tpski_vf.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Moniteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMoniteur;

    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "moniteur_cours",
            joinColumns = @JoinColumn(name = "numMoniteur"),
            inverseJoinColumns = @JoinColumn(name = "numCours")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Cours> cours = new HashSet<>();
}
