package tn.esprit.tpski_vf.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription;

    private Integer numSemaine; // 1..52

    @ManyToOne
    @JoinColumn(name = "skieur_id")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Skieur skieur;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Cours cours;
}