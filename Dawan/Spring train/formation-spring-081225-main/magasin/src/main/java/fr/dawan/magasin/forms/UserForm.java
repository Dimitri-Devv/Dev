package fr.dawan.magasin.forms;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
public class UserForm {
    
    @NotBlank(message = "Le prenom ne doit être vide")
    @Size(max=60)
    private String prenom;
    
    @NotBlank
    @Size(min=2,max=60)
    private String nom;
    
    @NotBlank
    @Size(max=255)
    private String adresse;
    
    @NotNull
    @Past
    private LocalDate dateNaissance;
    
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    @Size(min=6,max=80)
    private String password;
}
