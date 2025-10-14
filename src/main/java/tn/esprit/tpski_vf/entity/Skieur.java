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
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abonnement_id")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Abonnement abonnement;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "skieur_piste",
            joinColumns = @JoinColumn(name = "skieur_id"),
            inverseJoinColumns = @JoinColumn(name = "piste_id")
    )
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Set<Piste> pistes = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "skieur", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Set<Inscription> inscriptions = new HashSet<>();
}