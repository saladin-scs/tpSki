package tn.esprit.tpski_vf.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbonnement;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Double prix;
}
