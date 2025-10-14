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
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;

    private Integer niveau; // ex: 1 = 1ère étoile, etc.

    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    private Support support;

    private Double prix;

    private Integer creneau; // 1 = matin, 2 = après-midi

    @ManyToOne
    @JoinColumn(name = "moniteur_id")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Moniteur moniteur;

    @Builder.Default
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Set<Inscription> inscriptions = new HashSet<>();
}
