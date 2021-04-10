package com.ucad.sn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, length=50)
    String numeroEtudiant;
    String prenom;
    String nom;


}
