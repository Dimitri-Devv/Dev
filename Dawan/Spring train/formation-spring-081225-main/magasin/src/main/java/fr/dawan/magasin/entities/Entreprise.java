package fr.dawan.magasin.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "entreprises")
public class Entreprise extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(nullable = false, name = "date_creation")
    private LocalDate dateCreation;

    @ToString.Exclude
    @OneToMany(mappedBy="entreprise")
    private Set<Employe> employes=new HashSet<>();

    // Relation unidirectionnel avec un OneToMany
//    @OneToMany
//    @JoinColumn(name="entreprise_id")
//    private Set<Employe> employes = new HashSet<>();
    @ToString.Exclude
    @ManyToMany(mappedBy="entreprises")
    private Set<Ville> villes=new HashSet<>();
}
