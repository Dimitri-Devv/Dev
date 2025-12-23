package fr.dawan.magasin.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "villes")
public class Ville extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length = 150, nullable = false)
    private String nom;
    
    @OneToOne
    private Maire maire;
    
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name="ville2entreprise",
     joinColumns = @JoinColumn(name="fk_ville"),
     inverseJoinColumns = @JoinColumn(name="fk_entreprise"))
    private Set<Entreprise> entreprises=new HashSet<>();
}
