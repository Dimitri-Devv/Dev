package fr.dawan.magasin.entities.ateliers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.dawan.magasin.entities.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="utilisateurs")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length=60,nullable=false)
    private String prenom;

    @Column(length=60,nullable=false)
    private String nom;

    @Column(nullable=false)
    private String adresse;
    
    @Column(name="date_naissance", nullable=false)
    private LocalDate dateNaissance;

    @Column(length=200,nullable=false)
    private String email;

    @Column(length=80,nullable=false)
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private Set<Commande> commandes=new HashSet<>();
    
}
