package tn.esprit.springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Service.iUniversiteService;
import tn.esprit.springproject.entity.Universite;

import java.util.List;


@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    private iUniversiteService universiteService;
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();

    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversites(universiteId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite e) {
       return universiteService.addUniversites(e);

    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversites(universiteId);
    }

    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite e) {
        return universiteService.updateUniversites(e);

    }
    @PostMapping("/affecter-foyer-universite")
    public Universite affecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer, @PathVariable  ("nom_universite") String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

   @GetMapping("/search")
   public ResponseEntity<List<Universite>> searchUniversites(@RequestParam("query") String query){
       return ResponseEntity.ok(universiteService.searchUniversites(query));
   }

}
