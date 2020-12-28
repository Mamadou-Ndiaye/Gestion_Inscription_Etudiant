package com.ucad.sn.projection;


import com.ucad.sn.entities.Etudiant;
import org.springframework.data.rest.core.config.Projection;


// On demande au Web Service de nous donner les elements
// d'ont on a besoin,ici il nous donne  Nom ,Prenom
// On peut avoir +sieurs projection selon nos besoin
// Dans ce cas il n est pas trop interessant de creer des projections
// On pouvait s'en passer
@Projection(name="mobile",types= Etudiant.class)
public interface EtudiantProjection {
    String getNom();
    String  getPrenom();
}


