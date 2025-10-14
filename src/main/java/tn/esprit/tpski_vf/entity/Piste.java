package tn.esprit.tpski_vf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;

    private String nomPiste;

    @Enumerated(EnumType.STRING)
    private Couleur couleur;

    private Integer longueur; // en km ou m suivant ton choix (diagramme indique int)
    private Integer pente;    // dénivelé (int)

    // Many-to-Many inverse
    @Builder.Default
    @ManyToMany(mappedBy = "pistes")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Set<Skieur> skieurs = new HashSet<>();
}
