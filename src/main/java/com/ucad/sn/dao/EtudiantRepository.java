package com.ucad.sn.dao;

import com.ucad.sn.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    // Une methode pour chercher par nom si on ne precise pas @Param("kw") par defaut il prend le nom du variable c'est a dire nom
    // De meme que @RestResourceon utilise findByNomContains
    // Pour acces http://localhost:9090/etudiants/search/byNom?kw=Modou
    @RestResource(path = "/byNom")
    Page<Etudiant> findByNomContains(@Param("kw") String nom, Pageable pageable);

}
