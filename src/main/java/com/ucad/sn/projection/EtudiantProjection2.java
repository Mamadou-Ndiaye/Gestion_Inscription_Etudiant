package com.ucad.sn.projection;

import com.ucad.sn.entities.Etudiant;
import org.springframework.data.rest.core.config.Projection;


// On demande au Web Service de nous donner les elements
// d'ont on a besoin,ici il nous donne  Nom ,Prenom,NumeroEtudiant
// On peut avoir +sieurs projection selon nos besoin
// Dans ce cas il n est pas trop interessant de creer des projections
// On pouvait s'en passer
// Pour y acceder on met    http://localhost:9090/etudiants/?projection=web
// C est comme dans le relationnelle quand on met Select *  ,il nous retourne tout
// Et si on met Select nom,prenom  ,on obtient que nom et prenom
@Projection(name="web",types= Etudiant.class)
public interface EtudiantProjection2 {
        String getNom();
        String  getPrenom();
        String getNumeroEtudiant();

}
