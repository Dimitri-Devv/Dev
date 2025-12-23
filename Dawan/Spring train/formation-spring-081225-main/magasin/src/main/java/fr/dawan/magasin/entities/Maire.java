package fr.dawan.magasin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="maires")
public class Maire extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length=60,nullable=false)
    private String prenom;
    
    @Column(length=60,nullable=false)
    private String nom;
    
    @ToString.Exclude
    @OneToOne(mappedBy="maire")
    private Ville ville;
}
