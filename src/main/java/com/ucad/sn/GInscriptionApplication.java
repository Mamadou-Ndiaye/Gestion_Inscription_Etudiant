package com.ucad.sn;

import com.ucad.sn.dao.EtudiantRepository;
import com.ucad.sn.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class GInscriptionApplication {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration; // on veut exposer l'ID

    public static void main(String[] args) {
        SpringApplication.run(GInscriptionApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EtudiantRepository etudiantRepository)
    {
        return  args -> {
            repositoryRestConfiguration.exposeIdsFor(Etudiant.class);// expose de Id
             etudiantRepository.save( new Etudiant(null,"20150NO10","Mamadou","ndiaye"));
             etudiantRepository.findAll().forEach(etudiant -> {
                 System.out.print(etudiant.toString());
             });
        };
    }

}
