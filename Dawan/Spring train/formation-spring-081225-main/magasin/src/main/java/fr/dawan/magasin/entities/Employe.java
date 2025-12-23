package fr.dawan.magasin.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import fr.dawan.magasin.enums.Contrat;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "employes")
public class Employe extends BaseEntity {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE , generator = "emp_gen")
//    @TableGenerator(name = "emp_gen",table = "tab_gen",pkColumnName = "table_name", valueColumnName = "next_id",initialValue = 0,allocationSize = 1)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp")
//  @SequenceGenerator(name="seq_emp",sequenceName="emp_sequence",initialValue = 0, allocationSize = 1)
//        private long id;
//    
//    @Version
//    private int version;

    @Column(length = 60)
    private String prenom;

    @Column(nullable = false, length = 60)
    private String nom;

    @Column(nullable = false, name="date_naissance")
    private LocalDate dateNaissance;

    @Column(unique = true, nullable = false, length = 200)
    private String email;
    
    @Column(precision=6,scale=2) // xxxx.xx -> en SQL DECIMAL(6,2)
    private BigDecimal salaire;
    
    @Enumerated(EnumType.STRING)
    private Contrat contrat;
    
    @Lob
    @Column(length=65000)
    private byte[] photo;

    // private transient int nepaspersister;
    @Transient
    private int nepaspersister;
    
    @ElementCollection
    @CollectionTable(name="informations",joinColumns = @JoinColumn(name="fk_employe"))
    @Column(name="information")
    private List<String> infomationRh;
    
    @ElementCollection
    @CollectionTable(name="telephones",joinColumns = @JoinColumn(name="fk_employe"))
    @MapKeyColumn(name="type",length=30)
    @Column(name="telephone")
    private Map<String,String> telephones;
    
    @ManyToOne
    @JoinColumn(name="fk_entreprise")
    private Entreprise entreprise;

}
