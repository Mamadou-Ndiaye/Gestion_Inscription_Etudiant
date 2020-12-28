package com.ucad.sn.service;

import com.ucad.sn.dao.EtudiantRepository;
import com.ucad.sn.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    EtudiantRepository etudiantRepository;
    @GetMapping(path = "/all")
    List<Etudiant> list()
    {
        return  etudiantRepository.findAll();
    }
    @GetMapping(path = "/oneetudiant/{id}")
    Optional<Etudiant> getOne(@PathVariable Long id)
    {
        return etudiantRepository.findById(id);
    }
    @PostMapping(path = "/new")
    Etudiant save(@RequestBody Etudiant etudiant)
    {
         Optional<Etudiant> etudiantExist= getOne(etudiant.getId());
         if(etudiantExist==null)
         { return  etudiantRepository.save(etudiant);}
         throw  new  RuntimeException ("l Etudiant avec le numero "+ etudiant.getId()+ " existe deja");
    }
    @DeleteMapping(path = "/delete/{id}")
    void delete(@PathVariable long id)
    {
          etudiantRepository.deleteById(id);
    }
    @PutMapping(path = "/update/{id}")
    Etudiant update(@PathVariable Long id,@RequestBody Etudiant etudiant)
    {
        etudiant.setId(id);
        return etudiantRepository.save(etudiant);
    }
}
