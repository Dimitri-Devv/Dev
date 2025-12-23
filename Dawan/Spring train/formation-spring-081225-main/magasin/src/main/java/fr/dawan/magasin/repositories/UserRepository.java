package fr.dawan.magasin.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.magasin.entities.ateliers.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Select * FROM utilisateurs WHERE nom= nomRechercher
    List<User> findByNom(String nomRechecher);
    
    List<User> findByIdGreaterThan(long idMin);
    
    List<User> findByDateNaissanceBetween(LocalDate dateMin,LocalDate dateMax);
    
    //Select * FROM utilisateurs WHERE nom Between nomMin AND nomMAx
    List<User> findByNomBetween(String nomMin,String nomMax);
    
    List<User> findByNomGreaterThanAndDateNaissanceLessThan(String nomMin, LocalDate dateMax);
    
    List<User> findByEmailEndingWith(String endEmail);
    
    List<User> findByPrenomLike(String modele);
    
    List<User> findByPrenomIn(String... prenoms);

    List<User> findByEmailEndingWithOrderByDateNaissanceAscNom(String endEmail);
    
    // path expression -> jointure interne
    List<User> findByCommandesDateCommandeAfter(LocalDate dateCommandeMin);
    
    // First our Top -> limiter le nombre d'élément du résulat
    Optional<User> findTopByOrderByDateNaissance();
    
    List<User> findTop5ByOrderByDateNaissanceDesc();
    
    // Pagination
   Page<User> findByDateNaissanceAfter(LocalDate dateNaissance,Pageable page);
   
   //Page<User> findByDateNaissanceBefore(LocalDate dateNaissance,Sort tri);
   
   // sujet exist
   boolean existsByNom(String nom);
   
   // sujet count
   int countByDateNaissanceBefore(LocalDate date);
   
   // void deleteByDateNaissanceBefore(LocalDate date);
   
   // sujet delete
   int deleteByDateNaissanceBefore(LocalDate date);
   
   // JPQL -> @Query
//   @Query("SELECT u FROM User u WHERE u.dateNaissance<:dn")
//   List<User> getUserBornBefore(@Param("dn")LocalDate dateNaissance);
  
//   @Query("SELECT u FROM User u WHERE u.dateNaissance<:dateNaissance")
//   List<User> getUserBornBefore(LocalDate dateNaissance);
   
   @Query("SELECT u FROM User u WHERE u.dateNaissance<?1")
   List<User> getUserBornBefore(LocalDate dateNaissance);
}
